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
import java.util.List;
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
            int quantitySoldByColorAndSize = pd.getQuantitySoldProductByColorAndSize(productId, colorId, sizeId);
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
            for (Product x : relatedProduct) {
                System.out.println(x);
            }
            session.setAttribute("product", product);
            session.setAttribute("relatedProduct", relatedProduct);
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
