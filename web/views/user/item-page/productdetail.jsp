<%-- 
    Document   : productdetail
    Created on : Feb 27, 2024, 4:21:12 PM
    Author     : PC
--%>

<%@page import="model.Comment"%>
<%@page import="dal.CommentDAO"%>
<%@page import="model.User"%>
<%@page import="dal.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

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

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css" />

        <title> Product Detail</title>

        <link rel="icon" href="${pageContext.request.contextPath}/images/head/logo/shape-1.png">


    </head>
    <body>

        <!-- HEADER-SECTION START  -->
        <jsp:include page="../../common/user/header.jsp"></jsp:include>


            <!-- HEADER-SECTION END  -->

            <!-- BANNER-SECTION START  -->

            <section class="hero-section ev-common-hero" style="background-image: url(${pageContext.request.contextPath}/images/common-banner/shape-1.png);"> 
            <div class="container-fluid">
                <div class="ev-hero-content">
                    <h2>Product Detail</h2>
                    <span><a href="${pageContext.request.contextPath}/home">Home</a> > <a href="${pageContext.request.contextPath}/views/user/item-page/shopdetail.jsp"> product ></a> Detail</span>
                </div>
            </div>
        </section>

        <!-- BANNER-SECTION END  -->


        <section class="single-product-section">
            <div class="container">
                <div class="row">
                    <div class="col-xl-6 col-lg-6 col-md-12 col-12">
                        <div class="product-img-glarry">
                            <div class="product-glarry-slider">
                                <div class="slider__flex">
                                    <div class="slider__col">
                                        <div class="slider__thumbs">
                                            <!--anh thu nho ben canh-->
                                            <div class="swiper-container"> 
                                                <div class="swiper-wrapper">
                                                    <c:forEach items="${sessionScope.product.thumbnails}" var="i">
                                                        <div class="swiper-slide">
                                                            <div class="slider__image"><img src="${pageContext.request.contextPath}/${i}" alt="products"></div>
                                                        </div> 
                                                    </c:forEach>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="slider__images">
                                        <!--thanh truot-->
                                        <div class="swiper-container">
                                            <div class="swiper-wrapper">
                                                <c:forEach items="${sessionScope.product.thumbnails}" var="i">
                                                    <div class="swiper-slide">
                                                        <div class="slider__image"><img src="${pageContext.request.contextPath}/${i}" alt="products"></div>
                                                    </div>
                                                </c:forEach>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-xl-6 col-lg-6 col-md-12 col-12">
                        <div class="product-summery">
                            <div class="single-product-inner">
                                <h6><a href="${pageContext.request.contextPath}/filterproductservlet?category=${sessionScope.product.category.categoryId}&minPrice=${sessionScope.minPrice}&maxPrice=${sessionScope.maxPrice}&orderBy=0">Fashion, ${sessionScope.product.category.categoryName}</a></h6>
                                <h3><a href="#">${sessionScope.product.productName}</a></h3>
                                <ul class="single-product-price d-flex">
                                    <li><h3>${sessionScope.product.price}&nbsp;VND</h3></li>
                                    <li><h4>${(sessionScope.product.price + (sessionScope.product.price*sessionScope.product.discount/100))}&nbsp;VND</h4></li>
                                </ul>
                                <div class="product-review d-flex justify-content-between">
                                    <ul class="d-flex">
                                        <c:forEach begin="${1}" end="${product.rating}">
                                            <li><i class="fa-sharp fa-solid fa-star"></i></li>
                                            </c:forEach>
                                            <c:forEach begin="${product.rating + 1}" end="${5}">
                                            <li><i class="fa-sharp fa-regular fa-star"></i></li>
                                            </c:forEach>

                                        <li><a href="#">${sessionScope.listComment.size()} Review</a></li>
                                    </ul>
                                    <div class="product-available" id="product-available"><span> Available : </span> <span>
                                            ${requestScope.quantityStockByColorAndSize != null ? requestScope.quantityStockByColorAndSize : sessionScope.product.quantityStock}
                                        </span></div>
                                    <div class="product-available"><span> Sold : </span> <span>
                                            ${requestScope.quantitySoldByColorAndSize != null ? requestScope.quantitySoldByColorAndSize : sessionScope.product.quantitySold}
                                        </span></div>
                                </div>

                                <form id="f" action="${pageContext.request.contextPath}/productdetail" method="post">

                                    <ul class="product-size d-flex align-items-center">
                                        <li><span>Color</span></li>
                                            <c:forEach items="${sessionScope.listColor}" var="i">
                                            <li class="color${i.colorId} colors" onclick="userOptionColor(this, ${i.colorId}, ${sessionScope.product.productId})">
                                                <a class="click-color" href="javascript:void(0)"><span>${i.color}</span></a>
                                            </li>
                                        </c:forEach>
                                    </ul>

                                    <ul class="product-size d-flex align-items-center">
                                        <li><span>Size</span></li>
                                            <c:forEach items="${sessionScope.listSize}" var="size">
                                            <li class="size${size.sizeId} sizes" onclick="userOptionSize(this, ${size.sizeId}, ${sessionScope.product.productId})"><a class="click-size" href="javascript:void(0)"><span>${size.sizeOption}</span></a></li>
                                                    </c:forEach>
                                    </ul>

                                </form>
                                <span style="font-size: 16px;color: red">${requestScope.errorAddToCart}</span>
                                <span style="font-size: 16px;color: green">${requestScope.addCartSucc}</span>
                                <form action="${pageContext.request.contextPath}/shoppingcart" method="get" id="formAddToCart">
                                    <input type="hidden" name="pid" value="${param.productid}"/>
                                    <input type="hidden" name="cid" value="${param.colorid}"/>
                                    <input type="hidden" name="sid" value="${param.sizeid}"/>
                                    
                                    <ul class="product-add-cart d-flex align-items-center">
                                        <li>
                                            <div class="pro-counter d-flex align-items-center justify-content-between">
                                                <button type="button" onclick="selectQuantityTru()">-</button>
                                                <input name="quantity"  data-value type="number" id="quantity" value="${param.quantity != null ? param.quantity : 0}" min="${0}" readonly>
                                                <button type="button" onclick="selectQuantityCong()">+</button>
                                            </div>
                                        </li>
                                        <li class="btn_box add-cart-btn">
                                            <a onclick="addToCart()" href="javascript:void(0)">Add to Cart <i class="fa-solid fa-cart-shopping"></i></a>
                                        </li>
                                        <li class="btn_box heart-btn">
                                            <a href="${pageContext.request.contextPath}/wishlist?action=add&productid=${param.pid != null ? param.pid : param.productid}"><i class="fa-solid fa-heart"></i></a>
                                        </li>
                                        <li class="btn_box arrow-btn">
                                            <a href="#"><i class="fa-solid fa-arrow-right-arrow-left"></i></a>
                                        </li>
                                    </ul>

                                    <ul class="product-social d-flex align-items-center">
                                        <li><h6>Share</h6></li>
                                        <li><a href="https://www.facebook.com/"><i class="fa-brands fa-facebook-f"></i></a></li>
                                        <li><a href="https://twitter.com/"><i class="fa-brands fa-twitter"></i></a></li>
                                        <li><a href="https://www.google.com/"><i class="fa-brands fa-google-plus-g"></i></a></li>
                                        <li><a href="https://linkedin.com/"><i class="fa-brands fa-linkedin-in"></i></a></li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="product-tabs">
                    <div class="menu-fulter">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation"><a href="#" class="nav-link active" id="pills-home-tab" data-bs-toggle="tab" data-bs-target="#pills-home" role="tab" aria-selected="true">Item Description</a></li>
                            <li class="nav-item" role="presentation"><a href="#" class="nav-link" id="pills-profile-tab" data-bs-toggle="tab" data-bs-target="#pills-profile" role="tab" aria-selected="true">Item information</a></li>
                            <li class="nav-item" role="presentation"><a href="#" class="nav-link " id="pills-contact-tab" data-bs-toggle="tab" data-bs-target="#pills-contact" role="tab" aria-selected="true">Item Review</a></li>
                        </ul>
                    </div>
                    <div class="tab-content" id="pills-tabContent">
                        <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                            <div class="product-discription">
                                <ul class="single-product-features">
                                    <%
                                        Product p = (Product) session.getAttribute("product");
                                        String des = p.getDesciption();
                                        if (des != null) {
                                            String[] listDes = des.split("\\*");
                                            for (int i = 0; i < listDes.length; i++) {
                                    %>
                                    <li><i class="fa-solid fa-angles-right"></i><span> <%= listDes[i]%> </span></li>
                                            <%
                                                    }
                                                }
                                            %>
                                </ul>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                            <div class="product-information">
                                <div class="product-info">
                                    <h3>${product.productName}</h3>
                                    <p><strong>Category:</strong> ${product.category.categoryName} ;</p>
                                    <p><strong>Price: </strong> ${product.price - product.price*product.discount/100}&nbsp;VNĐ ;</p>
                                    <button class="add-cart">Add to Cart</button>
                                </div>
                            </div> 
                        </div>
                        <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">




                            <div class="review-form">
                                <div class="ev-comments">
                                    <div class="comment-wrapper">
                                        <div class="comment-headding">
                                            <h3>${sessionScope.listComment.size()} Review</h3>
                                        </div>

                                        <c:forEach items="${sessionScope.listComment}" var="comment">
                                            <div class="comment-inner  d-lg-flex d-md-block">
                                                <div class="comment-img">
                                                    <img class="rounded-circle img-fluid" style="max-width: 80px"  src="${pageContext.request.contextPath}/${comment.user.image}" alt="product">
                                                </div>
                                                <div class="comment-text">
                                                    <ul class="comment-top d-flex justify-content-between">
                                                        <li>
                                                            <h6>${comment.user.userName}</h6>
                                                            <span>${comment.commentDate}</span>
                                                            <c:if test="${comment.commentDateUpdate != null}">
                                                                <br/>
                                                                <span>edit: ${comment.commentDateUpdate}</span>
                                                            </c:if>
                                                            <c:forEach begin="${1}" end="${comment.rating}">
                                                            <li><i class="fa-sharp fa-solid fa-star"></i></li>
                                                            </c:forEach>
                                                            <c:forEach begin="${comment.rating + 1}" end="${5}">
                                                            <li><i class="fa-sharp fa-regular fa-star"></i></li>
                                                            </c:forEach>
                                                        </li>
                                                        <c:if test="${comment.user.userId == sessionScope.account.userId && comment.luotEdit == 1}">
                                                            <li><a href="#" class="reply-btn">Edit</a></li>
                                                            </c:if>
                                                            <c:if test="${comment.user.userId == sessionScope.account.userId || sessionScope.account.role.roleId == 1}">
                                                            <li><a onclick="deleteComment('updatecommentforproduct?action=delete&userId=${comment.user.userId}&productId=${comment.product.productId}')" href="javascript:void(0)" class="reply-btn">Delete</a></li>

                                                        </c:if>
                                                    </ul>
                                                    <p class="preview-text">${comment.content}</p>
                                                </div>
                                            </div>
                                        </c:forEach>

                                    </div>
                                </div>

                                <%
                                    ProductDAO pd = new ProductDAO();
                                    CommentDAO cmd = new CommentDAO();
                                    User account = (User) session.getAttribute("account");
                                    if (account != null) {
                                        int userId = account.getUserId();
                                        String productId_raw = request.getParameter("pid");

                                        if (productId_raw == null) {
                                            productId_raw = request.getParameter("productid");
                                        }
                                        int productId = Integer.parseInt(productId_raw);

                                        Comment comment = cmd.getCommentByProductIdAndUserId(userId, productId);
                                        request.setAttribute("comment", comment);
                                        int soLanMua = 0;
                                        soLanMua = pd.getNumberOfProductPurchasesByUserIdAndProductId(userId, productId);
                                        request.setAttribute("soLanMua", soLanMua);
                                    }
                                %>
                                <c:if test="${sessionScope.account != null}">

                                    <c:if test="${requestScope.soLanMua >= 1 && requestScope.comment == null}">
                                        <div class="inner-form">
                                            <h3>Add Review</h3>
                                            <form action="addcommentforproduct" method="get">
                                                <label for="name">UserName:</label>
                                                <input type="text" id="name" name="name" value="${sessionScope.account.userName}" readonly>
                                                <input type="hidden" name="userId" value="${sessionScope.account.userId}"/>
                                                <input type="hidden" name="productId" value="${param.pid}"/>

                                                <label for="rating">Overall Review :</label>
                                                <div id="rating" class="overall-rating">
                                                    <div class="rating-wrapper d-flex align-content-center justify-content-between">
                                                        <select name="rating" class="inner-rating">
                                                            <option value="5">5 - Excellent</option>
                                                            <option value="4">4 - Very Good</option>
                                                            <option value="3">3 - Good</option>
                                                            <option value="2">2 - Fair</option>
                                                            <option value="1">1 - Poor</option>
                                                        </select>
                                                        <span><i class="fa-solid fa-angle-down"></i></span>
                                                    </div>
                                                </div>

                                                <label for="content">Content :</label>
                                                <div class="user-comment">
                                                    <textarea id="content" name="content" rows="5" placeholder="Write your review here"></textarea>
                                                </div>

                                                <button type="submit" class="submit-btn">Submit</button>
                                            </form>
                                        </div>
                                    </c:if>


                                    <c:if test="${requestScope.soLanMua >= 1 && requestScope.comment != null && requestScope.comment.luotEdit == 1}">
                                        <div class="inner-form">
                                            <h3>Edit Review</h3>
                                            <form action="updatecommentforproduct" method="get">
                                                <label for="name">UserName:</label>
                                                <input type="hidden" name="action" value="update"/>
                                                <input type="text" id="name" name="name" value="${sessionScope.account.userName}" readonly>
                                                <input type="hidden" name="userId" value="${sessionScope.account.userId}"/>
                                                <input type="hidden" name="productId" value="${requestScope.comment.product.productId}"/>
                                                <label for="date">Date of Purchase:</label>
                                                <input type="text" id="date" name="date" value="${requestScope.comment.commentDate}"  readonly>

                                                <label for="rating">Overall Review :</label>
                                                <div id="rating" class="overall-rating">
                                                    <div class="rating-wrapper d-flex align-content-center justify-content-between">
                                                        <select name="rating" class="inner-rating">
                                                            <option value="5">5 - Excellent</option>
                                                            <option value="4">4 - Very Good</option>
                                                            <option value="3">3 - Good</option>
                                                            <option value="2">2 - Fair</option>
                                                            <option value="1">1 - Poor</option>
                                                        </select>
                                                        <span><i class="fa-solid fa-angle-down"></i></span>
                                                    </div>
                                                </div>

                                                <label for="content">Content :</label>
                                                <div id="content" class="user-comment">
                                                    <textarea id="comments" name="content" rows="5" placeholder="Write your review here">${requestScope.comment.content}</textarea>
                                                </div>

                                                <button type="submit" class="submit-btn">Submit</button>
                                            </form>
                                        </div>
                                    </c:if>

                                </c:if>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- `PRODUCT-SECTION START  -->

        <%            List<Product> ans = (List<Product>) session.getAttribute("viewedProduct");
            List<Product> ans2 = new ArrayList<>();
            for (int i = ans.size() - 1; i >= 0; i--) {
                ans2.add(ans.get(i));
            }
            request.setAttribute("viewedProduct", ans2);
        %>

        <section class="popular-product-section single-popular-product-section">
            <div class="container">
                <div class="heading-text">
                    <h3>Viewed Items</h3>
                </div>
                <div class="swiper products single-product-slider">
                    <div class="swiper-wrapper">
                        <c:if test="${requestScope.viewedProduct.size() == 1}">
                            <h4>You have not viewed any products</h4>
                        </c:if>
                        <c:forEach items="${requestScope.viewedProduct}" var="product">


                            <c:if test="${param.pid != product.productId}">
                                <div class="swiper-slide product single-slide">
                                    <div class="product-img">
                                        <a href="${pageContext.request.contextPath}/productdetail?pid=${product.productId}">
                                            <img src="${pageContext.request.contextPath}/${product.thumbnails.get(0)}" alt="product">
                                        </a>
                                        <div class="product-labels d-flex justify-content-between">
                                            <span class="ev-offer">${product.discount}%</span>
                                            <span class="ev-hot">
                                                <c:if test="${product.discount >= 50}">
                                                    hot
                                                </c:if>
                                            </span>
                                        </div>
                                        <div class="p-option">
                                            <ul class="d-flex align-items-center justify-content-end">
                                                <li class="anim-hidden"><a href="#"><i class="fa-regular fa-eye"></i></a></li>
                                                <li class="anim-hidden"><a href="${pageContext.request.contextPath}/wishlist?action=add&productid=${product.productId}"><i class="fa-solid fa-heart"></i></a></li>
                                                <li class="anim-hidden"><a href="#"><i class="fa-solid fa-cart-shopping"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="product-text">
                                        <ul class="product-stars d-flex">
                                            <c:forEach begin="${1}" end="${product.rating}">
                                                <li><i class="fa-sharp fa-solid fa-star"></i></li>
                                                </c:forEach>
                                                <c:forEach begin="${product.rating + 1}" end="${5}">
                                                <li><i class="fa-sharp fa-regular fa-star"></i></li>
                                                </c:forEach>
                                        </ul>
                                        <h2 class="product-title"><a href="${pageContext.request.contextPath}/productdetail?pid=${product.productId}">${product.productName}</a></h2>
                                        <ul class="d-flex align-items-center">
                                            <li><span>${product.price/1000}K&nbsp;VND</span></li>
                                            <li> <del><span>${(product.price + (product.price*product.discount/100))/1000}K&nbsp;VND</span></del></li>
                                        </ul>
                                    </div>
                                </div>
                            </c:if>

                        </c:forEach>
                    </div>
                    <div class="swiper-pagination"></div>
                </div>
            </div>
        </section>


        <section class="popular-product-section single-popular-product-section">
            <div class="container">
                <div class="heading-text">
                    <h3>Related Items</h3>
                </div>
                <div class="swiper products single-product-slider">
                    <div class="swiper-wrapper">
                        <c:forEach items="${sessionScope.relatedProduct}" var="product">
                            <div class="swiper-slide product single-slide">
                                <div class="product-img">
                                    <a href="${pageContext.request.contextPath}/productdetail?pid=${product.productId}">
                                        <img src="${pageContext.request.contextPath}/${product.thumbnails.get(0)}" alt="product">
                                    </a>
                                    <div class="product-labels d-flex justify-content-between">
                                        <span class="ev-offer">${product.discount}%</span>
                                        <span class="ev-hot">
                                            <c:if test="${product.discount >= 50}">
                                                hot
                                            </c:if>
                                        </span>
                                    </div>
                                    <div class="p-option">
                                        <ul class="d-flex align-items-center justify-content-end">
                                            <li class="anim-hidden"><a href="#"><i class="fa-regular fa-eye"></i></a></li>
                                            <li class="anim-hidden"><a href="${pageContext.request.contextPath}/wishlist?action=add&productid=${product.productId}"><i class="fa-solid fa-heart"></i></a></li>
                                            <li class="anim-hidden"><a href="#"><i class="fa-solid fa-cart-shopping"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="product-text">
                                    <ul class="product-stars d-flex">
                                        <c:forEach begin="${1}" end="${product.rating}">
                                            <li><i class="fa-sharp fa-solid fa-star"></i></li>
                                            </c:forEach>
                                            <c:forEach begin="${product.rating + 1}" end="${5}">
                                            <li><i class="fa-sharp fa-regular fa-star"></i></li>
                                            </c:forEach>
                                    </ul>
                                    <h2 class="product-title"><a href="${pageContext.request.contextPath}/productdetail?pid=${product.productId}">${product.productName}</a></h2>
                                    <ul class="d-flex align-items-center">
                                        <li><span>${product.price/1000}K&nbsp;VND</span></li>
                                        <li> <del><span>${(product.price + (product.price*product.discount/100))/1000}K&nbsp;VND</span></del></li>
                                    </ul>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="swiper-pagination"></div>
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
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/js/addtocart.js"></script>
        <script src="${pageContext.request.contextPath}/js/profile.js"></script>
        <script src="${pageContext.request.contextPath}/js/delete.js"></script>
        <!-- JS-SCRIPT END  -->


    </body>


    <!-- Mirrored from ethemestudio.com/demo/evani/single-product.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 23 Feb 2024 20:03:05 GMT -->
</html>
