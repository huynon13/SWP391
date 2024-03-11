/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.OrderDAO;
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
@WebServlet(name = "SalesReportChartServlet", urlPatterns = {"/salesreportchart"})
public class SalesReportChartServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO od = new OrderDAO();
        
        String year_raw = request.getParameter("year");
        if (year_raw == null) {
            year_raw = od.getYear() + "";
        }
        try {
            int year = Integer.parseInt(year_raw);
            float month1 = od.getRevennueByMonth(1, year);
            float month2 = od.getRevennueByMonth(2, year);
            float month3 = od.getRevennueByMonth(3, year);
            float month4 = od.getRevennueByMonth(4, year);
            float month5 = od.getRevennueByMonth(5, year);
            float month6 = od.getRevennueByMonth(6, year);
            float month7 = od.getRevennueByMonth(7, year);
            float month8 = od.getRevennueByMonth(8, year);
            float month9 = od.getRevennueByMonth(9, year);
            float month10 = od.getRevennueByMonth(10, year);
            float month11 = od.getRevennueByMonth(11, year);
            float month12 = od.getRevennueByMonth(12, year);
            
            request.setAttribute("month1", month1);
            request.setAttribute("month2", month2);
            request.setAttribute("month3", month3);
            request.setAttribute("month4", month4);
            request.setAttribute("month5", month5);
            request.setAttribute("month6", month6);
            request.setAttribute("month7", month7);
            request.setAttribute("month8", month8);
            request.setAttribute("month9", month9);
            request.setAttribute("month10", month10);
            request.setAttribute("month11", month11);
            request.setAttribute("month12", month12);
            
            request.setAttribute("year", od.getYear());
            
            request.setAttribute("selected", year);
            
            request.getRequestDispatcher("views/admin/item-page/salesreportchart.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            System.out.println("loi chuyen doi year trong sales report chart servlet: " + e);
        }
    }
    
}
