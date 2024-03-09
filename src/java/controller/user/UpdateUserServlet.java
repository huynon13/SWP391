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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/updateuser"})
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        UserDAO ud = new UserDAO();

        String image = request.getParameter("image");

        String fullName = request.getParameter("fullName");

        String oldPasswordByForm = request.getParameter("oldPassword");

        String newPassword = request.getParameter("newPassword");

        String confirmPassword = request.getParameter("confirmPassword");

        String email = request.getParameter("email");

        String birthDay_raw = request.getParameter("birthDay");

        String address = request.getParameter("address");

        String phoneNumber = request.getParameter("phoneNumber");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String oldPassByUser = user.getPassWord();

        if (oldPasswordByForm.equals("") && newPassword.equals("") && confirmPassword.equals("")) {
            if (image.equals("")) {
                image = user.getImage();
            } else {
                image = "images/users/" + image;
            }

        } else {
            if (oldPasswordByForm.equals(oldPassByUser)) {
                if (newPassword.equals(confirmPassword)) {
                    if (image.equals("")) {
                        image = user.getImage();
                    } else {
                        image = "images/users/" + image;
                    }
                } else {
                    request.setAttribute("errorNewPass", "New Password different Confirm Password");
                    request.getRequestDispatcher("views/user/item-page/userprofile.jsp").forward(request, response);
                    return;
                }
            } else {
                request.setAttribute("errorOldPass", "Old password is incorrect");
                request.getRequestDispatcher("views/user/item-page/userprofile.jsp").forward(request, response);
                return;
            }
        }

        System.out.println("image: " + image);
        System.out.println("fullname: " + fullName);
        System.out.println("oldpass: " + oldPasswordByForm);
        System.out.println("newpass: " + newPassword);
        System.out.println("confirm: " + confirmPassword);
        System.out.println("email: " + email);
        System.out.println("birthDay: " + birthDay_raw);
        System.out.println("address: " + address);
        System.out.println("phone: " + phoneNumber);

        if (newPassword.equals("")) {
            newPassword = user.getPassWord();
        }

        ud.updateUser(newPassword, fullName, birthDay_raw, image, phoneNumber, address, email, user.getUserId());
        user = ud.getUserById(user.getUserId());
        session.setAttribute("account", user);
        request.setAttribute("updateSucc", "Updated profile successfully");
        request.getRequestDispatcher("views/user/item-page/userprofile.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
