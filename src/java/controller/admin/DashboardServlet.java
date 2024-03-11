/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.CategoryDAO;
import dal.ColorDAO;
import dal.CommentDAO;
import dal.FeedBackDAO;
import dal.OrderDAO;
import dal.OrderDetailDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import dal.SupperlierDAO;
import dal.UserDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Category;
import model.Color;
import model.Comment;
import model.FeedBack;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.Size;
import model.Supperlier;
import model.User;
import model.Wallet;

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
        SizeDAO sizeDAO = new SizeDAO();
        ColorDAO colorDAO = new ColorDAO();
        OrderDetailDAO odd = new OrderDetailDAO();
        CommentDAO cmd = new CommentDAO();
        WalletDAO wd = new WalletDAO();
        FeedBackDAO fd = new FeedBackDAO();

        Map<User, Float> getTopUserByTotalMoney = ud.getTopUserByTotalMoney();
        List<Product> getTop3ProductBestSelling = pd.getTop3Product();
        Map<Order, Integer> getTop5OrderRecent = od.getTop5OrderByRecent();
        List<Order> getOrderAll = od.getOrderAll();
        List<User> getUserAll = ud.getUserAll();
        List<Product> getProductAll = pd.getProductAll();
        List<Supperlier> getSupperlierAll = sd.getSupperlierAll();
        List<Category> getCategoryAll = cd.getCategoryAll();
        Map<Category, Integer> getTotalProductSoldByCategory = pd.getTotalProductSoldByAllCategory();
        Map<User, Integer> getTotalBuyByUser = ud.getUserAllAndTotalBuy();
        Map<Category, Integer> getTotalProductByCategory = cd.getNumberOfProductbyCategory();
        List<Size> getSizeAll = sizeDAO.getSizeAll();
        List<Color> getColorAll = colorDAO.getColorAll();
        List<Comment> getCommentAll = cmd.getCommentAll();
        List<Wallet> getWalletAll = wd.getWalletAll();
        // so dau tien trong list dai dien cho so san pham cua moi category, so thu 2 dai dien cho so san pham ban duoc cua moi category
        Map<Category, List<Integer>> getNumbeOfProductAndNumberOfProductSoldByCategory = cd.getNumberOfProductAndNumberOfProductSoldByCategory();
        List<FeedBack> getFeedBackAll = fd.getFeedBackAll();

        Map<Order, List<OrderDetail>> ListAllOrderAndOrderDetail = new LinkedHashMap<>();
        ListAllOrderAndOrderDetail = odd.getAllOrderAndOrderDetail();

        int totalProductSold = 0;
        int totalProductSoldByCategory = 0;
        int totalUser = 0;

        // lay ve tong user voi role la user
        for (User user : getUserAll) {
            if (user.getRole().getName().equalsIgnoreCase("user")) {
                totalUser++;
            }
        }

        // lay ve tong san pham da ban thanh cong
        for (Product p : getProductAll) {
            totalProductSold += p.getQuantitySold();
        }

        // xu li lay ve tong so user da dang nhap vao trang web
        int totalUserActivity = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie userActivity = null;
            for (Cookie c : cookies) {
                if (c.getName().equalsIgnoreCase("userActivity")) {
                    userActivity = c;
                    break;
                }
            }
            if (userActivity != null) {
                String[] userIdActivity = userActivity.getValue().split("&");
                totalUserActivity = userIdActivity.length;
            }
        }

        session.setAttribute("topUserByTotalMoney", getTopUserByTotalMoney);
        session.setAttribute("top3ProductBestSelling", getTop3ProductBestSelling);
        session.setAttribute("top5OrderRecent", getTop5OrderRecent);
        session.setAttribute("revenue", od.getRevennue());
        session.setAttribute("orderAll", getOrderAll);
        session.setAttribute("userAll", getUserAll);
        session.setAttribute("totalUser", totalUser);
        session.setAttribute("productAll", getProductAll);
        session.setAttribute("totalProductSold", totalProductSold);
        session.setAttribute("supperlierAll", getSupperlierAll);
        session.setAttribute("categoryAll", getCategoryAll);
        session.setAttribute("totalProductSoldByCategory", getTotalProductSoldByCategory);
        session.setAttribute("totalUserActivity", totalUserActivity);
        session.setAttribute("totalBuyByUser", getTotalBuyByUser);
        session.setAttribute("totalProductByCategory", getTotalProductByCategory);
        session.setAttribute("mainCategory", getNumbeOfProductAndNumberOfProductSoldByCategory);
        session.setAttribute("sizeAll", getSizeAll);
        session.setAttribute("colorAll", getColorAll);
        session.setAttribute("ListAllOrderAndOrderDetail", ListAllOrderAndOrderDetail);
        session.setAttribute("commentAll", getCommentAll);
        session.setAttribute("walletAll", getWalletAll);
        session.setAttribute("feedbackAll", getFeedBackAll);

        // lay du lieu cho bieu do orders overview
        int totalComplated = od.getTotalOrderByStatus(1);
        int totalPending = od.getTotalOrderByStatus(0);
        int totalCancel = od.getTotalOrderByStatus(2);

        session.setAttribute("totalComplated", totalComplated);
        session.setAttribute("totalPending", totalPending);
        session.setAttribute("totalCancel", totalCancel);

        request.getRequestDispatcher("/views/admin/dashboard/dashboard.jsp").forward(request, response);
    }

}
