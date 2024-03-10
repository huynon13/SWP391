/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

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
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/deleteuser"})
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId_raw = request.getParameter("userId");
        UserDAO ud = new UserDAO();
        try {
            int userId = Integer.parseInt(userId_raw);
            User user = ud.getUserById(userId);
            String userName = user.getUserName();
            request.setAttribute("deleteSucc", "Delete user name: '" + user.getUserName() + "' successfully!!!");
            ud.deleteUser(userId);

            HttpSession session = request.getSession();
            List<User> getUserAll = ud.getUserAll();
            session.setAttribute("userAll", getUserAll);
            Map<User, Integer> getTotalBuyByUser = ud.getUserAllAndTotalBuy();
            session.setAttribute("totalBuyByUser", getTotalBuyByUser);
            request.setAttribute("deleteUserSuccess", "Delte UserName:" + userName + " thành công!");
            request.getRequestDispatcher("views/admin/item-page/userlist.jsp").forward(request, response);
        } catch (ServletException | IOException | NumberFormatException e) {
            System.out.println("loi o class delete user servlet: " + e);
        }
    }

}
