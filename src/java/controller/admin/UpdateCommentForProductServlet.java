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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Comment;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateCommentForProductServlet", urlPatterns = {"/updatecommentforproduct"})
public class UpdateCommentForProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentDAO cmd = new CommentDAO();

        String action = request.getParameter("action");
        String userId_raw = request.getParameter("userId");
        String productId_raw = request.getParameter("productId");
        int userId = Integer.parseInt(userId_raw);
        int productId = Integer.parseInt(productId_raw);

        if (action.equalsIgnoreCase("update")) {

            String rating_raw = request.getParameter("rating");
            String content = request.getParameter("content");
            try {
                int rating = Integer.parseInt(rating_raw);
                cmd.updateCommentByUserAndProduct(userId, productId, rating, content);
            } catch (NumberFormatException e) {
                System.out.println("loi chuyen doi so: " + e);
            }
        } else {
            cmd.deleteCommentByUserAndProduct(userId, productId);
        }
        HttpSession session = request.getSession();
        List<Comment> getCommentAll = cmd.getCommentAll();
        session.setAttribute("commentAll", getCommentAll);

        // lay ve dia chi cua trang truoc do
        String previousPage = request.getHeader("referer");
        if (previousPage != null && !previousPage.isEmpty()) {
            System.out.println(previousPage);
            response.sendRedirect(previousPage);
        } else {
            System.out.println("Không có trang trước đó hoặc không thể xác định.");
        }
    }

}
