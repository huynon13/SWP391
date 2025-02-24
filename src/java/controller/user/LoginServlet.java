/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

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
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String passoword = request.getParameter("password");
       
        String rememberMe = request.getParameter("rememberme");
        System.out.println(rememberMe);
        UserDAO ud = new UserDAO();

        if (ud.login(username, passoword) != null) {
            Cookie[] cookies = request.getCookies();

            User account = ud.login(username, passoword);

            // xu li lay ve tong user da dang nhap
            Cookie userActivity = null;
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equalsIgnoreCase("userActivity")) {
                        userActivity = c;
                        break;
                    }
                }
                if (userActivity != null) {
                    String[] userIdActivity = userActivity.getValue().split("&");
                    String temp = "";
                    for (int i = 0; i < userIdActivity.length; i++) {
                        if (i != userIdActivity.length - 1) {
                            temp += userIdActivity[i] + "&";
                        } else {
                            temp += userIdActivity[i];
                        }
                    }
                    boolean danhDauXemUserDaCoTrongCookie = false;

                    for (String x : userIdActivity) {
                        if (x.equalsIgnoreCase("" + account.getUserId())) {
                            danhDauXemUserDaCoTrongCookie = true;
                            break;
                        }
                    }
                    if (danhDauXemUserDaCoTrongCookie == false && account.getRole().getName().equalsIgnoreCase("user")) {
                        temp += "&" + account.getUserId();
                    }
                    temp = temp.trim();
                    System.out.println(temp);
                    userActivity.setValue(temp);
                } else {
                    if (account.getRole().getName().equalsIgnoreCase("user")) {
                        userActivity = new Cookie("userActivity", "" + account.getUserId());
                    }
                }

            } else {
                if (account.getRole().getName().equalsIgnoreCase("user")) {
                    userActivity = new Cookie("userActivity", "" + account.getUserId());
                }
            }
            if (userActivity != null) {
                userActivity.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(userActivity);
            }
            
            

            // xu li remember me account
            if (rememberMe != null) {
                Cookie rememberAcount = new Cookie("rememberMe", account.getUserId() + "");
                rememberAcount.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(rememberAcount);
            } else {
                if (cookies != null) {
                    Cookie removeRememberMe = null;
                    for (Cookie c : cookies) {
                        if (c.getName().equalsIgnoreCase("rememberMe")) {
                            removeRememberMe = c;
                            break;
                        }
                    }
                    if (removeRememberMe != null) {
                        removeRememberMe.setMaxAge(0);
                        response.addCookie(removeRememberMe);
                    }
                }
            }

            session.setAttribute("account", account);
            response.sendRedirect("home");
        } else {
            request.setAttribute("errorLogin", "Username or password information is incorrect, please re-enter");
            request.getRequestDispatcher("views/common/user/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
