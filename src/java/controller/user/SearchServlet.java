/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Product;

/**
 *
 * @author PC
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query_raw = request.getParameter("query");
        String orderBySearch = request.getParameter("orderBy");
        String page = request.getParameter("page");
        if(page == null){
            page = "1";
        }
        if (orderBySearch == null) {
            orderBySearch = "0";
        }
        String query = "";
        if (query_raw != null) {
            String[] word = query_raw.split("\\s+");
            for (String x : word) {
                query += x + " ";
            }
            query = query.trim();
        }

        ProductDAO pd = new ProductDAO();
        List<Product> listProduct = pd.getQueryProductPagination(query, orderBySearch, page);
        int totalProductByQuery = pd.getTotalProductByQuery(query);
        HttpSession session = request.getSession();
        session.setAttribute("listProduct", listProduct);
        request.setAttribute("query", query);
        request.setAttribute("orderBySearch", orderBySearch);
        request.setAttribute("totalProductByFilterOrQuery", totalProductByQuery);
        request.getRequestDispatcher("/views/user/item-page/shopdetail.jsp").forward(request, response);
    }

}
