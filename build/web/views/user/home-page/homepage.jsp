<%-- 
    Document   : homepage
    Created on : Feb 26, 2024, 5:14:58 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">

    <!-- Mirrored from ethemestudio.com/demo/evani/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:01:57 GMT -->
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

        <title> Home 360 Fashion men</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css" />

        <link rel="icon" href="${pageContext.request.contextPath}/images/head/logo/shape-1.png">
    </head>
    <body>

        <!-- HEADER-SECTION START  -->

        <jsp:include page="../../common/user/header.jsp"></jsp:include>

            <!-- HEADER-SECTION END  -->

            <!-- BANNER-SECTION START  -->

        <jsp:include page="../../common/user/banner.jsp"></jsp:include>

            <!-- BANNER-SECTION END  -->

            <!-- INTR0-SECTION START  -->

        <jsp:include page="../../common/user/section.jsp"></jsp:include>    

            <!-- INTR0-SECTION END  -->

            <!-- CATAGORIES-SECTION START  -->

        <jsp:include page="../../common/user/category.jsp"></jsp:include>  

            <!-- CATAGORIES-SECTION END  -->

            <!-- COLLECTION-SECTION START  -->

        <%--<jsp:include page="../../common/user/collections.jsp"></jsp:include>--%>  

            <!-- COLLECTION-SECTION END  -->

            <!-- `PRODUCT-SECTION START  -->

        <jsp:include page="../../common/user/top6newproducts.jsp"></jsp:include> 

            <!-- PRODUCT-SECTION END  -->

            <!--    FEATURED-PRODUCT-SECTION START  -->

            <section class="featured-product-section">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-6 col-lg-7 col-md-7 col-12 d-flex align-items-center">
                            <div class="pr-featured-left">
                                <h6>50% Discount Running</h6>
                                <h2>Double Protection Face Mask</h2>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                                    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit</p>
                                <ul class="d-flex align-items-center">
                                    <li><span>$5</span></li>
                                    <li><span>$10</span></li>
                                </ul>
                                <div class="btn_box">
                                    <a href="#">Buy Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-5 col-md-5 col-12 ">
                            <div class="pr-featured-right d-flex align-items-center justify-content-lg-end justify-content-center">
                                <div class="pr-featured-img featured-img1">
                                    <img src="${pageContext.request.contextPath}/images/index-1/featured/shape-1.png" alt="featured">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--    FEATURED-PRODUCT-SECTION END  -->

        <!--    FEATURED-COLLECTION-SECTION START  -->

        <section class="featured-collection-section">
            <div class="container-fluid">
                <div class="collection-grid">
                    <div class="featured-collection-left">
                        <a href="#" class="ev-overlay">
                            <div class="featured-collection-img">
                                <img src="${pageContext.request.contextPath}/images/index-1/featured-collection/shape-1.png" alt="featured">
                            </div>
                            <div class="summer-collection">
                                <span>30% Off</span>
                                <h2>Summer Collection 2021</h2>
                            </div>
                        </a>
                    </div>
                    <div class="featured-collection-right">
                        <a href="#" class="ev-overlay">
                            <div class="featured-collection-img">
                                <img src="${pageContext.request.contextPath}/images/index-1/featured-collection/shape-2.png" alt="featured">
                            </div>
                            <div class="featured-collection-text">
                                <span>Buy one get one free</span>
                                <h2>Men’s Casual Outfit 2021</h2>
                                <h5>Starts From $100</h5>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <!--    FEATURED-COLLECTION-SECTION END  -->

        <!--    POPULAR-PRODUCT-SECTION START  -->

        <jsp:include page="../../common/user/top10products.jsp"></jsp:include> 

            <!--    POPULAR-PRODUCT-SECTION END  -->

            <!--    BRAND-SECTION START  -->

        <jsp:include page="../../common/user/brand.jsp"></jsp:include> 

            <!--    BRAND-SECTION END  -->

            <!--    TESTIMONIAL-SECTION START  -->

        <jsp:include page="../../common/user/feedback.jsp"></jsp:include> 

            <!--    TESTIMONIAL-SECTION END  -->

            <!--    NEWS-SECTION START  -->

        <jsp:include page="../../common/user/news.jsp"></jsp:include> 

            <!--    NEWS-SECTION END  -->


            <!--    FOOTER-SECTION START -->

        <jsp:include page="../../common/user/footer.jsp"></jsp:include> 

            <!-- FOOTER-SECTION END  -->


            <!--    FOOTER-ICONTOP START  -->

            <div class="footer_iconTop">
                <a href="#" id="button"><i class="fa-solid fa-arrow-up"></i></a>
            </div>


            <!--    FOOTER-ICONTOP END  -->


            <script src="${pageContext.request.contextPath}/js/jquery-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/js/popper.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrop-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/swiper.js"></script>
        <script src="${pageContext.request.contextPath}/js/mmenu.js"></script>
        <script src="${pageContext.request.contextPath}/js/leaflet.js"></script>
        <script src="${pageContext.request.contextPath}/js/script.js"></script>
        <script src="${pageContext.request.contextPath}/js/profile.js"></script>
    </body>


    <!-- Mirrored from ethemestudio.com/demo/evani/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:01:57 GMT -->
</html>


