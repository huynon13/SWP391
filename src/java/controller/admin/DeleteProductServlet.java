/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CommentDAO;
import dal.GaleryDAO;
import dal.OrderDetailDAO;
import dal.ProductDAO;
import dal.ProductDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Galary;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author PC
 */
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deleteproduct"})
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDAO pd = new ProductDAO();
        

        String productId_raw = request.getParameter("productId");
        try {
            int productId = Integer.parseInt(productId_raw);
           
            pd.deleteProductByProductId(productId);
            
            request.setAttribute("deleteSuccess", "Đã xóa product thành công!!!");

            List<Product> getProductAll = pd.getProductAll();
            session.setAttribute("productAll", getProductAll);

            request.getRequestDispatcher("views/admin/item-page/productlist.jsp").forward(request, response);
        } catch (ServletException | IOException | NumberFormatException e) {
            System.out.println("loi chuyen doi so: " + e);
        }
    }

}
