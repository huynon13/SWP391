<%-- 
    Document   : checkout
    Created on : Mar 6, 2024, 12:04:52 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">

    <!-- Mirrored from ethemestudio.com/demo/evani/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:03:05 GMT -->
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/awesome.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/unpkg.swiper.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/leaflet.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webfonts/all.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webfonts/fontawesome.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

        <title>Checkout</title>

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
                        <h2>Checkout</h2>
                        <span><a href="${pageContext.request.contextPath}/home">Home</a> ><a href="${pageContext.request.contextPath}/filterproductservlet?category=0&minPrice=${sessionScope.minPrice}&maxPrice=${sessionScope.maxPrice}&orderBy=0">Shop</a> > Checkout</span>
                    </div>
                </div>
            </section>

            <!-- BANNER-SECTION END  -->


            <!-- `CECKOUT-SECTION START  -->


            <!-- `CECKOUT-SECTION END  -->

            <section class="checkout-section">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-6 col-md-6 col-12">
                            <div class="checkout-left">
                                <ul class="checkout-top d-flex align-items-center">
                                    <li><span>Returning Customer ?</span></li>
                                    <li><a href="#">Click Here to Login </a></li>
                                </ul>
                                <div class="checkout-form">
                                    <h4>Your Billing Address</h4>
                                    <form>
                                        <div class="ev-form-grid">
                                            <input type="text" name="name" placeholder="First Name *" required>
                                            <input type="text" name="company" placeholder="Last Name *">
                                        </div>
                                        <input type="tel" name="phone" placeholder="Company Name">
                                        <div class="ev-form-grid">
                                            <input type="email" name="email" required placeholder="Email Address *">
                                            <input type="text" name="country" placeholder="Your country *">
                                        </div>
                                        <div class="select-wrapper d-flex align-items-center justify-content-between">
                                            <select class="select-option" id="country" name="country">
                                                <option value="">Select your State</option>
                                                <option value="USA">United States</option>
                                                <option value="UK">United Kingdom</option>
                                                <option value="Canada">Canada</option>
                                                <option value="Australia">Australia</option>
                                            </select>
                                            <span><i class="fa-solid fa-angle-down"></i></span>
                                        </div>
                                        <input type="text" name="state" placeholder="Address *">
                                        <input type="text" name="city" placeholder="City / Town *">
                                        <div class="ev-form-grid">
                                            <input type="text" name="zip" placeholder="State *">
                                            <input type="text" name="zip" placeholder="Zip Code *">
                                        </div>
                                    </form>
                                    <div class="checkbox-form">
                                        <div class="check-box d-flex align-content-center ">
                                            <input type="checkbox" id="myCheckbox1" name="myCheckbox" value="checkboxValue">
                                            <label for="myCheckbox1">Create Account ?</label>
                                        </div>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt 
                                            ut labore et dolore magna aliqua.</p>
                                        <input class="check-password" type="password" name="password" placeholder="Account Password *" required>
                                        <div class="check-box d-flex align-content-center ">
                                            <input type="checkbox" id="myCheckbox2" name="myCheckbox" value="checkboxValue">
                                            <label for="myCheckbox2">Ship to Different Address ?</label>
                                        </div>
                                        <textarea class="check-message" id="message" name="message" placeholder="Order Note" required></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-md-6 col-12">
                            <div class="order-review-wrapper">
                                <h4 class="coupon-title">Coupon Code</h4>
                                <div class="checkout-review-order">
                                    <form class="coupon-code d-flex align-items-center">
                                        <input type="text" id="coupon" name="coupon" placeholder="Enter coupon code">
                                        <div class="common-btn coupon-btn">
                                            <button type="submit" value="Submit Payment">Place Order</button>
                                        </div>
                                    </form>
                                    <div class="ev-order-review">
                                        <h4 class="order-title">Your Order</h4>
                                        <div class="ev-shop-table">
                                            <ul class="order-price d-flex align-items-center justify-content-between">
                                                <li><h6>Item</h6></li>
                                                <li><h6>Price</h6></li>
                                            </ul>
                                            <div class="cart-item">
                                                <ul class="product-name-price d-flex align-items-center justify-content-between">
                                                    <li><span>Tritan steel water bottle</span></li>
                                                    <li><span> $42.00</span></li>
                                                </ul>
                                                <ul class="product-name-price d-flex align-items-center justify-content-between">
                                                    <li><span>Ray Ban fashion sunglass</span></li>
                                                    <li><span> $93.00</span></li>
                                                </ul>
                                                <ul class="product-name-price d-flex align-items-center justify-content-between">
                                                    <li><span>Mens fashion running shoes </span></li>
                                                    <li><span>$48.00</span></li>
                                                </ul>
                                            </div>
                                            <div class="cart-item">
                                                <ul class="product-name-price product-subtotal d-flex align-items-center justify-content-between">
                                                    <li><span>Subtotal </span></li>
                                                    <li><span> $183.00</span></li>
                                                </ul>
                                                <ul class="product-name-price product-subtotal d-flex align-items-center justify-content-between">
                                                    <li><span>Shipping  ( Standard )</span></li>
                                                    <li><span> $20.00</span></li>
                                                </ul>
                                            </div>
                                            <ul class="product-total d-flex align-items-center justify-content-between">
                                                <li><span>Total </span></li>
                                                <li><span>  $203.00</span></li>
                                            </ul>
                                            <div class="checkout-payment">
                                                <form class="checkout-radio">
                                                    <ul class="radio-items">
                                                        <li class="radio-item">
                                                            <span>
                                                                <input type="radio" id="flexRadioDefault1" name="radio-group" checked>
                                                                <label for="flexRadioDefault1">Terms and Conditions:</label>
                                                            </span>
                                                            <div class="radio-text">
                                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incidid gna aliqua.</p>
                                                            </div>
                                                        </li>
                                                        <li class="radio-item">
                                                            <span>
                                                                <input type="radio" id="flexRadioDefault2" name="radio-group">
                                                                <label for="flexRadioDefault2">Payment by cheque</label>
                                                            </span>
                                                            <div class="radio-text">
                                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incidid gna aliqua.</p>
                                                            </div>
                                                        </li>
                                                        <li class="radio-item">
                                                            <span>
                                                                <input type="radio" id="flexRadioDefault3" name="radio-group">
                                                                <label for="flexRadioDefault3">Cash On Delivery</label>
                                                            </span>
                                                            <div class="radio-text">
                                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incidid gna aliqua.</p>
                                                            </div>
                                                        </li>
                                                        <li class="radio-item">
                                                            <span>
                                                                <input type="radio" id="flexRadioDefault4" name="radio-group">
                                                                <label for="flexRadioDefault4">Paypal</label>
                                                            </span>
                                                            <div class="radio-text">
                                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incidid gna aliqua.</p>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </form>
                                                <div class="common-btn">
                                                    <button type="submit" value="Submit Payment">Place Order</button>
                                                </div>
                                            </div>     
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css" />
        <!-- JS-SCRIPT END  -->


    </body>



    <!-- Mirrored from ethemestudio.com/demo/evani/checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:03:05 GMT -->
</html>
