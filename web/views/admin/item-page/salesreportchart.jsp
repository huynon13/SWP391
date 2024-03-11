<%-- 
    Document   : addproduct
    Created on : Mar 7, 2024, 8:19:55 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Ekka - Admin Dashboard HTML Template." />

        <title>Dashboard Add Product</title>

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
                    <div class="ec-content-wrapper">
                        <div class="content">
                            <div
                                class="breadcrumb-wrapper d-flex align-items-center justify-content-between row"
                                >
                                <div>
                                    <h1>Report</h1>
                                    <p class="breadcrumbs">
                                        <span><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></span>
                                    <span><i class="mdi mdi-chevron-right"></i></span>Sales Report
                                </p>
                            </div>
                            <script
                                src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
                            </script>
                            <br/>
                            <center>
                                <canvas class="row" id="salesReport" style="width:100%;max-width:700px"></canvas>
                                <form id="revennueByMonth" style="margin-top: 20px" action="${pageContext.request.contextPath}/salesreportchart" method="get">
                                    <select onchange = "submitForm()" name="year">
                                        <option value="${requestScope.year}" ${requestScope.selected == requestScope.year ? 'selected' : ''}>${requestScope.year}</option>
                                        <option value="${requestScope.year - 1}" ${requestScope.selected == (requestScope.year - 1) ? 'selected' : ''}>${requestScope.year - 1}</option>
                                        <option value="${requestScope.year - 2}" ${requestScope.selected == (requestScope.year - 2) ? 'selected' : ''}>${requestScope.year - 2}</option>
                                        <option value="${requestScope.year - 3}" ${requestScope.selected == (requestScope.year - 3) ? 'selected' : ''}>${requestScope.year - 3}</option>
                                        <option value="${requestScope.year - 4}" ${requestScope.selected == (requestScope.year - 4) ? 'selected' : ''}>${requestScope.year - 4}</option>
                                    </select>
                                </form>
                            </center>


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
            <script src="${pageContext.request.contextPath}/js/bootstrap-tagsinput.js"></script>
            <script src="${pageContext.request.contextPath}/js/simplebar.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/optionaddnewproduct.js"></script>
            <!-- Option Switcher -->
            <script src="${pageContext.request.contextPath}/js/optionswitcher.js"></script>

            <!-- Ekka Custom -->
            <script src="${pageContext.request.contextPath}/js/ekka.js"></script>




            <script type="text/javascript">

                                        var salesReport = document.getElementById("salesReport").getContext('2d');

                                        if (salesReport != null) {
                                            var xValuesOrderOverview = ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"];
                                            var yValuesOrderOverview = [${requestScope.month1}, ${requestScope.month2},${requestScope.month3}, ${requestScope.month4}, ${requestScope.month5}, ${requestScope.month6}, ${requestScope.month7}, ${requestScope.month8}, ${requestScope.month9}, ${requestScope.month10}, ${requestScope.month11}, ${requestScope.month12}];
                                            var barColorsOrderOverview = [
                                                "#FF5733",
                                                "#9B59B6",
                                                "#2ECC71",
                                                "#3498DB",
                                                "#F1C40F",
                                                "#E74C3C",
                                                "#1ABC9C",
                                                "#F39C12",
                                                "#34495E",
                                                "#E67E22",
                                                "#8E44AD",
                                                "#27AE60"
                                            ];

                                            var myChartOrderOverview = new Chart(salesReport, {
                                                type: "bar",
                                                data: {
                                                    labels: xValuesOrderOverview,
                                                    datasets: [{
                                                            label: 'Revennue(VNĐ)',
                                                            backgroundColor: barColorsOrderOverview,
                                                            data: yValuesOrderOverview
                                                        }]
                                                },
                                                options: {
                                                    legend: {display: true},
                                                    responsive: true,
                                                    title: {
                                                        display: true,
                                                        text: "Sales Report Chart"
                                                    }
                                                }
                                            });
                                        }

                                        function submitForm() {
                                            var form = document.getElementById("revennueByMonth");
                                            form.submit();
                                        }

            </script>
    </body>

</html>
