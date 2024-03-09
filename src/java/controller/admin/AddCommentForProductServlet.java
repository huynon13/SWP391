/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CommentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "AddCommentForProductServlet", urlPatterns = {"/addcommentforproduct"})
public class AddCommentForProductServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentDAO cmd = new CommentDAO();
        
        String userId_raw = request.getParameter("userId");
        String productId_raw = request.getParameter("productId");
        String content = request.getParameter("content");
        String rating_raw = request.getParameter("rating");

        try {
            int userId = Integer.parseInt(userId_raw);
            int productId = Integer.parseInt(productId_raw);
            int rating = Integer.parseInt(rating_raw);
            cmd.insertCommentByUserAndProduct(userId, productId, content, rating);
            response.sendRedirect("productdetail?pid=" + productId);
        } catch (NumberFormatException e) {
            System.out.println("loi chuyen doi so");
        }
        
    }
    
}
