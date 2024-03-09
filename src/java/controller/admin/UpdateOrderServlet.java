/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.OrderDAO;
import dal.OrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateOrderServlet", urlPatterns = {"/updateorder"})
public class UpdateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO od = new OrderDAO();
        OrderDetailDAO odd = new OrderDetailDAO();
        HttpSession session = request.getSession();

        String status_raw = request.getParameter("status");
        String orderId_raw = request.getParameter("orderId");
        try {
            int status = Integer.parseInt(status_raw);
            int orderId = Integer.parseInt(orderId_raw);
            od.updateOrder(status, orderId);

            Map<Order, List<OrderDetail>> ListAllOrderAndOrderDetail = odd.getAllOrderAndOrderDetail();
            session.setAttribute("ListAllOrderAndOrderDetail", ListAllOrderAndOrderDetail);
            
            String previousPage = request.getHeader("referer");
            if (previousPage != null && !previousPage.isEmpty()) {
                System.out.println(previousPage);
                response.sendRedirect(previousPage);
            } else {
                System.out.println("Không có trang trước đó hoặc không thể xác định.");
            }
        } catch (NumberFormatException e) {
            System.out.println("loi chuyen doi so");
        }
    }

}
