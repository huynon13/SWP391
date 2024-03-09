<%-- 
    Document   : productdetail
    Created on : Mar 7, 2024, 8:39:35 PM
    Author     : PC
--%>

<%@page import="model.Comment"%>
<%@page import="dal.CommentDAO"%>
<%@page import="model.Color"%>
<%@page import="model.Size"%>
<%@page import="dal.ColorDAO"%>
<%@page import="dal.SizeDAO"%>
<%@page import="dal.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Ekka - Admin Dashboard HTML Template." />

        <title>Dashboard Product Detail</title>

        <!-- GOOGLE FONTS -->
        <link rel="preconnect" href="https://fonts.googleapis.com/" />
        <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;600;700;800&amp;family=Poppins:wght@300;400;500;600;700;800;900&amp;family=Roboto:wght@400;500;700;900&amp;display=swap"
            rel="stylesheet"
            />

        <link
            href="${pageContext.request.contextPath}/css/materialdesignicons.min.css"
            rel="stylesheet"
            />

        <!-- PLUGINS CSS STYLE -->
        <link href="${pageContext.request.contextPath}/css/simplebar.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/css/slick.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/css/swiper-bundle.min.css" rel="stylesheet" />

        <!-- ekka CSS -->
        <link id="ekka-css" rel="stylesheet" href="${pageContext.request.contextPath}/css/ekka.css" />

        <!-- FAVICON -->
        <link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" />
    </head>

    <body
        class="ec-header-fixed ec-sidebar-fixed ec-sidebar-dark ec-header-light"
        id="body"
        >
        <!-- WRAPPER -->
        <div class="wrapper">
            <!-- LEFT MAIN SIDEBAR -->
            <jsp:include page="../../common/admin/leftmainsidebar.jsp"></jsp:include>
                <!-- PAGE WRAPPER -->
                <div class="ec-page-wrapper">
                    <!-- Header -->
                <jsp:include page="../../common/admin/header.jsp"></jsp:include>
                    <!-- CONTENT WRAPPER -->

                <%
                    ProductDAO pd = new ProductDAO();
                    SizeDAO sd = new SizeDAO();
                    ColorDAO cd = new ColorDAO();
                    CommentDAO cmt = new CommentDAO();
                    
                    String productId_raw = (String) request.getParameter("productId");
                    int productId = Integer.parseInt(productId_raw);
                    Product product = pd.getProductById(productId);
                    request.setAttribute("product", product);
                    int productPending = pd.getPendingByProduct(productId);
                    request.setAttribute("productPending", productPending);
                    
                    
                    List<Size> listSize = sd.getSizeAll();
                    List<Color> listColor = cd.getColorAll();
                    List<Comment> listComment = cmt.getCommentByProductId(productId);
                    
                    request.setAttribute("size", listSize);
                    request.setAttribute("color", listColor);
                    request.setAttribute("comment", listComment);
                    
                %>
                <div class="ec-content-wrapper">
                    <div class="content">
                        <div
                            class="breadcrumb-wrapper d-flex align-items-center justify-content-between"
                            >
                            <div>
                                <h1>Product Detail</h1>
                                <p class="breadcrumbs">
                                    <span><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></span>
                                    <i class="mdi mdi-chevron-right"></i>
                                    <span><a href="${pageContext.request.contextPath}/views/admin/item-page/productlist.jsp">List Product</a></span>
                                    <span><i class="mdi mdi-chevron-right"></i></span>Product Detail
                                </p>
                            </div>
                            <div>
                                <a href="${pageContext.request.contextPath}/views/admin/item-page/editproduct.jsp?productId=${requestScope.product.productId}" class="btn btn-primary"> Edit </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <div class="card card-default">
                                    <div class="card-header card-header-border-bottom">
                                        <h2>Product Detail</h2>
                                    </div>

                                    <div class="card-body product-detail">
                                        <div class="row">
                                            <div class="col-xl-4 col-lg-6">
                                                <div class="row">
                                                    <div class="single-pro-img">
                                                        <div class="single-product-scroll">
                                                            <div class="single-product-cover">


                                                                <c:forEach items="${requestScope.product.thumbnails}" var="image">
                                                                    <div class="single-slide zoom-image-hover">
                                                                        <img
                                                                            class="img-responsive"
                                                                            src="${pageContext.request.contextPath}/${image}"
                                                                            alt=""
                                                                            />
                                                                    </div>
                                                                </c:forEach>


                                                            </div>
                                                            <div class="single-nav-thumb">


                                                                <c:forEach items="${requestScope.product.thumbnails}" var="image">
                                                                    <div class="single-slide">
                                                                        <img
                                                                            class="img-responsive"
                                                                            src="${pageContext.request.contextPath}/${image}"
                                                                            alt=""
                                                                            />
                                                                    </div>  
                                                                </c:forEach>                                                               

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-5 col-lg-6">
                                                <div class="row product-overview">
                                                    <div class="col-12">
                                                        <h5 class="product-title">
                                                            ${product.productName}
                                                        </h5>

                                                        <p class="product-rate">
                                                            <c:forEach begin="${1}" end="${product.rating}">
                                                                <i class="mdi mdi-star is-rated"></i>
                                                            </c:forEach>
                                                            <c:forEach begin="${product.rating + 1}" end="${5}">
                                                                <i class="mdi mdi-star"></i>
                                                            </c:forEach>
                                                        </p>

                                                        <p class="product-price">Price: <span style="color: #FFD481">${product.price}&nbsp;VND</span></p>
                                                        <p class="product-sku">ID#: ${product.productId}</p>
                                                        <ul class="product-size">
                                                            <c:forEach items="${requestScope.size}" var="s">
                                                                <li class="size"><span>${s.sizeOption}</span></li>
                                                                    </c:forEach>
                                                        </ul>
                                                        <ul class="product-size">
                                                            <c:forEach items="${requestScope.color}" var="c">
                                                                <li class="size"><span>${c.color}</span></li>
                                                                    </c:forEach>
                                                        </ul>

                                                        <div class="product-stock">
                                                            <div class="stock">
                                                                <p class="title">Available</p>
                                                                <p class="text">${requestScope.product.quantityStock}</p>
                                                            </div>
                                                            <div class="stock">
                                                                <p class="title">Pending</p>
                                                                <p class="text">${requestScope.productPending}</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xl-3 col-lg-12 u-card">
                                                <div class="card card-default seller-card">
                                                    <div class="card-body text-center">
                                                        <a
                                                            href="javascript:0"
                                                            class="text-secondary d-inline-block"
                                                            >
                                                            <h5 class="text-dark">${requestScope.product.supperlier.company_name}</h5>

                                                            <ul class="list-unstyled">
                                                                <li class="d-flex mb-1">
                                                                    <i class="mdi mdi-map mr-1"></i>
                                                                    <span>${requestScope.product.supperlier.county}</span>
                                                                </li>
                                                                <li class="d-flex">
                                                                    <i class="mdi mdi-whatsapp mr-1"></i>
                                                                    <span>${requestScope.product.supperlier.phoneNumber}</span>
                                                                </li>
                                                            </ul>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="row review-rating mt-4">
                                            <div class="col-12">
                                                <ul
                                                    class="nav nav-tabs"
                                                    id="myRatingTab"
                                                    role="tablist"
                                                    >
                                                    <li class="nav-item">
                                                        <a
                                                            class="nav-link active"
                                                            id="product-detail-tab"
                                                            data-bs-toggle="tab"
                                                            data-bs-target="#productdetail"
                                                            href="#productdetail"
                                                            role="tab"
                                                            aria-selected="true"
                                                            >
                                                            <i class="mdi mdi-library-books mr-1"></i>
                                                            Detail</a
                                                        >
                                                    </li>

                                                    <li class="nav-item">
                                                        <a
                                                            class="nav-link"
                                                            id="product-reviews-tab"
                                                            data-bs-toggle="tab"
                                                            data-bs-target="#productreviews"
                                                            href="#productreviews"
                                                            role="tab"
                                                            aria-selected="false"
                                                            >
                                                            <i class="mdi mdi-star-half mr-1"></i> Reviews</a
                                                        >
                                                    </li>
                                                </ul>
                                                <div class="tab-content" id="myTabContent2">
                                                    <div
                                                        class="tab-pane pt-3 fade show active"
                                                        id="productdetail"
                                                        role="tabpanel"
                                                        >
                                                        <div class="product-discription">
                                                            <ul class="single-product-features">
                                                                <%
                                                                    String des = product.getDesciption();
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


                                                    <div
                                                        class="tab-pane pt-3 fade"
                                                        id="productreviews"
                                                        role="tabpanel"
                                                        >
                                                        <div class="ec-t-review-wrapper">

                                                            <c:forEach items="${requestScope.comment}" var="com">
                                                                <div class="ec-t-review-item">
                                                                    <div class="ec-t-review-avtar">
                                                                        <img
                                                                            src="${pageContext.request.contextPath}/${com.user.image}"
                                                                            alt=""
                                                                            />
                                                                    </div>
                                                                    <div class="ec-t-review-content">
                                                                        <div class="ec-t-review-top">
                                                                            <p class="ec-t-review-name">${com.user.userName}</p>
                                                                            <div class="ec-t-rate">
                                                                                <c:forEach begin="${1}" end="${com.rating}">
                                                                                    <i class="mdi mdi-star is-rated"></i>
                                                                                </c:forEach>
                                                                                <c:forEach begin="${com.rating + 1}" end="${5}">
                                                                                    <i class="mdi mdi-star"></i>
                                                                                </c:forEach>
                                                                            </div>
                                                                        </div>

                                                                        <div class="ec-t-review-bottom">
                                                                            <p>
                                                                                ${com.content}
                                                                            </p>
                                                                            <p>
                                                                                <c:if test="${com.user.userId == sessionScope.account.userId && com.luotEdit == 1}">
                                                                                    <a href="${pageContext.request.contextPath}/productdetail?pid=${param.productId}">Edit</a>
                                                                                </c:if>
                                                                                <a onclick="deleteComment('${pageContext.request.contextPath}/updatecommentforproduct?action=delete&userId=${sessionScope.account.userId}&productId=${param.productId}')"  href="javascript:void(0)">Delete</a>
                                                                            </p>

                                                                        </div>

                                                                    </div>

                                                                </div>
                                                            </c:forEach>



                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>
                <!-- End Content Wrapper -->

                <!-- Footer -->
                <jsp:include page="../../common/admin/footer.jsp"></jsp:include>
                </div>
                <!-- End Page Wrapper -->
            </div>
            <!-- End Wrapper -->

            <!-- Common Javascript -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/simplebar.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/swiper-bundle.min.js"></script>

        <!-- Option Switcher -->
        <script src="${pageContext.request.contextPath}/js/optionswitcher.js"></script>

        <!-- Ekka Custom -->
        <script src="${pageContext.request.contextPath}/js/ekka.js"></script>
        <script src="${pageContext.request.contextPath}/js/delete.js"></script>
    </body>

</html>
