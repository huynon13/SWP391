/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

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
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("account");

        // xu li xoa remember me
        // xu li remember me
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie rememberMe = null;
            for (Cookie c : cookies) {
                if (c.getName().equalsIgnoreCase("rememberMe")) {
                    rememberMe = c;
                    break;
                }
            }
            if (rememberMe != null) {
                rememberMe.setMaxAge(0);
                response.addCookie(rememberMe);
            }
        }
        response.sendRedirect("home");
    }
    
}
