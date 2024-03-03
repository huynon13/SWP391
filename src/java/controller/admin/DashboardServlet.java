/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CategoryDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import dal.SupperlierDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import model.Category;
import model.Order;
import model.Product;
import model.Supperlier;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO ud = new UserDAO();
        ProductDAO pd = new ProductDAO();
        OrderDAO od = new OrderDAO();
        SupperlierDAO sd = new SupperlierDAO();
        CategoryDAO cd = new CategoryDAO();
        
        Map<User, Float> getTopUserByTotalMoney = ud.getTopUserByTotalMoney();
        List<Product> getTop3ProductBestSelling = pd.getTop3Product();
        Map<Order, Integer> getTop5OrderRecent = od.getTop5OrderByRecent();
        List<Order> getOrderAll = od.getOrderAll();
        List<User> getUserAll = ud.getUserAll();
        List<Product> getProductAll = pd.getProductAll();
        List<Supperlier> getSupperlierAll = sd.getSupperlierAll();
        List<Category> getCategoryAll = cd.getCategoryAll();
        Map<Category, Integer> getTotalProductSoldByCategory = pd.getTotalProductSoldByAllCategory();
        int totalProductSold = 0;
        int totalProductSoldByCategory = 0;
        
        for(Product p : getProductAll){
            totalProductSold += p.getQuantitySold();
        }
        
        for(Category c : getCategoryAll){
            
        }
        
        session.setAttribute("topUserByTotalMoney", getTopUserByTotalMoney);
        session.setAttribute("top3ProductBestSelling", getTop3ProductBestSelling);
        session.setAttribute("top5OrderRecent", getTop5OrderRecent);
        session.setAttribute("revenue", od.getRevennue());
        session.setAttribute("orderAll", getOrderAll);
        session.setAttribute("userAll", getUserAll);
        session.setAttribute("productAll", getProductAll);
        session.setAttribute("totalProductSold", totalProductSold);
        session.setAttribute("supperlierAll", getSupperlierAll);
        session.setAttribute("categoryAll", getCategoryAll);
        session.setAttribute("totalProductSoldByCategory", getTotalProductSoldByCategory);
        request.getRequestDispatcher("/views/admin/dashboard/dashboard.jsp").forward(request, response);
    }

}
