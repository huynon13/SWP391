<%-- 
    Document   : userprofile
    Created on : Mar 5, 2024, 12:33:09 AM
    Author     : PC
--%>

<%@page import="model.Wallet"%>
<%@page import="dal.WalletDAO"%>
<%@page import="model.User"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="model.OrderDetail"%>
<%@page import="model.Order"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">


    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Ekka - Admin Dashboard HTML Template.">

        <title>User Profile</title>

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
        <link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" />

    </head>

    <body class="ec-header-fixed ec-sidebar-fixed ec-sidebar-dark ec-header-light" id="body">

        <!-- WRAPPER -->
        <div class="wrapper">

            <!-- LEFT MAIN SIDEBAR -->

            <!-- PAGE WRAPPER -->
            <div style="padding-left: 0;padding-top: 0;" class="ec-page-wrapper">

                <!-- Header -->

                <!-- CONTENT WRAPPER -->
                <div class="ec-content-wrapper">
                    <div class="content">
                        <div class="breadcrumb-wrapper breadcrumb-contacts">
                            <div>
                                <h1>User Profile</h1>
                                <p class="breadcrumbs"><span><a href="${pageContext.request.contextPath}/home">Home <i class="mdi mdi-chevron-right"></i></span> </a></span>
                                        <c:if test="${sessionScope.account.role.name == 'Admin'}">
                                            <span><span><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></span>
                                            <span><i class="mdi mdi-chevron-right"></i></span>
                                        </c:if>
                                        Profile
                                </p>
                            </div>
                            <div>
                                <a href="user-list.html" class="btn btn-primary">Edit</a>
                            </div>
                        </div>


                        <%
                            Set<Integer> set = new HashSet<>();
                            User account = (User) session.getAttribute("account");
                            Map<Order, List<OrderDetail>> mapAll = (Map<Order, List<OrderDetail>>) session.getAttribute("ListAllOrderAndOrderDetail");
                            Map<Order, List<OrderDetail>> map = new LinkedHashMap<>();
                            for (Map.Entry<Order, List<OrderDetail>> x : mapAll.entrySet()) {
                                if (x.getKey().getUser().getUserId() == account.getUserId()) {
                                    map.put(x.getKey(), x.getValue());
                                }
                            }
                            
                            WalletDAO wd = new WalletDAO();
                            Wallet wallet = wd.getWalletByUserId(account.getUserId());
                            
                            request.setAttribute("wallet", wallet);
                            
                            request.setAttribute("orderAndOrderDetailByUser", map);
                            int soLuongItemDaMua = 0;
                            int soDonHangThanhCong = 0;
                            int soDonHangDangChoXuLi = 0;
                            int soDonHangThaiBat = 0;
                            double tongSoTienMuaHangThanhCong = 0;
                            
                            for (Map.Entry<Order, List<OrderDetail>> x : map.entrySet()) {
                                if (x.getKey().getStatus() == 0) {
                                    soDonHangDangChoXuLi += 1;
                                } else if (x.getKey().getStatus() == 1) {
                                    tongSoTienMuaHangThanhCong += x.getKey().getTotalMoney();
                                    soDonHangThanhCong += 1;
                                    for (OrderDetail y : x.getValue()) {
                                        soLuongItemDaMua += y.getQuantity();
                                    }
                                } else if (x.getKey().getStatus() == 2) {
                                    soDonHangThaiBat += 1;
                                }
                            }
                        %>
                        <div class="card bg-white profile-content">
                            <div class="row">
                                <div class="col-lg-4 col-xl-3">
                                    <div class="profile-content-left profile-left-spacing">
                                        <div class="text-center widget-profile px-0 border-0">
                                            <div class="card-img mx-auto rounded-circle">
                                                <img src="${pageContext.request.contextPath}/${sessionScope.account.image}" alt="user image">
                                            </div>
                                            <div class="card-body">
                                                <h4 class="py-2 text-dark">${sessionScope.account.fullName}</h4>
                                                <p>User Name: ${sessionScope.account.userName}</p>
                                            </div>
                                        </div>

                                        <div class="d-flex justify-content-between ">
                                            <div class="text-center pb-4">
                                                <h6 class="text-dark pb-2"></h6>
                                                <p></p>
                                            </div>

                                            <div class="text-center pb-4">
                                                <h6 style="margin-top: 10px;" class="text-dark pb-2"><%= soLuongItemDaMua%></h6>
                                                <p>Items success</p>
                                            </div>

                                            <div class="text-center pb-4">
                                                <h6 class="text-dark pb-2"></h6>
                                                <p></p>
                                            </div>
                                        </div>

                                        <hr class="w-100">

                                        <div class="contact-info pt-4">
                                            <h5 class="text-dark">Information</h5>
                                            <p class="text-dark font-weight-medium pt-24px mb-2">Email address</p>
                                            <p>${sessionScope.account.email != null ? sessionScope.account.email : 'empty'}</p>
                                            <p class="text-dark font-weight-medium pt-24px mb-2">Phone Number</p>
                                            <p>${sessionScope.account.phoneNumber != null ? sessionScope.account.phoneNumber : 'empty'}</p>
                                            <p class="text-dark font-weight-medium pt-24px mb-2">Birthday</p>
                                            <p>${sessionScope.account.birthDay != null ? sessionScope.account.birthDay : 'empty'}</p>
                                            <p class="text-dark font-weight-medium pt-24px mb-2">Address</p>
                                            <p>${sessionScope.account.address != null ? sessionScope.account.address : 'empty'}</p>
                                            <p class="text-dark font-weight-medium pt-24px mb-2">Created at</p>
                                            <p>${sessionScope.account.createdAt != null ? sessionScope.account.createdAt : 'empty'}</p>
                                            <p class="text-dark font-weight-medium pt-24px mb-2">updated at</p>
                                            <p>${sessionScope.account.updatedAt != null ? sessionScope.account.updatedAt : 'empty'}</p>
                                        </div>

                                    </div>
                                </div>

                                <div class="col-lg-8 col-xl-9">
                                    <div class="profile-content-right profile-right-spacing py-5">
                                        <ul style="margin-bottom: 15px;" class="nav nav-tabs px-3 px-xl-5 nav-style-border" id="myProfileTab" role="tablist">
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link active" id="settings-tab" data-bs-toggle="tab"
                                                        data-bs-target="#settings" type="button" role="tab"
                                                        aria-controls="settings" aria-selected="false">Settings</button>
                                            </li>

                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link" id="profile-tab" data-bs-toggle="tab"
                                                        data-bs-target="#profile" type="button" role="tab"
                                                        aria-controls="profile" aria-selected="true">Profile</button>
                                            </li>

                                        </ul>
                                        <div class="tab-content px-3 px-xl-5" id="myTabContent">
                                            <span style="color: green">${requestScope.updateSucc}</span>
                                            <div class="tab-pane fade show" id="profile" role="tabpanel"
                                                 aria-labelledby="profile-tab">
                                                <div class="tab-widget mt-5">
                                                    <div class="row">




                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle mr-3 bg-primary">
                                                                    <i class="mdi mdi-cart-outline text-white "></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2"><%= soDonHangThanhCong%></h4>
                                                                    <p>Orders success</p>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <c:set var="daMua" value="${0}"/>
                                                        <c:forEach items="${requestScope.orderAndOrderDetailByUser}" var="i">
                                                            <c:set var="daMua" value="${daMua + i.value.size()}"/>
                                                        </c:forEach>

                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle bg-warning mr-3">
                                                                    <i class="mdi mdi-cart-outline text-white "></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2"><%= soDonHangDangChoXuLi%></h4>
                                                                    <p>Orders pending</p>
                                                                </div>
                                                            </div>
                                                        </div>


                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle bg-warning mr-3">
                                                                    <i class="mdi mdi-cart-outline text-white "></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2"><%= soDonHangThaiBat%></h4>
                                                                    <p>Orders failed</p>
                                                                </div>
                                                            </div>
                                                        </div>




                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle mr-3 bg-success">
                                                                    <i class="mdi mdi-diamond-stone text-white "></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2"><%= tongSoTienMuaHangThanhCong / 1000000%>Tr&nbsp;VNĐ</h4>
                                                                    <p>Total amount</p>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>


                                                    <div class="row">
                                                        <div class="col-12">
                                                            <!-- Recent Order Table -->
                                                            <div class="card card-default card-table-border-none ec-tbl"
                                                                 id="recent-orders">
                                                                <div class="card-header justify-content-between">
                                                                    <h2>Recent Orders</h2>

                                                                    <div class="date-range-report">
                                                                        <span></span>
                                                                    </div>
                                                                </div>

                                                                <div class="card-body pt-0 pb-0 table-responsive">
                                                                    <table class="table">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Order_ID</th>
                                                                                <th>Full Name</th>
                                                                                <th>Units Product</th>
                                                                                <th>Order_Date</th>
                                                                                <th>Order_Cost</th>
                                                                                <th>Status</th>
                                                                                <th></th>
                                                                            </tr>
                                                                        </thead>

                                                                        <tbody>
                                                                            <c:forEach items="${requestScope.orderAndOrderDetailByUser}" var="i">
                                                                                <tr>
                                                                                    <td>${i.key.orderId}</td>
                                                                                    <td>
                                                                                        <a class="text-dark" href="javascript:void(0)"> ${i.key.fullName}</a>
                                                                                    </td>
                                                                                    <td>${i.value.size()} Unit</td>
                                                                                    <td>${i.key.orderDate}</td>
                                                                                    <td>${i.key.totalMoney/1000000}Tr&nbsp;VNĐ</td>
                                                                                    <td>
                                                                                        <c:if test="${i.key.status == 0}">
                                                                                            <span class="badge badge-warning">Pending</span>
                                                                                        </c:if>

                                                                                        <c:if test="${i.key.status == 1}">
                                                                                            <span class="badge badge-success">Completed</span>
                                                                                        </c:if>

                                                                                        <c:if test="${i.key.status == 2}">
                                                                                            <span class="badge badge-danger">Cancelled</span>
                                                                                        </c:if>
                                                                                    </td>
                                                                                    <td class="text-right">
                                                                                        <div
                                                                                            class="dropdown show d-inline-block widget-dropdown">
                                                                                            <a class="dropdown-toggle icon-burger-mini"
                                                                                               href="#" role="button"
                                                                                               id="dropdown-recent-order1"
                                                                                               data-bs-toggle="dropdown"
                                                                                               aria-haspopup="true"
                                                                                               aria-expanded="false"
                                                                                               data-display="static"></a>

                                                                                            <ul class="dropdown-menu dropdown-menu-right"
                                                                                                aria-labelledby="dropdown-recent-order1">
                                                                                                <li class="dropdown-item">
                                                                                                    <a href="${pageContext.request.contextPath}/views/user/item-page/orderdetail.jsp?orderid=${i.key.orderId}">View</a>
                                                                                                </li>

                                                                                                <c:if test="${i.key.status == 0}">
                                                                                                    <li class="dropdown-item">
                                                                                                        <a href="${pageContext.request.contextPath}/updateorder?orderId=${i.key.orderId}&status=${2}">cancel order</a>
                                                                                                    </li>
                                                                                                </c:if>
                                                                                            </ul>
                                                                                        </div>
                                                                                    </td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div> 
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="tab-pane fade show active" id="settings" role="tabpanel"
                                                 aria-labelledby="settings-tab">
                                                <div class="tab-pane-content mt-5">
                                                    <form action="${pageContext.request.contextPath}/updateuser" method="post">
                                                        <div class="form-group row mb-6">
                                                            <label for="coverImage"
                                                                   class="col-sm-4 col-lg-2 col-form-label">User Image</label>
                                                            <div class="col-sm-8 col-lg-10">
                                                                <div class="custom-file mb-1">
                                                                    <input name="image" type="file" class="custom-file-input"
                                                                           id="coverImage" value="${param.image}">
                                                                    <label class="custom-file-label" for="coverImage">Choose
                                                                        file...</label>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row mb-2">
                                                            <div class="col-lg-6">
                                                                <div class="form-group">
                                                                    <label for="firstName">Full Name</label>
                                                                    <input type="text" name="fullName" class="form-control" id="firstName"
                                                                           value="${param.fullName != null ? param.fullName : sessionScope.account.fullName}">
                                                                </div>
                                                            </div>

                                                        </div>


                                                        <div class="form-group mb-4">
                                                            <label for="userName">User name</label>
                                                            <input type="text" class="form-control" id="userName"
                                                                   value="${sessionScope.account.userName}" readonly>
                                                        </div>
                                                        <div class="form-group mb-4">
                                                            <label for="balance">Balance</label>
                                                            <input type="text" class="form-control" id="balance"
                                                                   value="${requestScope.wallet.balance}" readonly>
                                                        </div>
                                                        <span style="color: red">${requestScope.errorPassword}</span>
                                                        <div class="form-group mb-4">
                                                            <label for="oldPassword">Old password</label>
                                                            <input value="${param.oldPassword}" name="oldPassword" type="password" class="form-control" id="oldPassword">
                                                        </div>
                                                        <span style="color: red">${requestScope.errorOldPass}</span>


                                                        <div class="form-group mb-4">
                                                            <label for="newPassword">New password</label>
                                                            <input value="${param.newPassword}" type="password" name="newPassword" class="form-control" id="newPassword">
                                                        </div>
                                                        <span style="color: red">${requestScope.errorNewPass}</span>

                                                        <div class="form-group mb-4">
                                                            <label for="conPassword">Confirm password</label>
                                                            <input value="${param.confirmPassword}" onchange="xacNhanPassword()" type="password" name="confirmPassword" class="form-control" id="conPassword">
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="email">Email</label>
                                                            <input type="email" class="form-control" id="email" name="email"
                                                                   value="${param.email != null ? param.email : sessionScope.account.email}">
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="birthday">BirthDay</label>
                                                            <input type="date" class="form-control" id="birthday" name="birthDay"
                                                                   value="${param.birthDay != null ? param.birthDay : sessionScope.account.birthDay}">
                                                        </div>


                                                        <div class="form-group mb-4">
                                                            <label for="address">Address</label>
                                                            <input type="text" class="form-control" id="address" name="address"
                                                                   value="${param.address != null ? param.address : sessionScope.account.address}">
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="phoneNumber">Phone Number</label>
                                                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                                                                   value="${param.phoneNumber != null ? param.phoneNumber : sessionScope.account.phoneNumber}">
                                                        </div>
                                                        <div class="d-flex justify-content-end mt-5">
                                                            <button type="submit"
                                                                    class="btn btn-primary mb-2 btn-pill">Update Profile</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>

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
                                                                          href="https://themeforest.net/user/ashishmaraviya" target="_blank"> Ekka Admin
                                Dashboard</a>. All Rights Reserved.
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
        <script src="${pageContext.request.contextPath}/js/changepassword.js"></script>
        <!-- Option Switcher -->
        <script src="${pageContext.request.contextPath}/js/optionswitcher.js"></script>

        <!-- Ekka Custom -->
        <script src="${pageContext.request.contextPath}/js/ekka.js"></script>

    </body>


</html>