<%-- 
    Document   : sign-up
    Created on : Mar 10, 2024, 10:33:18 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <!-- Mirrored from maraviyainfotech.com/projects/ekka/ekka-v37/ekka-admin/sign-up.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 02 Mar 2024 22:07:43 GMT -->
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Ekka - Admin Dashboard HTML Template." />

        <title>Register</title>

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

        <!-- Ekka CSS -->
        <link id="ekka-css" rel="stylesheet" href="${pageContext.request.contextPath}/css/ekka.css" />

        <!-- FAVICON -->
        <link rel="icon" href="${pageContext.request.contextPath}/images/head/logo/shape-1.png">

    </head>

    <body class="sign-inup" id="body">
        <div
            class="container d-flex align-items-center justify-content-center form-height pt-24px pb-24px"
            >
            <div class="row justify-content-center">
                <div class="col-lg-4 col-md-10" style="width: 385px;">
                    <div class="card">
                        <div class="card-header bg-primary">
                            <div class="ec-brand">
                                <a href="${pageContext.request.contextPath}/home" title="Ekka">
                                    <img
                                        width="50px !important"
                                        class="ec-brand-icon"
                                        src="${pageContext.request.contextPath}/images/head/logo/shape-1.png"
                                        alt=""
                                        />
                                </a>
                            </div>
                        </div>
                        <div class="card-body p-5">
                            <h4 class="text-dark mb-5">Sign Up</h4>
                            <span style="color: red; margin-bottom: 10px">${requestScope.errorRegister}</span>
                            <form action="${pageContext.request.contextPath}/register" method="post">
                                <div class="row">

                                    <div class="form-group col-md-12 mb-4">
                                        <input placeholder="Username" class="form-control" type="text" name="username" value="${param.username}" required/>
                                    </div>

                                    <div class="form-group col-md-12">
                                        <input placeholder="Password" class="form-control" type="password" name="password" value="${param.password}" required/>
                                    </div>
                                     <div class="form-group col-md-12">
                                        <input placeholder="Email" class="form-control" type="text" name="email" value="${param.email}" required/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <input placeholder="Name" class="form-control" type="text" name="name" value="${param.name}" required/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <input placeholder="Phone" class="form-control" type="text" name="phone" value="${param.phone}" required/>
                                    </div>

                                    <div class="col-md-12">


                                        <button
                                            type="submit"
                                            class="btn btn-primary btn-block mb-4"
                                            >
                                            Sign Up
                                        </button>

                                        <p class="sign-upp">
                                            Already have an account?
                                            <a class="text-blue" href="${pageContext.request.contextPath}/views/common/user/login.jsp">Sign in</a>
                                        </p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/js/query-3.5.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>

        <!-- Ekka Custom -->
        <script src="${pageContext.request.contextPath}/js/ekka.js"></script>
    </body>

    <!-- Mirrored from maraviyainfotech.com/projects/ekka/ekka-v37/ekka-admin/sign-up.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 02 Mar 2024 22:07:43 GMT -->
</html>
