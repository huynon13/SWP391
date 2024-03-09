/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.ColorDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import model.Cart;
import model.Color;
import model.Product;
import model.Size;
import model.User;

/**
 *
 * @author PC
 */
@WebServlet(name = "UpdateShoppingCartServlet", urlPatterns = {"/updateshoppingcart"})
public class UpdateShoppingCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clearAll(request, response);
        response.sendRedirect("views/user/item-page/shoppingcart.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");

        ProductDAO pd = new ProductDAO();
        SizeDAO sd = new SizeDAO();
        ColorDAO cd = new ColorDAO();

        String productId_raw = request.getParameter("pid");
        String colorId_raw = request.getParameter("cid");
        String sizeId_raw = request.getParameter("sid");
        String quantity_raw = request.getParameter("quantity");
        String action = request.getParameter("action");
        String record = request.getParameter("record");

        try {
            int productId = Integer.parseInt(productId_raw);
            int colorId = Integer.parseInt(colorId_raw);
            int sizeId = Integer.parseInt(sizeId_raw);
            int quantity = Integer.parseInt(quantity_raw);

            int quantityStock = pd.getQuantityStockProductByColorAndSize(colorId, sizeId, productId);

            if (action != null) {
                if (action.equalsIgnoreCase("tang")) {
                    if (quantity + 1 > quantityStock) {
                        request.setAttribute("errorUpdateCart", "Không đủ sản phẩm có sẵn(Stock: " + quantityStock + ")");
                    } else {
                        quantity += 1;
                        updateProductInCart(productId, sizeId, colorId, quantity, "tang", request, response);
                    }
                } else {
                    quantity -= 1;
                    if (quantity == 0) {
                        updateProductInCart(productId, sizeId, colorId, quantity, "delete", request, response);
                    } else {
                        updateProductInCart(productId, sizeId, colorId, quantity, "giam", request, response);
                    }
                }
            } else {
                updateProductInCart(productId, sizeId, colorId, quantity, "delete", request, response);
            }
            request.setAttribute("record", Integer.parseInt(record));
            request.getRequestDispatcher("views/user/item-page/shoppingcart.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            System.out.println("loi chuyen doi so trong class update shopping cart");
        }

    }

    private void updateProductInCart(int pid, int sid, int cid, int quantity, String action, HttpServletRequest request, HttpServletResponse response) {
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

        if (cartId != null) {
            if (listProduct.size() != 0) {
                boolean checkDelete = false;
                int index = -1;
                for (int i = 0; i < listProduct.size(); i++) {
                    int productId = listProduct.get(i).getProductId();
                    int sizeId = listSize.get(i).getSizeId();
                    int colorId = listColor.get(i).getColorId();
                    int quantityCurrent = listQuantity.get(i);
                    if (productId == pid && sizeId == sid && colorId == cid) {
                        if (action.equalsIgnoreCase("tang")) {
                            quantityCurrent += 1;
                            listQuantity.set(i, quantityCurrent);
                        } else if (action.equalsIgnoreCase("giam")) {
                            quantityCurrent -= 1;
                            listQuantity.set(i, quantityCurrent);
                        } else if (action.equalsIgnoreCase("delete")) {
                            checkDelete = true;
                            index = i;
                        }
                        break;
                    }
                }
                if (checkDelete == true && index != -1) {
                    listProduct.remove(index);
                    listColor.remove(index);
                    listSize.remove(index);
                    listQuantity.remove(index);
                }
            }

            //update cart trong cookie
            String cartValue = "";
            for (int i = 0; i < listProduct.size(); i++) {
                String temp = "";
                int pid2 = listProduct.get(i).getProductId();
                int sid2 = listSize.get(i).getSizeId();
                int cid2 = listColor.get(i).getColorId();
                int sl = listQuantity.get(i);
                temp = pid2 + "-" + sid2 + "-" + cid2 + "-" + sl;
                if (i != listProduct.size() - 1) {
                    cartValue += temp + "&";
                } else {
                    cartValue += temp;
                }
            }
            cartId.setValue(cartValue);
            cartId.setMaxAge(60 * 60 * 24 * 60);
            response.addCookie(cartId);

            cart.setTotalPriceBeforeDiscount();
            cart.setTotalPriceAfterDiscount();
            System.out.println("truoc");
            System.out.println(cart.getTotalPriceBeforeDiscount());

            System.out.println("sau");
            System.out.println(cart.getTotalPriceAfterDiscount());

            // cap nhat lai cart trong session
            session.setAttribute("cart", cart);

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
