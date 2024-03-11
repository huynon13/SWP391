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
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/shoppingcart"})
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    // lua cart theo dinh dang 
    //    productId-sizeId-colorId-quantity&productId-sizeId-colorId-quantity
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

        if (colorId_raw.equals("") || sizeId_raw.equals("")) {
            request.setAttribute("errorAddToCart", "Bạn chưa chọn phân loại sản phẩm, xin vui lòng chọn lại");
            request.getRequestDispatcher("views/user/item-page/productdetail.jsp").forward(request, response);
        } else {
            try {
                int productId = Integer.parseInt(productId_raw);
                int colorId = Integer.parseInt(colorId_raw);
                int sizeId = Integer.parseInt(sizeId_raw);
                int quantity = Integer.parseInt(quantity_raw);
                int quantityStock = pd.getQuantityStockProductByColorAndSize(colorId, sizeId, productId);
                int quantitySoldByColorAndSize = pd.getQuantitySoldProductByColorAndSize(productId, colorId, sizeId);
                if (quantity > quantityStock) {
                    request.setAttribute("quantityStockByColorAndSize", quantityStock);
                    request.setAttribute("quantitySoldByColorAndSize", quantitySoldByColorAndSize);
                    request.setAttribute("errorAddToCart", "Số lượng sản phẩm có sẵn không đủ, vui lòng chọn lại");
                    request.getRequestDispatcher("views/user/item-page/productdetail.jsp").forward(request, response);
                } else if (quantity == 0) {
                    request.setAttribute("errorAddToCart", "Số lượng sản phẩm phải > 0, vui lòng chọn lại");
                    request.getRequestDispatcher("views/user/item-page/productdetail.jsp").forward(request, response);
                } else {
                    Cookie[] cookies = request.getCookies();
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

                    if (cartId == null) {
                        String option = productId + "-" + sizeId + "-" + colorId + "-" + quantity;

                        listProduct.add(pd.getProductById(productId));
                        listSize.add(sd.getSizeById(sizeId));
                        listColor.add(cd.getColorById(colorId));
                        listQuantity.add(quantity);

                        cartId = new Cookie("cart" + account.getUserId(), option);
                    } else {
                        // lay ve cart tren session

                        boolean danhDauXemOptionDoTonTaiChua = false;

                        // kiem tra xem option do da co trong cart chua, neu co trong cart r thi cong don so luong
                        for (int i = 0; i < listProduct.size(); i++) {
                            if (listProduct.get(i).getProductId() == productId && listSize.get(i).getSizeId() == sizeId && listColor.get(i).getColorId() == colorId) {
                                int soLuongCoSanTrongCart = listQuantity.get(i);
                                listQuantity.set(i, soLuongCoSanTrongCart + quantity);
                                danhDauXemOptionDoTonTaiChua = true;
                            }
                        }

                        // neu chua co trong cart thi add moi
                        if (danhDauXemOptionDoTonTaiChua == false) {
                            listProduct.add(pd.getProductById(productId));
                            listSize.add(sd.getSizeById(sizeId));
                            listColor.add(cd.getColorById(colorId));
                            listQuantity.add(quantity);
                        }
                    }
                    // chuyen cart thanh cookie
                    String cartValue = "";
                    for (int i = 0; i < listProduct.size(); i++) {
                        String temp = "";
                        int pid = listProduct.get(i).getProductId();
                        int sid = listSize.get(i).getSizeId();
                        int cid = listColor.get(i).getColorId();
                        int sl = listQuantity.get(i);
                        temp = pid + "-" + sid + "-" + cid + "-" + sl;
                        if (i != listProduct.size() - 1) {
                            cartValue += temp + "&";
                        } else {
                            cartValue += temp;
                        }
                    }
                    cartId.setValue(cartValue);
                    cartId.setMaxAge(60 * 60 * 24 * 60);
                    response.addCookie(cartId);

                    // cap nhat lai cart trong session
                    cart.setTotalPriceAfterDiscount();
                    cart.setTotalPriceBeforeDiscount();
                    session.setAttribute("cart", cart);
                    request.setAttribute("addCartSucc", "Bạn đã thêm sản phẩm vào giỏ hàng thành công, chúc bạn có 1 ngày mua sắm vui vẻ!");
                    request.getRequestDispatcher("views/user/item-page/productdetail.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                System.err.println("loi chuyen doi so trong class shopping cart");
            }
        }
    }

}
