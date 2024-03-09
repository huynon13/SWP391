/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Wallet;

/**
 *
 * @author PC
 */
@WebServlet(name = "AddWalletServlet", urlPatterns = {"/addwallet"})
public class AddWalletServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WalletDAO wd = new WalletDAO();

        String walletId_raw = request.getParameter("walletId");
        String balance_raw = request.getParameter("balance");

        try {
            int walletId = Integer.parseInt(walletId_raw);
            float balance = Float.parseFloat(balance_raw);

            wd.updateWallet(walletId, balance);
            
            HttpSession session = request.getSession();
            List<Wallet> getWalletAll = wd.getWalletAll();
            session.setAttribute("walletAll", getWalletAll);
            
            response.sendRedirect("views/admin/item-page/wallets.jsp");
        } catch (NumberFormatException e) {
        }
    }

}
