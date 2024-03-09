/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.OrderDAO;
import dal.OrderDetailDAO;
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
import java.util.List;
import java.util.Map;
import model.Cart;
import model.Color;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.Size;
import model.User;
import model.Wallet;

/**
 *
 * @author PC
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        OrderDAO od = new OrderDAO();
        WalletDAO wd = new WalletDAO();
        OrderDetailDAO odd = new OrderDetailDAO();

        User account = (User) session.getAttribute("account");
        Wallet wallet = wd.getWalletByUserId(account.getUserId());

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        String thanhToan_raw = request.getParameter("thanhtoan");

        Cart cart = (Cart) session.getAttribute("cart");
        List<Product> listProduct = cart.getProduct();
        List<Size> listSize = cart.getSize();
        List<Color> listColor = cart.getColor();
        List<Integer> listQuantity = cart.getSoLuong();

        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println(listProduct.get(i).getProductName() + "-" + listColor.get(i).getColor() + "-" + listSize.get(i).getSizeOption() + "-" + listQuantity.get(i));
        }

        // kiem tra xem neu phuong thuc thanh toan la 1 thi co du so du trong tai khoan hay khong, neu kh du bat nguoi dung chon phuong thuc thanh toan khac
        try {
            int thanhToan = Integer.parseInt(thanhToan_raw);
            if (thanhToan == 1) {
                if (wallet.getBalance() >= cart.getTotalPriceAfterDiscount()) {
                    od.insertOrder(account.getUserId(), name, phone, email, address, thanhToan, note, 1);
                    int orderId = od.getOrderIdLastInsert();

                    // cap nhat lai wallet cua user
                    wd.updateWallet(wallet.getWalletId(), (float) wallet.getBalance() - (float) cart.getTotalPriceAfterDiscount());

                    odd.insertOrderDetailByOrderId(orderId, listProduct, listColor, listSize, listQuantity);
                    clearAll(request, response);

                    Map<Order, List<OrderDetail>> ListAllOrderAndOrderDetail = odd.getAllOrderAndOrderDetail();
                    session.setAttribute("ListAllOrderAndOrderDetail", ListAllOrderAndOrderDetail);

                    response.sendRedirect("views/user/item-page/ordersuccess.jsp");
                } else {
                    request.setAttribute("errorPayment", "Số dư tài khoản không đủ, vui lòng chọn phương thức thanh toán khác!");
                    request.getRequestDispatcher("views/user/item-page/checkout.jsp").forward(request, response);
                }
            } else if (thanhToan == 2) {
                od.insertOrder(account.getUserId(), name, phone, email, address, thanhToan, note, 0);
                int orderId = od.getOrderIdLastInsert();
                odd.insertOrderDetailByOrderId(orderId, listProduct, listColor, listSize, listQuantity);
                clearAll(request, response);

                Map<Order, List<OrderDetail>> ListAllOrderAndOrderDetail = odd.getAllOrderAndOrderDetail();
                session.setAttribute("ListAllOrderAndOrderDetail", ListAllOrderAndOrderDetail);

                response.sendRedirect("views/user/item-page/ordersuccess.jsp");
            }

        } catch (ServletException | IOException | NumberFormatException e) {
            System.out.println("loi chuyen doi so: " + e);
        }

    }

    private void clearAll(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        User account = (User) session.getAttribute("account");

        Cookie cartId = null;

        for (Cookie c : cookies) {
            if (c.getName().equalsIgnoreCase("cart" + account.getUserId())) {
                cartId = c;
                break;
            }
        }
        Cart cart = (Cart) session.getAttribute("cart");
        // lay ve cac tuy chon cua san pham
        List<Product> listProduct = cart.getProduct();
        List<Size> listSize = cart.getSize();
        List<Color> listColor = cart.getColor();
        List<Integer> listQuantity = cart.getSoLuong();

        listProduct.clear();
        listSize.clear();
        listColor.clear();
        listQuantity.clear();

        //update cart trong cookie
        String cartValue = "";

        cartId.setValue(cartValue);
        cartId.setMaxAge(60 * 60 * 24 * 60);
        response.addCookie(cartId);

        cart.setTotalPriceBeforeDiscount();
        cart.setTotalPriceAfterDiscount();

        // cap nhat lai cart trong session
        session.setAttribute("cart", cart);

    }
}
