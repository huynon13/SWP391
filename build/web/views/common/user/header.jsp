<%-- 
    Document   : header
    Created on : Feb 26, 2024, 6:20:14 PM
    Author     : PC
--%>

<%@page import="model.Cart"%>
<%@page import="model.Product"%>
<%@page import="model.Color"%>
<%@page import="model.Size"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header-section">
    <div class="top-bar">
        <div class="container d-flex align-items-center justify-content-between">
            <div class="top-bar-contact d-flex align-items-center">
                <ul class="d-flex align-items-center">
                    <li><a href="#"><i class="fa-solid fa-phone"></i>+84 3377 83926</a></li>
                    <li><a href="#"><i class="fa-regular fa-envelope"></i>nghiemxuanloc02@gmail.com</a></li>
                    <li><a href="#"><i class="fa-sharp fa-solid fa-location-dot"></i>Locate Our Shop</a></li>
                </ul>
            </div>
            <div class="top-bar-social d-flex align-items-center">
                <ul class="view-switcher d-flex align-items-center">
                    <li>
                        <span>VND<i class="fa-solid"></i></span>
                    </li>
                    <li>
                        <span>en<i class="fa-solid"></i></span>
                        <ul class="evani-curency">
                            <li><a href="#">english</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="social-icon d-flex align-items-center">
                    <li><a href="https://www.facebook.com/"><i class="fa-brands fa-facebook-f"></i></a></li>
                    <li><a href="https://www.youtube.com/"><i class="fa-brands fa-youtube"></i></a></li>
                </ul>
            </div>
        </div>
    </div>


    <div class="header-wrapper">

        <div class="header-middle">

            <div class="container d-flex align-items-center justify-content-between">
                <div class="evani-brand">
                    <a href="${pageContext.request.contextPath}/home">
                        <img src="${pageContext.request.contextPath}/images/header/logo/logo.png" alt="header">
                    </a>
                </div>
                <div class="evani-search-form">
                    <form class="search-product d-flex align-items-center justify-content-between" id="search-product" action="${pageContext.request.contextPath}/search" method="GET">
                        <input id="query" type="text" name="query" placeholder="Type to search i.e “ao”..." value="${requestScope.query}">
                        <button type="submit">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>
                </div>

                <div class="inner-wrapper">

                    <ul class="d-flex align-items-center">

                        <li class="search-popup">
                            <a class="header-popup d-flex align-items-center" id="header-popup" href="#"><span class="log-in-text"><i class="fa-solid fa-magnifying-glass"></i></span></a>
                            <div class="popup-wraper">
                                <div class="view-popup">
                                    <label class="close-btn fas fa-times popup-label"></label>
                                    <label class="la-search-pr">Search Product</label>
                                    <form class="search-product d-flex align-items-center justify-content-between" action="https://ethemestudio.com/search" method="GET">
                                        <input type="text" name="query" placeholder="Type to search i.e “áo”...">
                                        <button type="submit">
                                            <i class="fa-solid fa-magnifying-glass"></i>
                                        </button>
                                    </form>    
                                </div>
                            </div>
                        </li>

                        <c:if test="${sessionScope.account == null}">
                            <li>
                                <a class="log-in header-popup log-in-btn d-flex align-items-center" id="header-popup1" href="${pageContext.request.contextPath}/views/common/user/login.jsp"><span class="log-in-text">log in</span><i class="fa-solid fa-user"></i></a>
                            </li>


                            <li>
                                <a class="sign-up header-popup d-flex align-items-center" id="header-popup2" href="${pageContext.request.contextPath}/views/common/user/register.jsp"><span class="log-in-text">sign up</span></a>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.account != null}">

                            <div class="profile-dropdown">
                                <div onclick="toggle()" class="profile-dropdown-btn">
                                    <div class="profile-img" style="    position: relative;
                                         width: 3rem;
                                         height: 3rem;
                                         border-radius: 50%;
                                         background: url(${pageContext.request.contextPath}/${sessionScope.account.image});
                                         background-size: cover;">
                                        <i class="fa-solid fa-circle"></i>
                                    </div>
                                    <span style="font-size: 13px;">${account.userName}</span>
                                </div>

                                <ul class="profile-dropdown-list">
                                    <li class="profile-dropdown-list-item">
                                        <a href="${pageContext.request.contextPath}/views/user/item-page/userprofile.jsp">
                                            <i class="fa-regular fa-user"></i>
                                            Profile
                                        </a>
                                    </li>

                                    <c:if test="${sessionScope.account.role.name == 'Admin'}">
                                        <li class="profile-dropdown-list-item" style="margin-left: 20px;">
                                            <a href="${pageContext.request.contextPath}/dashboard" >
                                                <i class="fa-solid fa-chart-line"></i>
                                                Dashboard
                                            </a>
                                        </li>
                                    </c:if>

                                    <hr />

                                    <li class="profile-dropdown-list-item">
                                        <a href="${pageContext.request.contextPath}/logout">
                                            <i class="fa-solid fa-arrow-right-from-bracket"></i>
                                            Log out
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </c:if>

                        <li><a href="${pageContext.request.contextPath}/views/user/item-page/wishlist.jsp"><i class="fa-solid fa-heart"></i></a></li>
                        
                        <li class="product-cart">

                            <a href="${pageContext.request.contextPath}/views/user/item-page/shoppingcart.jsp" class="cart-icon" id="toggleButton"><i class="fa-solid fa-cart-shopping"></i><span class="cart-number">${sessionScope.cart.product.size()}</span></a>

                            <div class="view-cart content" id="content">

                                <div class="cart-title d-flex align-items-center justify-content-between">
                                    <span class="product-item">${sessionScope.cart.product.size()} ITEM</span>
                                    <a href="${pageContext.request.contextPath}/views/user/item-page/shoppingcart.jsp">View cart</a>
                                </div>

                                <!--hien thi san pham--> 
                                <!--top 3 san pham duoc them vao sau cung-->


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
                                    int cnt = 0;
                                    if (listProduct.size() != 0) {
                                        for (int i = 0; i < listProduct.size() && i < 3; i++) {
                                %>
                                <div class="product-item d-flex justify-content-between">
                                    <div class="product-inner">
                                        <a href="#" class="d-block"><%= listProduct.get(i).getProductName() %></a>
                                        <span><%= listQuantity.get(i) %> * <%= listProduct.get(i).getPrice() %></span>
                                    </div>
                                    <div class="product-img">
                                        <img src="${pageContext.request.contextPath}/<%= listProduct.get(i).getThumbnails().get(0) %>" alt="header">
                                        <a href="#">
                                            <span><i class="fa-solid fa-x"></i></span>
                                        </a>
                                    </div>
                                </div>

                                <%
                                        }
                                    }
                                %>

                                <div class="sub-total d-flex align-items-center justify-content-between">
                                    <span>Subtotal:</span>
                                    <span>${sessionScope.cart.totalPriceAfterDiscount}&nbsp;VNĐ</span>
                                </div>

                                <div class="popup-btn">
                                    <a href="${pageContext.request.contextPath}/views/user/item-page/checkout.jsp" class="popup-link">Checkout</a>
                                </div>


                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="mega-menu-wrapper">
            <div class="container">
                <div class="wrapper-items d-flex align-items-center">
                    <!-- menu start here -->
                    <div class="header-item item-left">
                        <div class="menu-overlay">
                        </div>
                        <nav class="nav-menu">
                            <div class="mobile-menu-head">
                                <div class="go-back"><i class="fa fa-angle-left"></i></div>
                                <div class="current-menu-title"></div>
                                <div class="mobile-menu-close"><i class="fa-solid fa-x"></i></div>
                            </div>
                            <ul class="menu-items">
                                <li class="menu-item-has-children">
                                    <a href="${pageContext.request.contextPath}/home" class="nav-link">Home<i class="fa"></i></a>
                                </li>

                                <li class="menu-item-has-children">
                                    <a href="#" class="nav-link">Shop <i class="fa fa-angle-down"></i></a>
                                    <div class="sub-menu mega-menu mega-menu-column-4">
                                        <c:forEach items="${sessionScope.top5ProductByCategory}" var="category">
                                            <div class="list-item">
                                                <h4 class="title">${category.key.categoryName}</h4>
                                                <c:forEach items="${category.value}" var="product">
                                                    <ul>
                                                        <li><a href="${pageContext.request.contextPath}/productdetail?pid=${product.productId}"">${product.productName}</a></li>
                                                    </ul>
                                                </c:forEach>
                                                <ul>
                                                    <li><a href="${pageContext.request.contextPath}/filterproductservlet?category=${category.key.categoryId}&minPrice=${sessionScope.minPrice}&maxPrice=${sessionScope.maxPrice}&orderBy=0">More...</a></li>
                                                </ul>
                                            </div>
                                        </c:forEach>

                                    </div>
                                </li>
                                <li class="menu-item-has-children">
                                    <a href="#" class="nav-link">Collections <i class="fa fa-angle-down"></i></a>
                                    <div class="sub-menu mega-menu mega-menu-column-4">
                                        <div class="list-item text-center">
                                            <a href="collections.html">
                                                <img src="${pageContext.request.contextPath}/images/header/collection/shape-1.png" alt="header">
                                                <h4 class="title">Men's T-Shirt</h4>
                                            </a>
                                        </div>
                                        <div class="list-item text-center">
                                            <a href="collections.html">
                                                <img src="${pageContext.request.contextPath}/images/header/collection/shape-2.png" alt="header">
                                                <h4 class="title">Women's Bag</h4>
                                            </a>
                                        </div>
                                        <div class="list-item text-center">
                                            <a href="collections.html">
                                                <img src="${pageContext.request.contextPath}/images/header/collection/shape-3.png" alt="header">
                                                <h4 class="title">Ball Gown</h4>
                                            </a>
                                        </div>
                                        <div class="list-item text-center">
                                            <a href="collections.html">
                                                <img src="${pageContext.request.contextPath}/images/header/collection/shape-4.png" alt="header">
                                                <h4 class="title">Night Gown</h4>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                <li class="menu-item-has-children">
                                    <a href="#" class="nav-link">News <i class="fas fa-angle-down"></i></a>
                                    <div class="sub-menu mega-menu mega-menu-column-4">
                                        <div class="list-item">
                                            <h4 class="title">Home Page</h4>
                                            <ul>
                                                <li><a href="index-2.html">Home One</a></li>
                                                <li><a href="index_2.html">Home Two</a></li>
                                                <li><a href="index_3.html">Home Three</a></li>
                                            </ul>
                                            <h4 class="title">Shop Page</h4>
                                            <ul>
                                                <li><a href="shop.html">Shop</a></li>
                                                <li><a href="shop-with-sidebar.html">Shop With Sidebar</a></li>
                                                <li><a href="shopping-cart.html">Shopping Cart</a></li>
                                            </ul>
                                        </div>
                                        <div class="list-item">
                                            <h4 class="title">Collection Page</h4>
                                            <ul>
                                                <li><a href="collections.html">Collections</a></li>
                                                <li><a href="all-collections.html">All Collections</a></li>
                                            </ul>
                                            <h4 class="title">Product Page</h4>
                                            <ul>
                                                <li><a href="single-product.html">Single Product</a></li>
                                                <li><a href="checkout.html">Checkout</a></li>
                                                <li><a href="wishlist.html">Wishlist</a></li>
                                            </ul>
                                        </div>
                                        <div class="list-item">
                                            <h4 class="title">Blog Page</h4>
                                            <ul>
                                                <li><a href="recent-blog.html">Recent Blog</a></li>
                                                <li><a href="recent-blog-two.html">Recent Blog Two</a></li>
                                                <li><a href="single-blog.html">Single Blog</a></li>
                                            </ul>
                                        </div>
                                        <div class="list-item">
                                            <img src="${pageContext.request.contextPath}/images/header/product/shape-1.png" alt="header">
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <a href="contact-us.html">Contact</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <!-- menu end here -->
                    <div class="header-item item-right">
                        <a href="#"><i class="fa-solid fa-headset"></i>Help & Support</a>
                        <div class="mobile-menu-trigger">
                            <span></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>