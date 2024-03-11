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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.CookieStore;
import java.util.List;
import model.Product;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "WishListServlet", urlPatterns = {"/wishlist"})
public class WishListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO pd = new ProductDAO();
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");

        String productId_raw = request.getParameter("productid");
        String action = request.getParameter("action");
        try {
            int productId = Integer.parseInt(productId_raw);
            Product p = pd.getProductById(productId);

            // tim kiem xem trong session da co product nay chua
            Cookie[] cookies = request.getCookies();
            List<Product> listWishList = (List<Product>) session.getAttribute("wishList");
            int danhDauProduct = -1;
            for (int i = 0; i < listWishList.size(); i++) {
                if (listWishList.get(i).getProductId() == productId) {
                    danhDauProduct = i;
                    break;
                }
            }
            if (action.equals("add")) {
                if (danhDauProduct == -1) {
                    listWishList.add(p);
                }
            } else {
                listWishList.remove(danhDauProduct);
            }
            String wishListCookieValue = "";
            for (int i = 0; i < listWishList.size(); i++) {
                if (i != listWishList.size() - 1) {
                    wishListCookieValue += listWishList.get(i).getProductId() + "&";
                } else {
                    wishListCookieValue += listWishList.get(i).getProductId();
                }
            }
            Cookie c = new Cookie("wishList" + account.getUserId(), wishListCookieValue);
            c.setMaxAge(60 * 60 * 24 * 60);
            response.addCookie(c);

            session.setAttribute("wishList", listWishList);
            if (action.equalsIgnoreCase("delete")) {
                response.sendRedirect("views/user/item-page/wishlist.jsp");
            } else {
                String previousPage = request.getHeader("referer");
                if (previousPage != null && !previousPage.isEmpty()) {
                    System.out.println(previousPage);
                    response.sendRedirect(previousPage);
                } else {
                    System.out.println("Không có trang trước đó hoặc không thể xác định.");
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("loi chuyen doi so class wishlist servlet");
        }

    }

}
