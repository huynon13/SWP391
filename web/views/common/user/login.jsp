<%-- 
    Document   : sign-in
    Created on : Mar 10, 2024, 10:13:18 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Ekka - Admin Dashboard HTML Template." />

        <title>Login</title>

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
            class="container d-flex align-items-center justify-content-center form-height-login pt-24px pb-24px"
            >
            <div class="row justify-content-center">
                <div class="col-lg-6 col-md-10">
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
                            <h4 class="text-dark mb-5">Login</h4>
                            <span style="color: red">${requestScope.errorLogin}</span>
                            <form action="${pageContext.request.contextPath}/login" method="post">
                                <div class="row">
                                    <div class="form-group col-md-12 mb-4">
                                        <input placeholder="Username" class="form-control" type="text" name="username" value="${param.username}" required/>
                                    </div>

                                    <div class="form-group col-md-12">
                                        <input class="form-control" placeholder="Password" type="password" name="password" value="${param.password}" required/>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="d-flex my-2 justify-content-between">
                                            <div class="d-inline-block mr-3">
                                                <input name="rememberme" id="remember" type="checkbox"/>
                                                <label for="remember"> Remember me</label>
                                            </div>
                                            
                                        </div>

                                        <button
                                            type="submit"
                                            class="btn btn-primary btn-block mb-4"
                                            >
                                            Sign In
                                        </button>

                                        <p class="sign-upp">
                                            Don't have an account yet ?
                                            <a class="text-blue" href="${pageContext.request.contextPath}/views/common/user/register.jsp">Sign Up</a><br>
                                            <a class="text-blue" href="${pageContext.request.contextPath}/fogetPassword">Forget password</a>
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
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.zoom.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>

        <!-- Ekka Custom -->
        <script src="${pageContext.request.contextPath}/js/ekka.js"></script>
    </body>

</html>
