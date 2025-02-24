/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.UserDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String passoword = request.getParameter("password");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phone");
        String name = request.getParameter("name");
        
        UserDAO ud = new UserDAO();
        WalletDAO wd = new WalletDAO();
        boolean checkRegister = ud.registerUser(username, passoword, "user",email,phoneNum,name);
        if (checkRegister) {
            int userId = ud.getUserIdByUserName(username);
            wd.insertWallet(userId);
            response.sendRedirect("home");
        } else {
            request.setAttribute("errorRegister", "username already exists, please enter another username!!!");
            request.getRequestDispatcher("views/common/user/register.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    
}
