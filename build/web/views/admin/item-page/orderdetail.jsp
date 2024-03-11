<%-- 
    Document   : orderdetail
    Created on : Mar 6, 2024, 6:52:36 PM
    Author     : PC
--%>

<%@page import="model.User"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderDetail"%>
<%@page import="model.Order"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">


    <!-- Mirrored from maraviyainfotech.com/projects/ekka/ekka-v37/ekka-admin/order-detail.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 02 Mar 2024 22:07:42 GMT -->
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Ekka - Admin Dashboard HTML Template.">

        <title>Order Detail</title>

        <!-- GOOGLE FONTS -->
        <link rel="preconnect" href="https://fonts.googleapis.com/">
        <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;600;700;800&amp;family=Poppins:wght@300;400;500;600;700;800;900&amp;family=Roboto:wght@400;500;700;900&amp;display=swap" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet" />

        <!-- PLUGINS CSS STYLE -->
        <link href="${pageContext.request.contextPath}/css/simplebar.css" rel="stylesheet" />

        <!-- Ekka CSS -->
        <link id="ekka-css" rel="stylesheet" href="${pageContext.request.contextPath}/css/ekka.css" />

        <!-- FAVICON -->
        <link rel="icon" href="${pageContext.request.contextPath}/images/head/logo/shape-1.png">
    </head>

    <body class="ec-header-fixed ec-sidebar-fixed ec-sidebar-dark ec-header-light" id="body">

        <!-- WRAPPER -->
        <div class="wrapper">

            <!-- LEFT MAIN SIDEBAR -->

            <!-- PAGE WRAPPER -->
            <div style="padding-left: 0;padding-top: 0" class="ec-page-wrapper">

                <!-- Header -->

                <%
                    Map<Order, List<OrderDetail>> mapAll = (Map<Order, List<OrderDetail>>) session.getAttribute("ListAllOrderAndOrderDetail");
                    
                    String orderId_raw = (String) request.getParameter("orderid");
                    int orderId = Integer.parseInt(orderId_raw);
                    
                    Order order = new Order();
                    List<OrderDetail> listOrderDetail = new ArrayList<>();
                    
                    for (Map.Entry<Order, List<OrderDetail>> x : mapAll.entrySet()) {
                        if (x.getKey().getOrderId() == orderId) {
                            order = x.getKey();
                            listOrderDetail = x.getValue();
                            break;
                        }
                    }

                    request.setAttribute("order", order);
                    request.setAttribute("listOrderDetail", listOrderDetail);
                %>

                <!-- CONTENT WRAPPER -->
                <div  class="ec-content-wrapper">
                    <div class="content">
                        <div class="breadcrumb-wrapper breadcrumb-wrapper-2">
                            <h1>Order Detail</h1>
                            <p class="breadcrumbs">
                                <c:if test="${sessionScope.account.role.name == 'Admin'}">
                                    <span><span><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></span>
                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                        </c:if>
                                    <span><a href="${pageContext.request.contextPath}/views/admin/item-page/orderhistory.jsp">Orders List</a></span>
                                    <span><i class="mdi mdi-chevron-right"></i></span>Order Detail
                            </p>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <div class="ec-odr-dtl card card-default">
                                    <div class="card-header card-header-border-bottom d-flex justify-content-between">
                                        <h2 class="ec-odr">Order Detail<br>
                                            <span class="small">Order ID: #${param.orderid}</span>
                                        </h2>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-xl-3 col-lg-6">
                                                <address class="info-grid">
                                                    <div class="info-title"><strong>Customer:</strong></div><br>
                                                    <div class="info-content">
                                                        Name: ${order.user.userName}<br>
                                                        Email: ${order.user.email}<br>
                                                        Address: ${order.user.address}<br>
                                                        <abbr title="Phone">Phone:</abbr> ${order.user.phoneNumber}
                                                    </div>
                                                </address>
                                            </div>
                                            <div class="col-xl-3 col-lg-6">
                                                <address class="info-grid">
                                                    <div class="info-title"><strong>Shipped To:</strong></div><br>
                                                    <div class="info-content">
                                                        Name: ${order.fullName}<br>
                                                        Email: ${order.email}<br>
                                                        Address: ${order.address}<br>
                                                        <abbr title="Phone">Phone:</abbr> ${order.phoneNumber}
                                                    </div>
                                                </address>
                                            </div>
                                            <div class="col-xl-3 col-lg-6">
                                                <address class="info-grid">
                                                    <div class="info-title"><strong>Payment Method:</strong></div><br>
                                                    <div class="info-content">
                                                        ${order.payment.paymentName}<br>
                                                    </div>
                                                </address>
                                            </div>
                                            <div class="col-xl-3 col-lg-6">
                                                <address class="info-grid">
                                                    <div class="info-title"><strong>Order Date:</strong></div><br>
                                                    <div class="info-content">
                                                        ${order.orderDate}<br>
                                                    </div>
                                                </address>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <c:set var="stt" value="${1}"/>
                                            <div class="col-md-12">
                                                <h3 class="tbl-title">PRODUCTS SUMMARY</h3>
                                                <div class="table-responsive">
                                                    <table class="table table-striped o-tbl">
                                                        <thead>
                                                            <tr class="line">
                                                                <td><strong>STT</strong></td>
                                                                <td class="text-center"><strong>IMAGE</strong></td>
                                                                <td class="text-center"><strong>PRODUCT</strong></td>
                                                                <td class="text-center"><strong>Color</strong></td>
                                                                <td class="text-center"><strong>Size</strong></td>
                                                                <td class="text-center"><strong>PRICE/UNIT</strong></td>
                                                                <td class="text-right"><strong>QUANTITY</strong></td>
                                                                <td class="text-right"><strong>SUBTOTAL</strong></td>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${requestScope.listOrderDetail}" var="p">
                                                                <tr class="line">
                                                                    <td>${stt}</td>
                                                                    <td class="text-center"><a style="color: inherit;" href="${pageContext.request.contextPath}/productdetail?pid=${p.product.productId}"><img class="product-img" src="${pageContext.request.contextPath}/${p.product.thumbnails.get(0)}" alt="" /></a></td>
                                                                    <td class="text-center"><strong><a style="color: inherit;" href="${pageContext.request.contextPath}/productdetail?pid=${p.product.productId}">${p.product.productName}</a></strong>
                                                                    <td class="text-center"><strong>${p.color.color}</strong>
                                                                    <td class="text-center"><strong>${p.size.sizeOption}</strong>
                                                                    <td class="text-center"><strong>${p.product.price}</strong>
                                                                    <td class="text-right">${p.quantity}</td>
                                                                    <td class="text-right">${p.quantity * p.product.price}&nbsp;VNĐ</td>
                                                                </tr>
                                                                <c:set var="stt" value="${stt + 1}"/>
                                                            </c:forEach>

                                                            <tr>
                                                                <td colspan="6">
                                                                </td>
                                                                <td class="text-right"><strong>Note</strong></td>
                                                                <td class="text-right"><strong>${order.note}</strong></td>
                                                            </tr>

                                                            <tr>
                                                                <td colspan="6">
                                                                </td>
                                                                <td class="text-right"><strong>Total</strong></td>
                                                                <td class="text-right"><strong>${order.totalMoney}&nbsp;VNĐ</strong></td>
                                                            </tr>

                                                            <tr>
                                                                <td colspan="6">
                                                                </td>
                                                                <td class="text-right"><strong>Payment Status</strong></td>
                                                                <c:if test="${order.status == 0}">
                                                                    <td class="text-right"><strong>Pending</strong></td>
                                                                </c:if>
                                                                <c:if test="${order.status == 1}">
                                                                    <td class="text-right"><strong>Complate</strong></td>
                                                                </c:if>
                                                                <c:if test="${order.status == 2}">
                                                                    <td class="text-right"><strong>Cancel</strong></td>
                                                                </c:if>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Tracking Detail -->
                                <div class="card mt-4 trk-order">
                                    <div
                                        class="d-flex flex-wrap flex-sm-nowrap justify-content-between py-3 px-2 bg-secondary">

                                        <div class="w-100 text-center py-1 px-2"><span class="text-medium">Status:</span>
                                            <c:if test="${order.status == 0}">
                                                Pending
                                            </c:if>
                                            <c:if test="${order.status == 1}">
                                                Complate
                                            </c:if>
                                            <c:if test="${order.status == 2}">
                                                Cancel
                                            </c:if>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- End Content -->
                </div> <!-- End Content Wrapper -->

                <!-- Footer -->
                <footer class="footer mt-auto">
                    <div class="copyright bg-white">
                        <p>
                            Copyright &copy; <span id="ec-year"></span><a class="text-primary"
                                                                          href="${pageContext.request.contextPath}/home" target="_blank"> 360 Fashion Men</a>. All Rights Reserved.
                        </p>
                    </div>
                </footer>

            </div> <!-- End Page Wrapper -->
        </div> <!-- End Wrapper -->

        <!-- Common Javascript -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/simplebar.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>

        <!-- Option Switcher -->
        <script src="${pageContext.request.contextPath}/js/optionswitcher.js"></script>

        <!-- Ekka Custom -->
        <script src="${pageContext.request.contextPath}/js/ekka.js"></script>
    </body>

</html>
