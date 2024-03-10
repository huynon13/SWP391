/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.FeedBackDAO;
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
@WebServlet(name = "AddContactUsServlet", urlPatterns = {"/addcontactus"})
public class AddContactUsServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId_raw = request.getParameter("userId");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        
        FeedBackDAO fd = new FeedBackDAO();
        
        System.out.println(userId_raw);
        System.out.println(subject);
        System.out.println(message);
        
        try {
            int userId = Integer.parseInt(userId_raw);
            fd.insertFeedBack(userId, subject, message);
            response.sendRedirect("views/user/item-page/feedbacksuccess.jsp");
        } catch (NumberFormatException e) {
            System.out.println("loi chuyen doi so");
        }
    }
    
}
