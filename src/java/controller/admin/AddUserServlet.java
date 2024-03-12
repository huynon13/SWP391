/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.RoleDAO;
import dal.UserDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import java.sql.Date;
import java.util.List;
import model.Wallet;

/**
 *
 * @author PC
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/adduser"})
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String image = request.getParameter("addressImage");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("passWord");
        String email = request.getParameter("email");
        String birthDate_raw = request.getParameter("birthDate");
        String address = request.getParameter("address");
        String phoneNumber_raw = request.getParameter("phoneNumber");
        String role_raw = request.getParameter("role");

        UserDAO ud = new UserDAO();
        RoleDAO rd = new RoleDAO();

        int role = rd.getRoleIdByRoleName(role_raw);

        String fullName = lastName + " " + firstName;
        if (fullName != null) {
            fullName = fullName.trim();
        }

        boolean checkUserName = checkDauCachUserName(userName);
        boolean checkFirstDigit = checkFirstDigit(userName);
        boolean checkVietNam = isVietnamese(userName);
        boolean checkUserNameExit = ud.getUserByUserName(userName);

        if (checkFirstDigit) {
            request.setAttribute("insertUserError", "UserName is not first digit, please re-enter");
            request.getRequestDispatcher("views/admin/item-page/userlist.jsp").forward(request, response);
        } else if (checkUserName == false) {
            request.setAttribute("insertUserError", "UserName is incorrect, please re-enter");
            request.getRequestDispatcher("views/admin/item-page/userlist.jsp").forward(request, response);

        } else if (checkVietNam == false) {
            request.setAttribute("insertUserError", "UserName cannot contain accented characters, please re-enter");
            request.getRequestDispatcher("views/admin/item-page/userlist.jsp").forward(request, response);

        } else if (checkUserNameExit == true) {
            request.setAttribute("insertUserError", "UserName already exists , please re-enter");
            request.getRequestDispatcher("views/admin/item-page/userlist.jsp").forward(request, response);

        } else {
            ud.insertUser(role, userName, password, fullName, birthDate_raw, image, phoneNumber_raw, address, email, null, 0);
            WalletDAO wd = new WalletDAO();
            int userId = ud.getUserIdByUserName(userName);
            
            wd.insertWallet(userId);
            
            List<Wallet> getWalletAll = wd.getWalletAll();
            session.setAttribute("walletAll", getWalletAll);
            
            response.sendRedirect("adduser");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("insertUserSucc", "Added user successfully!!!");
        HttpSession session = request.getSession();
        UserDAO ud = new UserDAO();
        List<User> getUserAll = ud.getUserAll();
        session.setAttribute("userAll", getUserAll);
        request.getRequestDispatcher("views/admin/item-page/userlist.jsp").forward(request, response);
    }

    private boolean checkFirstDigit(String name) {
        if (Character.isDigit(name.charAt(0))) {
            return true;
        }
        return false;
    }

    private boolean checkDauCachUserName(String name) {
        String[] word = name.split("\\s+");
        String nameTemp = "";
        for (String x : word) {
            nameTemp += x;
        }
        nameTemp = nameTemp.trim();
        if (nameTemp.equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isVietnamese(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPhoneNumber(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (Character.isDigit(phone.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
