/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.CategoryDAO;
import dal.ColorDAO;
import dal.FeedBackDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import model.Category;
import model.Color;
import model.FeedBack;
import model.Product;
import model.Size;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CategoryDAO cd = new CategoryDAO();
        ProductDAO pd = new ProductDAO();
        FeedBackDAO fd = new FeedBackDAO();
        SizeDAO sd = new SizeDAO();
        ColorDAO colorD = new ColorDAO();
        UserDAO ud = new UserDAO();

        Map<Category, List<Product>> top5ProductByCategor = cd.getTop5ProductByCategory();
        Map<Category, Integer> numberOfProduct = cd.getNumberOfProductbyCategory();
        List<Product> top10Bestseller = pd.top10Bestseller();
        List<FeedBack> listFeedBack = fd.getFeedBackAll();
        List<Category> listCategory = cd.getCategoryAll();
        List<Product> listProduct = pd.getProductAll();
        List<Product> listTop6NewProductAll = pd.getTop6NewProductAll();
        Map<Category, List<Product>> top6NewProductByCategory = pd.getTop6NewProduct();
        List<Size> listSize = sd.getSizeAll();
        List<Color> listColor = colorD.getColorAll();

        double minPrice = Double.MAX_VALUE, maxPrice = Double.MIN_VALUE;
        for (Product p : listProduct) {
            if (minPrice > p.getPrice()) {
                minPrice = p.getPrice();
            }
            if (maxPrice < p.getPrice()) {
                maxPrice = p.getPrice();
            }
        }

        // xu li remember me
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equalsIgnoreCase("rememberMe")) {
                    String idRememberMe_raw = c.getValue();
                    int idRememberMe = Integer.parseInt(idRememberMe_raw);
                    User userRememberMe = ud.getUserById(idRememberMe);
                    session.setAttribute("account", userRememberMe);
                    break;
                }
            }
        }

        session.setAttribute("top5ProductByCategory", top5ProductByCategor);
        session.setAttribute("numberOfProductByCategory", numberOfProduct);
        session.setAttribute("top10Bestseller", top10Bestseller);
        session.setAttribute("listCategory", listCategory);
        session.setAttribute("listProduct", listProduct);
        session.setAttribute("minPrice", minPrice);
        session.setAttribute("maxPrice", maxPrice);
        session.setAttribute("feedBackAll", listFeedBack);
        session.setAttribute("listTop6NewProductAll", listTop6NewProductAll);
        session.setAttribute("top6NewProductByCategory", top6NewProductByCategory);
        session.setAttribute("listSize", listSize);
        session.setAttribute("listColor", listColor);
        request.getRequestDispatcher("./views/user/home-page/homepage.jsp").forward(request, response);
    }

}
