<%-- 
    Document   : dashboard
    Created on : Mar 3, 2024, 5:14:28 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en" dir="ltr">
    <!-- Mirrored from maraviyainfotech.com/projects/ekka/ekka-v37/ekka-admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 02 Mar 2024 22:07:13 GMT -->
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta
            name="description"
            content="Ekka - Admin Dashboard eCommerce HTML Template."
            />

        <title>Dashboard</title>

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
        <link
            href="${pageContext.request.contextPath}/css/daterangepicker.css"
            rel="stylesheet"
            />
        <link href="${pageContext.request.contextPath}/css/simplebar.css" rel="stylesheet" />

        <!-- Ekka CSS -->
        <link id="ekka-css" href="${pageContext.request.contextPath}/css/ekka.css" rel="stylesheet" />

        <!-- FAVICON -->
        <link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" />
    </head>

    <body
        class="ec-header-fixed ec-sidebar-fixed ec-sidebar-light ec-header-light"
        id="body"
        >
        <!--  WRAPPER  -->
        <div class="wrapper">

            <!-- LEFT MAIN SIDEBAR -->
            <jsp:include page="../../common/admin/leftmainsidebar.jsp"></jsp:include>


                <!--  PAGE WRAPPER -->
                <div class="ec-page-wrapper">

                    <!-- Header -->
                <jsp:include page="../../common/admin/header.jsp"></jsp:include>


                    <!-- CONTENT WRAPPER -->

                    <div class="ec-content-wrapper">
                        <div class="content">

                            <!-- Top Statistics -->
                        <jsp:include page="../../common/admin/topstatistics.jsp"></jsp:include> 

                            <div class="row">
                                <div class="col-xl-8 col-md-12 p-b-15">
                                    <!-- Sales Graph -->
                                <jsp:include page="../../common/admin/salesgraph.jsp"></jsp:include> 
                                </div>

                                <div class="col-xl-4 col-md-12 p-b-15">
                                    <!-- Doughnut Chart -->
                                <jsp:include page="../../common/admin/ordersoverview.jsp"></jsp:include> 
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xl-8 col-md-12 p-b-15">
                                    <!-- User activity statistics -->
                                <jsp:include page="../../common/admin/useractivity.jsp"></jsp:include> 
                                </div>
                                <div class="col-xl-4 col-md-12 p-b-15">
                                <jsp:include page="../../common/admin/currentusers.jsp"></jsp:include> 
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xl-8 col-12 p-b-15">
                                    <!-- World Chart -->
                                <jsp:include page="../../common/admin/purchasedbycountry.jsp"></jsp:include> 
                                </div>
                                <div class="col-xl-4 col-12 p-b-15">
                                    <!-- Top Sell Table -->
                                <jsp:include page="../../common/admin/soldbycategory.jsp"></jsp:include> 
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-12 p-b-15">
                                    <!-- Recent Order Table -->
                                <jsp:include page="../../common/admin/recentorders.jsp"></jsp:include> 
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xl-5">
                                    <!-- New Customers -->
                                <jsp:include page="../../common/admin/topcustomers.jsp"></jsp:include> 
                                </div>

                                <div class="col-xl-7">
                                    <!-- Top Products -->
                                <jsp:include page="../../common/admin/topproducts.jsp"></jsp:include> 
                                </div>
                            </div>
                        </div>
                        <!-- End Content -->
                    </div>
                    <!-- End Content Wrapper -->

                    <!-- Footer -->
                    <footer class="footer mt-auto">
                        <div class="copyright bg-white">
                            <p>
                                Copyright &copy; <span id="ec-year"></span
                                ><a
                                    class="text-primary"
                                    href="https://themeforest.net/user/ashishmaraviya"
                                    target="_blank"
                                    >
                                    Ekka Admin Dashboard</a
                                >. All Rights Reserved.
                            </p>
                        </div>
                    </footer>
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

        <!-- Chart -->
<!--        <script src="${pageContext.request.contextPath}/js/Chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/chart.js"></script>-->

        <!-- Google map chart -->
<!--        <script src="${pageContext.request.contextPath}/js/google-map-loader.js"></script>
        <script src="${pageContext.request.contextPath}/js/google-map.js"></script>-->

        <!-- Date Range Picker -->
        <script src="${pageContext.request.contextPath}/js/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/daterangepicker.js"></script>
        <script src="${pageContext.request.contextPath}/js/date-range.js"></script>

        <!-- Option Switcher -->
        <script src="${pageContext.request.contextPath}/js/optionswitcher.js"></script>

        <!-- Ekka Custom -->
        <script src="${pageContext.request.contextPath}/js/ekka.js"></script>
    </body>

    <!-- Mirrored from maraviyainfotech.com/projects/ekka/ekka-v37/ekka-admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 02 Mar 2024 22:07:26 GMT -->
</html>
