/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CommentDAO;
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
@WebServlet(name = "ReviewReportChartServlet", urlPatterns = {"/reviewreportchart"})
public class ReviewReportChartServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year_raw = request.getParameter("year");

        CommentDAO cmd = new CommentDAO();
        OrderDAO od = new OrderDAO();
        if (year_raw == null) {
            year_raw = "" + od.getYear();
        }

        try {
            int year = Integer.parseInt(year_raw);
            int month1star1 = cmd.getNumberStartByMonth(1, year, 1);
            int month1star2 = cmd.getNumberStartByMonth(1, year, 2);
            int month1star3 = cmd.getNumberStartByMonth(1, year, 3);
            int month1star4 = cmd.getNumberStartByMonth(1, year, 4);
            int month1star5 = cmd.getNumberStartByMonth(1, year, 5);

            int month2star1 = cmd.getNumberStartByMonth(2, year, 1);
            int month2star2 = cmd.getNumberStartByMonth(2, year, 2);
            int month2star3 = cmd.getNumberStartByMonth(2, year, 3);
            int month2star4 = cmd.getNumberStartByMonth(2, year, 4);
            int month2star5 = cmd.getNumberStartByMonth(2, year, 5);

            int month3star1 = cmd.getNumberStartByMonth(3, year, 1);
            int month3star2 = cmd.getNumberStartByMonth(3, year, 2);
            int month3star3 = cmd.getNumberStartByMonth(3, year, 3);
            int month3star4 = cmd.getNumberStartByMonth(3, year, 4);
            int month3star5 = cmd.getNumberStartByMonth(3, year, 5);

            int month4star1 = cmd.getNumberStartByMonth(4, year, 1);
            int month4star2 = cmd.getNumberStartByMonth(4, year, 2);
            int month4star3 = cmd.getNumberStartByMonth(4, year, 3);
            int month4star4 = cmd.getNumberStartByMonth(4, year, 4);
            int month4star5 = cmd.getNumberStartByMonth(4, year, 5);

            int month5star1 = cmd.getNumberStartByMonth(5, year, 1);
            int month5star2 = cmd.getNumberStartByMonth(5, year, 2);
            int month5star3 = cmd.getNumberStartByMonth(5, year, 3);
            int month5star4 = cmd.getNumberStartByMonth(5, year, 4);
            int month5star5 = cmd.getNumberStartByMonth(5, year, 5);

            int month6star1 = cmd.getNumberStartByMonth(6, year, 1);
            int month6star2 = cmd.getNumberStartByMonth(6, year, 2);
            int month6star3 = cmd.getNumberStartByMonth(6, year, 3);
            int month6star4 = cmd.getNumberStartByMonth(6, year, 4);
            int month6star5 = cmd.getNumberStartByMonth(6, year, 5);

            int month7star1 = cmd.getNumberStartByMonth(7, year, 1);
            int month7star2 = cmd.getNumberStartByMonth(7, year, 2);
            int month7star3 = cmd.getNumberStartByMonth(7, year, 3);
            int month7star4 = cmd.getNumberStartByMonth(7, year, 4);
            int month7star5 = cmd.getNumberStartByMonth(7, year, 5);

            int month8star1 = cmd.getNumberStartByMonth(8, year, 1);
            int month8star2 = cmd.getNumberStartByMonth(8, year, 2);
            int month8star3 = cmd.getNumberStartByMonth(8, year, 3);
            int month8star4 = cmd.getNumberStartByMonth(8, year, 4);
            int month8star5 = cmd.getNumberStartByMonth(8, year, 5);

            int month9star1 = cmd.getNumberStartByMonth(9, year, 1);
            int month9star2 = cmd.getNumberStartByMonth(9, year, 2);
            int month9star3 = cmd.getNumberStartByMonth(9, year, 3);
            int month9star4 = cmd.getNumberStartByMonth(9, year, 4);
            int month9star5 = cmd.getNumberStartByMonth(9, year, 5);

            int month10star1 = cmd.getNumberStartByMonth(10, year, 1);
            int month10star2 = cmd.getNumberStartByMonth(10, year, 2);
            int month10star3 = cmd.getNumberStartByMonth(10, year, 3);
            int month10star4 = cmd.getNumberStartByMonth(10, year, 4);
            int month10star5 = cmd.getNumberStartByMonth(10, year, 5);

            int month11star1 = cmd.getNumberStartByMonth(11, year, 1);
            int month11star2 = cmd.getNumberStartByMonth(11, year, 2);
            int month11star3 = cmd.getNumberStartByMonth(11, year, 3);
            int month11star4 = cmd.getNumberStartByMonth(11, year, 4);
            int month11star5 = cmd.getNumberStartByMonth(11, year, 5);

            int month12star1 = cmd.getNumberStartByMonth(12, year, 1);
            int month12star2 = cmd.getNumberStartByMonth(12, year, 2);
            int month12star3 = cmd.getNumberStartByMonth(12, year, 3);
            int month12star4 = cmd.getNumberStartByMonth(12, year, 4);
            int month12star5 = cmd.getNumberStartByMonth(12, year, 5);

            request.setAttribute("month1star1", month1star1);
            request.setAttribute("month1star2", month1star2);
            request.setAttribute("month1star3", month1star3);
            request.setAttribute("month1star4", month1star4);
            request.setAttribute("month1star5", month1star5);

            request.setAttribute("month2star1", month2star1);
            request.setAttribute("month2star2", month2star2);
            request.setAttribute("month2star3", month2star3);
            request.setAttribute("month2star4", month2star4);
            request.setAttribute("month2star5", month2star5);

            request.setAttribute("month3star1", month3star1);
            request.setAttribute("month3star2", month3star2);
            request.setAttribute("month3star3", month3star3);
            request.setAttribute("month3star4", month3star4);
            request.setAttribute("month3star5", month3star5);

            request.setAttribute("month4star1", month4star1);
            request.setAttribute("month4star2", month4star2);
            request.setAttribute("month4star3", month4star3);
            request.setAttribute("month4star4", month4star4);
            request.setAttribute("month4star5", month4star5);

            request.setAttribute("month5star1", month5star1);
            request.setAttribute("month5star2", month5star2);
            request.setAttribute("month5star3", month5star3);
            request.setAttribute("month5star4", month5star4);
            request.setAttribute("month5star5", month5star5);

            request.setAttribute("month6star1", month6star1);
            request.setAttribute("month6star2", month6star2);
            request.setAttribute("month6star3", month6star3);
            request.setAttribute("month6star4", month6star4);
            request.setAttribute("month6star5", month6star5);

            request.setAttribute("month7star1", month7star1);
            request.setAttribute("month7star2", month7star2);
            request.setAttribute("month7star3", month7star3);
            request.setAttribute("month7star4", month7star4);
            request.setAttribute("month7star5", month7star5);

            request.setAttribute("month8star1", month8star1);
            request.setAttribute("month8star2", month8star2);
            request.setAttribute("month8star3", month8star3);
            request.setAttribute("month8star4", month8star4);
            request.setAttribute("month8star5", month8star5);

            request.setAttribute("month9star1", month9star1);
            request.setAttribute("month9star2", month9star2);
            request.setAttribute("month9star3", month9star3);
            request.setAttribute("month9star4", month9star4);
            request.setAttribute("month9star5", month9star5);

            request.setAttribute("month10star1", month10star1);
            request.setAttribute("month10star2", month10star2);
            request.setAttribute("month10star3", month10star3);
            request.setAttribute("month10star4", month10star4);
            request.setAttribute("month10star5", month10star5);

            request.setAttribute("month11star1", month11star1);
            request.setAttribute("month11star2", month11star2);
            request.setAttribute("month11star3", month11star3);
            request.setAttribute("month11star4", month11star4);
            request.setAttribute("month11star5", month11star5);

            request.setAttribute("month12star1", month12star1);
            request.setAttribute("month12star2", month12star2);
            request.setAttribute("month12star3", month12star3);
            request.setAttribute("month12star4", month12star4);
            request.setAttribute("month12star5", month12star5);

            request.setAttribute("year", od.getYear());

            request.setAttribute("selected", year);

            request.getRequestDispatcher("views/admin/item-page/reviewreportchart.jsp").forward(request, response);

        } catch (Exception e) {
        }
    }

}
