<%-- 
    Document   : shoppingcart
    Created on : Mar 5, 2024, 12:48:11 AM
    Author     : PC
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.ProductDAO"%>
<%@page import="model.Size"%>
<%@page import="model.Color"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="zxx">

    <!-- Mirrored from ethemestudio.com/demo/evani/shopping-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:01:57 GMT -->
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/awesome.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/unpkg.swiper.css">

        <link rel="stylesheet" type="${pageContext.request.contextPath}/text/css" href="css/leaflet.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webfonts/all.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webfonts/fontawesome.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

        <title>Shopping Cart</title>

        <link rel="icon" href="${pageContext.request.contextPath}/images/head/logo/shape-1.png">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css" />

    </head>
    <body>

        <!-- HEADER-SECTION START  -->

        <jsp:include page="../../common/user/header.jsp"></jsp:include>

            <!-- HEADER-SECTION END  -->

            <!-- BANNER-SECTION START  -->

            <section class="hero-section ev-common-hero" style="background-image: url(images/common-banner/shape-1.png);"> 
                <div class="container-fluid">
                    <div class="ev-hero-content">
                        <h2>Shopping Cart</h2>
                        <span><a href="${pageContext.request.contextPath}/home">Home ></a> <a href="${pageContext.request.contextPath}/filterproductservlet?category=0&minPrice=${sessionScope.minPrice}&maxPrice=${sessionScope.maxPrice}&orderBy=0">Shop</a> > Cart</span>
                </div>
            </div>
        </section>

        <!-- BANNER-SECTION END  -->


        <!-- `SHOPPING-CART-SECTION START  -->

        <%
            Cart cart = (Cart) session.getAttribute("cart");
            List<Product> listProduct = new ArrayList<>();
            List<Size> listSize = new ArrayList<>();
            List<Color> listColor = new ArrayList<>();
            List<Integer> listQuantity = new ArrayList<>();
            if (cart != null) {
                for (int i = cart.getProduct().size() - 1; i >= 0; i--) {
                    listProduct.add(cart.getProduct().get(i));
                    listSize.add(cart.getSize().get(i));
                    listColor.add(cart.getColor().get(i));
                    listQuantity.add(cart.getSoLuong().get(i));
                }
            }

            Collections.reverse(listProduct);
            Collections.reverse(listSize);
            Collections.reverse(listColor);
            Collections.reverse(listQuantity);

            ProductDAO pd = new ProductDAO();
        %>


        <section class="wishlist-section shopping-section">
            <div class="container">
                <div class="wishlist-item">
                    <h5>Your Cart Items</h5>
                    <div class="wishlist-table">





                        <table class="table-wrapper">
                            <thead class="t-head">
                                <tr>
                                    <th><span>Item Name</span></th>
                                    <th><span>Size</span></th>
                                    <th><span>Color</span></th>
                                    <th><span>Price</span></th>
                                    <th><span>Quantity</span></th>
                                    <th><span>Total</span></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody class="t-body">
                                <%
                                    if (listProduct.size() != 0) {
                                        for (int i = listProduct.size() - 1; i >= 0; i--) {
                                            int quantityStock = pd.getQuantityStockProductByColorAndSize(listColor.get(i).getColorId(), listSize.get(i).getSizeId(), listProduct.get(i).getProductId());
                                %>
                                <tr class="wishlist-tr">
                                    <td class="d-lg-flex d-lg-block align-items-center">
                                        <a href="<%= request.getContextPath() %>/productdetail?pid=<%= listProduct.get(i).getProductId() %>">
                                            <img style="border-radius: 5%" width="84px" height="96px" src="${pageContext.request.contextPath}/<%= listProduct.get(i).getThumbnails().get(0)%>" alt="shopping">
                                        </a>
                                        <h2>
                                            <a href="<%= request.getContextPath() %>/productdetail?pid=<%= listProduct.get(i).getProductId() %>"><%= listProduct.get(i).getProductName()%></a>


                                        </h2>

                                    </td>
                                    <td style="color: black"><span><%= listSize.get(i).getSizeOption()%></span></td>
                                    <td style="color: black"><span><%= listColor.get(i).getColor()%></span></td>
                                    <td style="color: black"><span><%= listProduct.get(i).getPrice()%></span></td>
                                    <td>
                                        <form id="f" action="${pageContext.request.contextPath}/updateshoppingcart" method="get">
                                            <input type="hidden" name="pid" value="<%= listProduct.get(i).getProductId()%>"/>
                                            <input type="hidden" name="sid" value="<%= listSize.get(i).getSizeId()%>"/>
                                            <input type="hidden" name="cid" value="<%= listColor.get(i).getColorId()%>"/>
                                            <input type="hidden" name="record" value="<%= i%>"/>
                                            <div class="pro-counter d-flex align-items-center justify-content-between">
                                                <button type="submit" name="action" value="giam">-</button>
                                                <input type="number" name="quantity" value="<%= listQuantity.get(i)%>" min="0" readonly>
                                                <button type="submit" name="action" value="tang">+</button>
                                            </div>
                                            <%
                                                if (((String) request.getAttribute("errorUpdateCart") != null && (int) request.getAttribute("record") == i) || (listQuantity.get(i) > quantityStock)) {
                                            %>
                                            <span style="color: red"><%= (String) request.getAttribute("errorUpdateCart") != null ? (String) request.getAttribute("errorUpdateCart") : "Không đủ sản phẩm có sẵn(Stock: " + quantityStock + ")"%></span>
                                            <%
                                                }
                                            %>
                                            <td><span class="cart-total"><%= listProduct.get(i).getPrice() * listQuantity.get(i)%>&nbsp;VNĐ</span></td>
                                            <td>
                                                <a onclick="deleteProduct()" href="javascript:void(0)" class="cart-btn"><i class="fa-solid fa-xmark"></i></a>
                                            </td>
                                        </form>
                                    </td>

                                </tr>

                                <%
                                        }
                                    }
                                %>

                            </tbody>
                        </table>
                    </div>
                    <div class="shoping-cart-btn d-md-flex d-md-block align-items-center justify-content-md-between justify-content-md-start">
                        <div class="shoping-cart-btn-left">
                            <div class="checkout-text">
                                <div class="btn_box shoping-btn">
                                    <a href="${pageContext.request.contextPath}/home">Continue Shopping</a>
                                </div>
                            </div>    
                        </div>
                                <form id="fclear" action="${pageContext.request.contextPath}/updateshoppingcart" method="post">
                            <div class="shoping-cart-btn-right d-flex align-items-center">
                                <a onclick="clearAll()" href="javascript:void(0)" class="view-all-two shoping-btn-2">Clear All</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <!-- `SHOPPING-CART-SECTION END  -->


        <section class="calculate-shipping">
            <div class="container">
                <div class="row">
                    <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                    </div>
                    <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                        <div class="calculate-item coupon-code-items">
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                        <div class="calculate-item">
                            <div class="select-item">
                                <div class="chectout-cart">
                                    <ul class="sub-total">
                                        <li class="d-flex align-items-center justify-content-between"><h6>Sub Total</h6> <span>${sessionScope.cart.totalPriceBeforeDiscount}&nbsp;VNĐ</span></li>
                                        <li class="d-flex align-items-center justify-content-between"><h6>Discount </h6> <span>${sessionScope.cart.totalPriceBeforeDiscount - sessionScope.cart.totalPriceAfterDiscount}&nbsp;VNĐ</span></li>
                                    </ul>
                                    <ul class="grand-total">
                                        <li class="d-flex align-items-center justify-content-between"><h6>Grand Total</h6><span>${sessionScope.cart.totalPriceAfterDiscount}&nbsp;VNĐ</span></li>
                                    </ul>
                                    <div class="checkout-text">
                                        <div class="btn_box checkout-btn">
                                            <a href="${pageContext.request.contextPath}/views/user/item-page/checkout.jsp">Proceed To Checkout</a>
                                        </div>
                                        <span >Checkout with multiple address</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- PRODUCT-SECTION END  -->

        <!--    FOOTER-SECTION START -->

        <jsp:include page="../../common/user/footer.jsp"></jsp:include>

            <!--    FOOTER-SECTION END  -->

            <!-- FOOTER-ICONTOP START  -->

            <div class="footer_iconTop">
                <a href="#" id="button"><i class="fa-solid fa-arrow-up"></i></a>
            </div>

            <!-- FOOTER-ICONTOP END  -->


            <!-- JS-SCRIPT START  -->


            <script src="${pageContext.request.contextPath}/js/jquery-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/js/popper.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrop-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/swiper.js"></script>
        <script src="${pageContext.request.contextPath}/js/mmenu.js"></script>
        <script src="${pageContext.request.contextPath}/js/leaflet.js"></script>
        <script src="${pageContext.request.contextPath}/js/script.js"></script>
        <script src="${pageContext.request.contextPath}/js/profile.js"></script>
        <script src="${pageContext.request.contextPath}/js/shoppingcart.js"></script>

        <!-- JS-SCRIPT END  -->


    </body>


    <!-- Mirrored from ethemestudio.com/demo/evani/shopping-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:01:58 GMT -->
</html>
