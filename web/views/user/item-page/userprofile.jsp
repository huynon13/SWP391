<%-- 
    Document   : userprofile
    Created on : Mar 5, 2024, 12:33:09 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">


    <!-- Mirrored from maraviyainfotech.com/projects/ekka/ekka-v37/ekka-admin/user-profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 02 Mar 2024 22:07:34 GMT -->
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
                                <p class="breadcrumbs"><span><a href="${pageContext.request.contextPath}/home">Home</a></span>
                                    <span><i class="mdi mdi-chevron-right"></i></span>Profile
                                </p>
                            </div>
                            <div>
                                <a href="user-list.html" class="btn btn-primary">Edit</a>
                            </div>
                        </div>
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
                                                <a class="btn btn-primary my-3" href="#">Follow</a>
                                            </div>
                                        </div>

                                        <div class="d-flex justify-content-between ">
                                            <div class="text-center pb-4">
                                                <h6 class="text-dark pb-2">546</h6>
                                                <p>Bought</p>
                                            </div>

                                            <div class="text-center pb-4">
                                                <h6 class="text-dark pb-2">32</h6>
                                                <p>Wish List</p>
                                            </div>

                                            <div class="text-center pb-4">
                                                <h6 class="text-dark pb-2">1150</h6>
                                                <p>Following</p>
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
                                        <ul class="nav nav-tabs px-3 px-xl-5 nav-style-border" id="myProfileTab" role="tablist">
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link active" id="profile-tab" data-bs-toggle="tab"
                                                        data-bs-target="#profile" type="button" role="tab"
                                                        aria-controls="profile" aria-selected="true">Profile</button>
                                            </li>
                                            <li class="nav-item" role="presentation">
                                                <button class="nav-link" id="settings-tab" data-bs-toggle="tab"
                                                        data-bs-target="#settings" type="button" role="tab"
                                                        aria-controls="settings" aria-selected="false">Settings</button>
                                            </li>
                                        </ul>
                                        <div class="tab-content px-3 px-xl-5" id="myTabContent">

                                            <div class="tab-pane fade show active" id="profile" role="tabpanel"
                                                 aria-labelledby="profile-tab">
                                                <div class="tab-widget mt-5">
                                                    <div class="row">
                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle mr-3 bg-primary">
                                                                    <i class="mdi mdi-cart-outline text-white "></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2">${sessionScope.orderByUser.size()}</h4>
                                                                    <p>Orders</p>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <c:set var="daMua" value="${0}"/>

                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle mr-3 bg-success">
                                                                    <i class="mdi mdi-checkbox-marked-outline text-white"></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2">02</h4>
                                                                    <p>Items</p>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle bg-warning mr-3">
                                                                    <i class="mdi mdi-cart-outline text-white "></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2">${sessionScope.wishList.size()}</h4>
                                                                    <p>Wish List</p>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <c:set var="totalAmount" value="${0}"/>
                                                        <c:forEach items="${sessionScope.sessionScope.orderByUser}" var="i">
                                                            <c:set var="totalAmount" value="${totalAmount + i.totalMoney}"/>
                                                        </c:forEach>

                                                        <div class="col-xl-3">
                                                            <div class="media widget-media p-3 bg-white border">
                                                                <div class="icon rounded-circle mr-3 bg-success">
                                                                    <i class="mdi mdi-diamond-stone text-white "></i>
                                                                </div>

                                                                <div class="media-body align-self-center">
                                                                    <h4 class="text-primary mb-2">${totalAmount}</h4>
                                                                    <p>Total amount</p>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="row mb-24px">
                                                        <div class="col-xl-12">

                                                            <!-- Notification Table -->
                                                            <div class="card card-default">
                                                                <div class="card-header justify-content-between mb-1">
                                                                    <h2>Latest Notifications</h2>
                                                                    <div>
                                                                        <button class="text-black-50 mr-2 font-size-20"><i
                                                                                class="mdi mdi-cached"></i></button>
                                                                        <div
                                                                            class="dropdown show d-inline-block widget-dropdown">
                                                                            <a class="dropdown-toggle icon-burger-mini"
                                                                               href="#" role="button"
                                                                               id="dropdown-notification"
                                                                               data-bs-toggle="dropdown"
                                                                               aria-haspopup="true" aria-expanded="false"
                                                                               data-display="static"></a>
                                                                            <ul class="dropdown-menu dropdown-menu-right"
                                                                                aria-labelledby="dropdown-notification">
                                                                                <li class="dropdown-item"><a
                                                                                        href="#">Action</a></li>
                                                                                <li class="dropdown-item"><a
                                                                                        href="#">Another action</a></li>
                                                                                <li class="dropdown-item"><a
                                                                                        href="#">Something else here</a>
                                                                                </li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                                <div class="card-body compact-notifications" data-simplebar
                                                                     style="height: 434px;">
                                                                    <div
                                                                        class="media pb-3 align-items-center justify-content-between">
                                                                        <div
                                                                            class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-primary text-white">
                                                                            <i
                                                                                class="mdi mdi-cart-outline font-size-20"></i>
                                                                        </div>
                                                                        <div class="media-body pr-3 ">
                                                                            <a class="mt-0 mb-1 font-size-15 text-dark"
                                                                               href="#">New Order</a>
                                                                            <p>Selena has placed an new order</p>
                                                                        </div>
                                                                        <span class=" font-size-12 d-inline-block"><i
                                                                                class="mdi mdi-clock-outline"></i> 10
                                                                            AM</span>
                                                                    </div>

                                                                    <div
                                                                        class="media py-3 align-items-center justify-content-between">
                                                                        <div
                                                                            class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-success text-white">
                                                                            <i
                                                                                class="mdi mdi-email-outline font-size-20"></i>
                                                                        </div>
                                                                        <div class="media-body pr-3">
                                                                            <a class="mt-0 mb-1 font-size-15 text-dark"
                                                                               href="#">New Enquiry</a>
                                                                            <p>Phileine has placed an new order</p>
                                                                        </div>
                                                                        <span class=" font-size-12 d-inline-block"><i
                                                                                class="mdi mdi-clock-outline"></i> 9
                                                                            AM</span>
                                                                    </div>


                                                                    <div
                                                                        class="media py-3 align-items-center justify-content-between">
                                                                        <div
                                                                            class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-warning text-white">
                                                                            <i
                                                                                class="mdi mdi-stack-exchange font-size-20"></i>
                                                                        </div>
                                                                        <div class="media-body pr-3">
                                                                            <a class="mt-0 mb-1 font-size-15 text-dark"
                                                                               href="#">Support Ticket</a>
                                                                            <p>Emma has placed an new order</p>
                                                                        </div>
                                                                        <span class=" font-size-12 d-inline-block"><i
                                                                                class="mdi mdi-clock-outline"></i> 10
                                                                            AM</span>
                                                                    </div>

                                                                    <div
                                                                        class="media py-3 align-items-center justify-content-between">
                                                                        <div
                                                                            class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-primary text-white">
                                                                            <i
                                                                                class="mdi mdi-cart-outline font-size-20"></i>
                                                                        </div>
                                                                        <div class="media-body pr-3">
                                                                            <a class="mt-0 mb-1 font-size-15 text-dark"
                                                                               href="#">New order</a>
                                                                            <p>Ryan has placed an new order</p>
                                                                        </div>
                                                                        <span class=" font-size-12 d-inline-block"><i
                                                                                class="mdi mdi-clock-outline"></i> 10
                                                                            AM</span>
                                                                    </div>

                                                                    <div
                                                                        class="media py-3 align-items-center justify-content-between">
                                                                        <div
                                                                            class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-info text-white">
                                                                            <i
                                                                                class="mdi mdi-calendar-blank font-size-20"></i>
                                                                        </div>
                                                                        <div class="media-body pr-3">
                                                                            <a class="mt-0 mb-1 font-size-15 text-dark"
                                                                               href="#">Comapny Meetup</a>
                                                                            <p>Phileine has placed an new order</p>
                                                                        </div>
                                                                        <span class=" font-size-12 d-inline-block"><i
                                                                                class="mdi mdi-clock-outline"></i> 10
                                                                            AM</span>
                                                                    </div>

                                                                    <div
                                                                        class="media py-3 align-items-center justify-content-between">
                                                                        <div
                                                                            class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-warning text-white">
                                                                            <i
                                                                                class="mdi mdi-stack-exchange font-size-20"></i>
                                                                        </div>
                                                                        <div class="media-body pr-3">
                                                                            <a class="mt-0 mb-1 font-size-15 text-dark"
                                                                               href="#">Support Ticket</a>
                                                                            <p>Emma has placed an new order</p>
                                                                        </div>
                                                                        <span class=" font-size-12 d-inline-block"><i
                                                                                class="mdi mdi-clock-outline"></i> 10
                                                                            AM</span>
                                                                    </div>

                                                                    <div
                                                                        class="media py-3 align-items-center justify-content-between">
                                                                        <div
                                                                            class="d-flex rounded-circle align-items-center justify-content-center mr-3 media-icon iconbox-45 bg-success text-white">
                                                                            <i
                                                                                class="mdi mdi-email-outline font-size-20"></i>
                                                                        </div>
                                                                        <div class="media-body pr-3">
                                                                            <a class="mt-0 mb-1 font-size-15 text-dark"
                                                                               href="#">New Enquiry</a>
                                                                            <p>Phileine has placed an new order</p>
                                                                        </div>
                                                                        <span class=" font-size-12 d-inline-block"><i
                                                                                class="mdi mdi-clock-outline"></i> 9
                                                                            AM</span>
                                                                    </div>

                                                                </div>
                                                                <div class="mt-3"></div>
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
                                                                                <th>Product_Name</th>
                                                                                <th>Units</th>
                                                                                <th>Order_Date</th>
                                                                                <th>Order_Cost</th>
                                                                                <th>Status</th>
                                                                                <th></th>
                                                                            </tr>
                                                                        </thead>

                                                                        <tbody>
                                                                            <tr>
                                                                                <td>24541</td>
                                                                                <td>
                                                                                    <a class="text-dark" href="#"> Coach
                                                                                        Swagger</a>
                                                                                </td>
                                                                                <td>1 Unit</td>
                                                                                <td>Oct 20, 2018</td>
                                                                                <td>$230</td>
                                                                                <td>
                                                                                    <span
                                                                                        class="badge badge-success">Completed</span>
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
                                                                                                <a href="#">View</a>
                                                                                            </li>

                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">Remove</a>
                                                                                            </li>
                                                                                        </ul>
                                                                                    </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td>24541</td>
                                                                                <td>
                                                                                    <a class="text-dark" href="#"> Toddler
                                                                                        Shoes, Gucci Watch</a>
                                                                                </td>
                                                                                <td>2 Units</td>
                                                                                <td>Nov 15, 2018</td>
                                                                                <td>$550</td>
                                                                                <td>
                                                                                    <span
                                                                                        class="badge badge-warning">Delayed</span>
                                                                                </td>
                                                                                <td class="text-right">
                                                                                    <div
                                                                                        class="dropdown show d-inline-block widget-dropdown">
                                                                                        <a class="dropdown-toggle icon-burger-mini"
                                                                                           href="#" role="button"
                                                                                           id="dropdown-recent-order2"
                                                                                           data-bs-toggle="dropdown"
                                                                                           aria-haspopup="true"
                                                                                           aria-expanded="false"
                                                                                           data-display="static"></a>

                                                                                        <ul class="dropdown-menu dropdown-menu-right"
                                                                                            aria-labelledby="dropdown-recent-order2">
                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">View</a>
                                                                                            </li>

                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">Remove</a>
                                                                                            </li>
                                                                                        </ul>
                                                                                    </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td>24541</td>
                                                                                <td>
                                                                                    <a class="text-dark" href="#"> Hat Black
                                                                                        Suits</a>
                                                                                </td>
                                                                                <td>1 Unit</td>
                                                                                <td>Nov 18, 2018</td>
                                                                                <td>$325</td>
                                                                                <td>
                                                                                    <span class="badge badge-warning">On
                                                                                        Hold</span>
                                                                                </td>
                                                                                <td class="text-right">
                                                                                    <div
                                                                                        class="dropdown show d-inline-block widget-dropdown">
                                                                                        <a class="dropdown-toggle icon-burger-mini"
                                                                                           href="#" role="button"
                                                                                           id="dropdown-recent-order3"
                                                                                           data-bs-toggle="dropdown"
                                                                                           aria-haspopup="true"
                                                                                           aria-expanded="false"
                                                                                           data-display="static"></a>

                                                                                        <ul class="dropdown-menu dropdown-menu-right"
                                                                                            aria-labelledby="dropdown-recent-order3">
                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">View</a>
                                                                                            </li>

                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">Remove</a>
                                                                                            </li>
                                                                                        </ul>
                                                                                    </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td>24541</td>
                                                                                <td>
                                                                                    <a class="text-dark" href="#"> Backpack
                                                                                        Gents, Swimming Cap Slin</a>
                                                                                </td>
                                                                                <td>5 Units</td>
                                                                                <td>Dec 13, 2018</td>
                                                                                <td>$200</td>
                                                                                <td>
                                                                                    <span
                                                                                        class="badge badge-success">Completed</span>
                                                                                </td>
                                                                                <td class="text-right">
                                                                                    <div
                                                                                        class="dropdown show d-inline-block widget-dropdown">
                                                                                        <a class="dropdown-toggle icon-burger-mini"
                                                                                           href="#" role="button"
                                                                                           id="dropdown-recent-order4"
                                                                                           data-bs-toggle="dropdown"
                                                                                           aria-haspopup="true"
                                                                                           aria-expanded="false"
                                                                                           data-display="static"></a>

                                                                                        <ul class="dropdown-menu dropdown-menu-right"
                                                                                            aria-labelledby="dropdown-recent-order4">
                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">View</a>
                                                                                            </li>

                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">Remove</a>
                                                                                            </li>
                                                                                        </ul>
                                                                                    </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td>24541</td>
                                                                                <td>
                                                                                    <a class="text-dark" href="#"> Speed 500
                                                                                        Ignite</a>
                                                                                </td>
                                                                                <td>1 Unit</td>
                                                                                <td>Dec 23, 2018</td>
                                                                                <td>$150</td>
                                                                                <td>
                                                                                    <span
                                                                                        class="badge badge-danger">Cancelled</span>
                                                                                </td>
                                                                                <td class="text-right">
                                                                                    <div
                                                                                        class="dropdown show d-inline-block widget-dropdown">
                                                                                        <a class="dropdown-toggle icon-burger-mini"
                                                                                           href="#" role="button"
                                                                                           id="dropdown-recent-order5"
                                                                                           data-bs-toggle="dropdown"
                                                                                           aria-haspopup="true"
                                                                                           aria-expanded="false"
                                                                                           data-display="static"></a>
                                                                                        <ul class="dropdown-menu dropdown-menu-right"
                                                                                            aria-labelledby="dropdown-recent-order5">
                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">View</a>
                                                                                            </li>

                                                                                            <li class="dropdown-item">
                                                                                                <a href="#">Remove</a>
                                                                                            </li>
                                                                                        </ul>
                                                                                    </div>
                                                                                </td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div> 
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="tab-pane fade" id="settings" role="tabpanel"
                                                 aria-labelledby="settings-tab">
                                                <div class="tab-pane-content mt-5">
                                                    <form>
                                                        <div class="form-group row mb-6">
                                                            <label for="coverImage"
                                                                   class="col-sm-4 col-lg-2 col-form-label">User Image</label>
                                                            <div class="col-sm-8 col-lg-10">
                                                                <div class="custom-file mb-1">
                                                                    <input type="file" class="custom-file-input"
                                                                           id="coverImage" required>
                                                                    <label class="custom-file-label" for="coverImage">Choose
                                                                        file...</label>
                                                                    <div class="invalid-feedback">Example invalid custom
                                                                        file feedback</div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row mb-2">
                                                            <div class="col-lg-6">
                                                                <div class="form-group">
                                                                    <label for="firstName">First name</label>
                                                                    <input type="text" class="form-control" id="firstName"
                                                                           value="First name">
                                                                </div>
                                                            </div>

                                                            <div class="col-lg-6">
                                                                <div class="form-group">
                                                                    <label for="lastName">Last name</label>
                                                                    <input type="text" class="form-control" id="lastName"
                                                                           value="Last name">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="userName">User name</label>
                                                            <input type="text" class="form-control" id="userName"
                                                                   value="User name">
                                                            <span class="d-block mt-1">Accusamus nobis at omnis consequuntur
                                                                culpa tempore saepe animi.</span>
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="email">Email</label>
                                                            <input type="email" class="form-control" id="email"
                                                                   value="ekka.example@gmail.com">
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="oldPassword">Old password</label>
                                                            <input type="password" class="form-control" id="oldPassword">
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="newPassword">New password</label>
                                                            <input type="password" class="form-control" id="newPassword">
                                                        </div>

                                                        <div class="form-group mb-4">
                                                            <label for="conPassword">Confirm password</label>
                                                            <input type="password" class="form-control" id="conPassword">
                                                        </div>

                                                        <div class="d-flex justify-content-end mt-5">
                                                            <button type="submit"
                                                                    class="btn btn-primary mb-2 btn-pill">Update
                                                                Profile</button>
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

        <!-- Option Switcher -->
        <script src="assets/plugins/options-sidebar/optionswitcher.js"></script>

        <!-- Ekka Custom -->
        <script src="assets/js/ekka.js"></script>

    </body>


</html>