/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.FeedBackDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.FeedBack;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateContactUsServlet", urlPatterns = {"/updatecontactus"})
public class UpdateContactUsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FeedBackDAO fd = new FeedBackDAO();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String feedbackId_raw = request.getParameter("feedbackId");
        try {
            int feedbackId = Integer.parseInt(feedbackId_raw);
            if (action.equals("delete")) {
                fd.deleteFeedbackById(feedbackId);
                List<FeedBack> getFeedBackAll = fd.getFeedBackAll();
                session.setAttribute("feedbackAll", getFeedBackAll);
                response.sendRedirect("views/admin/item-page/feedback.jsp");
            } else {
                String subject = request.getParameter("subject");
                String message = request.getParameter("message");
                fd.updateFeedbackById(subject, message, feedbackId);
                List<FeedBack> getFeedBackAll = fd.getFeedBackAll();
                session.setAttribute("feedbackAll", getFeedBackAll);
                request.setAttribute("updateFeedBackSuccess", "Bạn đã cập nhật phản hồi thành công, chúc bạn có 1 ngày tốt lành");
                request.getRequestDispatcher("views/user/item-page/contactus.jsp").forward(request, response);
            }
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("loi chuyen doi so: " + e);
        }
    }

}
