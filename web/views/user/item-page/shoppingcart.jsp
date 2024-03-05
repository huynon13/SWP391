<%-- 
    Document   : shoppingcart
    Created on : Mar 5, 2024, 12:48:11 AM
    Author     : PC
--%>

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

        <title> Evani E-commerce Template</title>

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
                        <span><a href="index-2.html">Home</a> <a href="shop.html">Shop</a> > Single</span>
                    </div>
                </div>
            </section>

            <!-- BANNER-SECTION END  -->


            <!-- `SHOPPING-CART-SECTION START  -->


            <section class="wishlist-section shopping-section">
                <div class="container">
                    <div class="wishlist-item">
                        <h5>Your Cart Items</h5>
                        <div class="wishlist-table">
                            <table class="table-wrapper">
                                <thead class="t-head">
                                    <tr>
                                        <th><span>Item Name</span></th>
                                        <th><span>Price</span></th>
                                        <th><span>Quantity</span></th>
                                        <th><span>Total</span></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody class="t-body">
                                    <tr class="wishlist-tr">
                                        <td class="d-lg-flex d-lg-block align-items-center">
                                            <a href="single-product.html">
                                                <img src="images/shopping-cart/shape-1.png" alt="shopping">
                                            </a>
                                            <h2><a href="single-product.html">Tritan steel water bottle</a></h2>
                                        </td>
                                        <td><span>$42.00</span></td>
                                        <td>
                                            <div class="pro-counter d-flex align-items-center justify-content-between">
                                                <button onclick="decrement('quantity1')" class="counter-button">-</button>
                                                <input type="number" class="counter-input" id="quantity1" value="0" min="0" readonly>
                                                <button onclick="increment('quantity1')" class="counter-button">+</button>
                                            </div>
                                        </td>
                                        <td><span class="cart-total">$42.00</span></td>
                                        <td>
                                            <a href="#" class="cart-btn"><i class="fa-solid fa-xmark"></i></a>
                                        </td>
                                    </tr>
                                    <tr class="wishlist-tr">
                                        <td class="d-lg-flex d-lg-block align-items-center">
                                            <a href="single-product.html">
                                                <img src="images/shopping-cart/shape-2.png" alt="shopping">
                                            </a>
                                            <h2><a href="single-product.html">Ray Ban fashion sunglass</a></h2>
                                        </td>
                                        <td><span>$93.00</span></td>
                                        <td>
                                            <div class="pro-counter d-flex align-items-center justify-content-between">
                                                <button onclick="decrement('quantity2')" class="counter-button">-</button>
                                                <input type="number" class="counter-input" id="quantity2" value="0" min="0" readonly>
                                                <button onclick="increment('quantity2')" class="counter-button">+</button>
                                            </div>
                                        </td>
                                        <td><span class="cart-total">$93.00</span></td>
                                        <td>
                                            <ul class="product-cart d-flex align-items-center justify-content-between">
                                                <li><a href="#" class="cart-btn"><i class="fa-solid fa-xmark"></i></a></li>
                                            </ul>
                                        </td>
                                    </tr>
                                    <tr class="wishlist-tr">
                                        <td class="d-lg-flex d-lg-block align-items-center">
                                            <a href="single-product.html">
                                                <img src="images/shopping-cart/shape-3.png" alt="shopping">
                                            </a>
                                            <h2><a href="single-product.html">Mens fashion running shoes</a></h2>
                                        </td>
                                        <td><span>$48.00</span></td>
                                        <td>
                                            <div class="pro-counter d-flex align-items-center justify-content-between">
                                                <button onclick="decrement('quantity3')" class="counter-button">-</button>
                                                <input type="number" class="counter-input" id="quantity3" value="0" min="0" readonly>
                                                <button onclick="increment('quantity3')" class="counter-button">+</button>
                                            </div>
                                        </td>
                                        <td><span class="cart-total">$48.00</span></td>
                                        <td>
                                            <a href="#" class="cart-btn"><i class="fa-solid fa-xmark"></i></a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="shoping-cart-btn d-md-flex d-md-block align-items-center justify-content-md-between justify-content-md-start">
                            <div class="shoping-cart-btn-left">
                                <div class="checkout-text">
                                    <div class="btn_box shoping-btn">
                                        <a href="#">Continue Shopping</a>
                                    </div>
                                </div>    
                            </div>
                            <div class="shoping-cart-btn-right d-flex align-items-center">
                                <a href="#" class="view-all-two shoping-btn-2">Update Cart</a>
                                <a href="#" class="view-all-two shoping-btn-2">Clear All</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- `SHOPPING-CART-SECTION END  -->


            <section class="calculate-shipping">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                            <div class="calculate-item">
                                <h5>Calculate Shipping</h5>
                                <div class="select-item d-flex align-items-center">
                                    <h6>Country:</h6>
                                    <div class="select-wrapper d-flex align-items-center justify-content-between">
                                        <select class="select-option">
                                            <option value="">Select your country </option>
                                            <option value="USA">United States</option>
                                            <option value="UK">United Kingdom</option>
                                            <option value="Canada">Canada</option>
                                            <option value="Australia">Australia</option>
                                        </select>
                                        <span><i class="fa-solid fa-angle-down"></i></span>
                                    </div>
                                </div>
                                <div class="select-item d-flex align-items-center">
                                    <h6>State:</h6>
                                    <div class="select-wrapper d-flex align-items-center justify-content-between">
                                        <select class="select-option">
                                            <option value="">Select your State</option>
                                            <option value="USA">United States</option>
                                            <option value="UK">United Kingdom</option>
                                            <option value="Canada">Canada</option>
                                            <option value="Australia">Australia</option>
                                        </select>
                                        <span><i class="fa-solid fa-angle-down"></i></span>
                                    </div>
                                </div>
                                <div class="select-item d-flex align-items-center">
                                    <h6>Zip Code:</h6>
                                    <div class="select-wrapper d-flex align-items-center justify-content-between">
                                        <select class="select-option">
                                            <option value="">Write your zip code</option>
                                            <option value="USA">United States</option>
                                            <option value="UK">United Kingdom</option>
                                            <option value="Canada">Canada</option>
                                            <option value="Australia">Australia</option>
                                        </select>
                                        <span><i class="fa-solid fa-angle-down"></i></span>
                                    </div>
                                </div>
                                <button class="view-all-two shoping-btn-2">Get A Quote</button>
                            </div>
                        </div>
                        <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                            <div class="calculate-item coupon-code-items">
                                <h5>Have A Coupon Code ?</h5>
                                <form>
                                    <input type="text" id="name" name="name" placeholder="Write your Coupon Code">
                                </form>
                                <button class="view-all-two shoping-btn-2">Apply Code</button>
                            </div>
                        </div>
                        <div class="col-xl-4 col-md-6 col-sm-12 col-12">
                            <div class="calculate-item">
                                <div class="select-item">
                                    <div class="chectout-cart">
                                        <ul class="sub-total">
                                            <li class="d-flex align-items-center justify-content-between"><h6>Sub Total</h6> <span>$183.00</span></li>
                                            <li class="d-flex align-items-center justify-content-between"><h6>Shipping </h6> <span>$10.00</span></li>
                                        </ul>
                                        <ul class="grand-total">
                                            <li class="d-flex align-items-center justify-content-between"><h6>Grand Total</h6><span>$193.00</span></li>
                                        </ul>
                                        <div class="checkout-text">
                                            <div class="btn_box checkout-btn">
                                                <a href="#">Proceed To Checkout</a>
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

            <footer class="footer-section common-footer-section">   
                <div class="container">
                    <div class="row">
                        <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex justify-content-between">
                            <div class="widgets-item">
                                <div class="footer-logo">
                                    <a href="index-2.html">
                                        <img src="images/footer/logo/shape-1.png" alt="logo">
                                    </a>
                                </div>
                                <div class="widgets-contacts">
                                    <ul>
                                        <li><a href="#" class="d-flex"><i class="fa-solid fa-location-dot"></i><span>22/1 Bardeshi, Amin Bazar Dhaka 1348</span></a></li>
                                        <li><a href="#" class="d-flex"><i class="fa-solid fa-envelope"></i> hello@preo.com</a></li>
                                        <li><a href="#" class="d-flex"><i class="fa-solid fa-phone"></i> +88 01234 567 890</a></li>
                                    </ul>
                                </div>
                                <div class="widgets-social">
                                    <ul class="d-flex align-items-center">
                                        <li><a href="https://www.facebook.com/"><i class="fa-brands fa-facebook-f"></i></a></li>
                                        <li><a href="https://twitter.com/"><i class="fa-brands fa-twitter"></i></a></li>
                                        <li><a href="https://www.linkedin.com/"><i class="fa-brands fa-linkedin-in"></i></a></li>
                                        <li><a href="https://www.youtube.com/"><i class="fa-brands fa-youtube"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex justify-content-between">
                            <div class="widgets-item widgets-p-top d-sm-flex d-block justify-content-around ">
                                <div class="widgets-link-items">
                                    <h6>Links</h6>
                                    <ul>
                                        <li><a href="#">Customer</a></li>
                                        <li><a href="#">Visitor</a></li>
                                        <li><a href="#">Webmaster</a></li>
                                        <li><a href="#">Service</a></li>
                                        <li><a href="#">Career</a></li>
                                    </ul>
                                </div>
                                <div class="widgets-link-items">
                                    <h6>Help</h6>
                                    <ul>
                                        <li><a href="#">Support</a></li>
                                        <li><a href="#">Doc File</a></li>
                                        <li><a href="#">Forum</a></li>
                                        <li><a href="#">FAQ</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex justify-content-between">
                            <div class="widgets-item widgets-p-top">
                                <h6>Recent Posts</h6>
                                <div class="recent-posts d-flex align-items-center">
                                    <div class="author-img">
                                        <a href="single-blog.html">
                                            <img src="images/footer/post/shape-1.png" alt="post">
                                        </a>
                                    </div>
                                    <div class="author-info">
                                        <span>April 15, 2021</span>
                                        <br>
                                        <a href="single-blog.html">Dalia enim ad minim veniam quis</a>
                                    </div>
                                </div>
                                <div class="recent-posts d-flex align-items-center">
                                    <div class="author-img">
                                        <a href="single-blog.html">
                                            <img src="images/footer/post/shape-2.png" alt="post">
                                        </a>
                                    </div>
                                    <div class="author-info">
                                        <span>April 15, 2021</span>
                                        <br>
                                        <a href="single-blog.html">Dalia enim ad minim veniam quis</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex">
                            <div class="widgets-item widgets-p-top">
                                <div class="news-letter">
                                    <h6>Newsletter</h6>
                                    <p>Ut enim ad minim veniam, quis nos trud exercitation ullamco laboris nisi ut aliquip modo</p>
                                    <form class="widgets-form d-flex align-items-center justify-content-between" action="https://ethemestudio.com/submit" method="POST">
                                        <input type="email" id="email" name="email" placeholder="Your email here" required>
                                        <button type="submit"><i class="fa-regular fa-envelope"></i></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="footer-bottom">
                        <div class="row">
                            <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12 d-flex align-items-center justify-content-lg-start justify-content-center pb-3">
                                <div class="footer-bottom-left">
                                    <span>Designed with love ©<a href="#">Juwel Khan</a></span>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12 d-flex align-items-center justify-content-lg-end justify-content-center">
                                <div class="footer-bottom-right">
                                    <ul class="d-flex">
                                        <li><a href="#">Terms & Condition</a></li>
                                        <li><a href="#">Privacy Policy</a></li>
                                        <li><a href="#">Legal</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>

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

        <!-- JS-SCRIPT END  -->


    </body>


    <!-- Mirrored from ethemestudio.com/demo/evani/shopping-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:01:58 GMT -->
</html>
