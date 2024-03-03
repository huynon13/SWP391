/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.ColorDAO;
import dal.CommentDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import model.Color;
import model.Comment;
import model.Product;
import model.Size;

/**
 *
 * @author PC
 */
@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/productdetail"})
public class ProductDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String colorId_raw = request.getParameter("colorid");
        String sizeId_raw = request.getParameter("sizeid");
        String productId_raw = request.getParameter("productid");
        ProductDAO pd = new ProductDAO();
        try {
            int colorId = Integer.parseInt(colorId_raw);
            int sizeId = Integer.parseInt(sizeId_raw);
            int productId = Integer.parseInt(productId_raw);
            int quantityStockByColorAndSize = pd.getQuantityStockProductByColorAndSize(colorId, sizeId, productId);
            System.out.println("quantitystock: " + quantityStockByColorAndSize);
            int quantitySoldByColorAndSize = pd.getQuantitySoldProductByColorAndSize(productId, colorId, sizeId);
            System.out.println("quantitysold: " + quantitySoldByColorAndSize);
            request.setAttribute("quantityStockByColorAndSize", quantityStockByColorAndSize);
            request.setAttribute("quantitySoldByColorAndSize", quantitySoldByColorAndSize);
            request.getRequestDispatcher("views/user/item-page/productdetail.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId_raw = request.getParameter("pid");
        HttpSession session = request.getSession();
        try {
            int productId = Integer.parseInt(productId_raw);
            ProductDAO pd = new ProductDAO();
            CommentDAO cd = new CommentDAO();
            SizeDAO sd = new SizeDAO();
            ColorDAO colorD = new ColorDAO();
            List<Comment> listCommentByProductId = cd.getCommentByProductId(productId);
            List<Size> listSize = sd.getSizeAll();
            List<Color> listColor = colorD.getColorAll();
            Product product = pd.getProductById(productId);
            List<Product> relatedProduct = pd.getRelatedProductByCategory(product.getProductId(), product.getCategory().getCategoryId());

            List<Product> viewedProduct;
            if ((List<Product>) session.getAttribute("viewedProduct") != null) {
                viewedProduct = (List<Product>) session.getAttribute("viewedProduct");
            } else {
                viewedProduct = new ArrayList<>();
            }
            
            boolean checkedProduct = false;
            Product temp = null;
            for (Product p : viewedProduct) {
                if (product.getProductId() == p.getProductId()) {
                    checkedProduct = true;
                    temp = p;
                    break;
                }
            }
            
            if (checkedProduct) {
                viewedProduct.remove(temp);
            }

            viewedProduct.add(product);

            session.setAttribute("product", product);
            session.setAttribute("relatedProduct", relatedProduct);
            session.setAttribute("viewedProduct", viewedProduct);

            session.setAttribute("listComment", listCommentByProductId);
            session.setAttribute("listSize", listSize);
            session.setAttribute("listColor", listColor);
            request.getRequestDispatcher("views/user/item-page/productdetail.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println("xxxx");
            System.err.println("loi chuyen doi so");
        }
    }
}
