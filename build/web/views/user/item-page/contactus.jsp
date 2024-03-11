<%-- 
    Document   : contactus
    Created on : Mar 10, 2024, 1:18:26 PM
    Author     : PC
--%>

<%@page import="model.FeedBack"%>
<%@page import="model.User"%>
<%@page import="dal.FeedBackDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zxx">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/awesome.min.css" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/unpkg.swiper.css" />

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/leaflet.css" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.min.css" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webfonts/all.min.css" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webfonts/fontawesome.min.css" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

        <title>Contact Us</title>

        <link rel="icon" href="${pageContext.request.contextPath}/images/head/logo/shape-1.png">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css" />
    </head>
    <body>
        <!-- HEADER-SECTION START  -->
        <jsp:include page="../../common/user/header.jsp"></jsp:include>

            <!-- HEADER-SECTION END  -->

            <!-- BANNER-SECTION START  -->

            <section
                class="hero-section ev-common-hero"
                style="background-image: url(images/common-banner/shape-1.png)"
                >
                <div class="container-fluid">
                    <div class="ev-hero-content">
                        <h2>Contact Us</h2>
                        <span><a href="${pageContext.request.contextPath}/home">Home</a> > Contact</span>
                </div>
            </div>
        </section>

        <!-- BANNER-SECTION END  -->

        <!--  CONTACT-US-SECTION START  -->

        <section class="ev-contact-us-section">
            <div class="container">
                <div
                    class="ev-top-content justify-content-md-center justify-content-sm-start"
                    >
                    <span>Contact Us</span>
                    <h2>Stay Connected</h2>
                </div>
                <div class="row">
                    <div class="col-xl-6 col-md-6 col-12">
                        <div class="contact-left">
                            <div class="contact-inner">
                                <p>
                                    Unleash Your Style, Define Your Identity: Explore Trendsetting Men's Apparel at Our Fashion Destination!
                                </p>
                                <ul>
                                    <li>
                                        <a href="#" class="d-flex align-items-center">
                                            <i class="fa-solid fa-location-dot"></i>
                                            <div class="inner-text">
                                                <h6>Address</h6>
                                                <span>Kim Quy, Minh Tân, Phú Xuyên Hà Nội</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex align-items-center">
                                            <i class="fa-solid fa-phone"></i>
                                            <div class="inner-text">
                                                <h6>Call us</h6>
                                                <span>0337783926</span>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex align-items-center">
                                            <i class="fa-regular fa-envelope"></i>
                                            <div class="inner-text">
                                                <h6>Email Us</h6>
                                                <span>nghiemxuanloc02@gmail.com</span>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>


                    <%
                        FeedBackDAO fd = new FeedBackDAO();
                        User account = (User) session.getAttribute("account");

                        if (account != null) {
                            FeedBack fb = fd.getFeedBackByUserId(account.getUserId());
                            request.setAttribute("feedback", fb);
                        }
                    %>


                    <div class="col-xl-6 col-md-6 col-12">
                        <div class="contact-right">
                            <div class="form-message">
                                <p></p>
                            </div>



                            <c:if test="${sessionScope.account != null}">
                                <c:if test="${requestScope.feedback == null}">
                                    <form class="contuct-form" action="${pageContext.request.contextPath}/addcontactus" method="get">
                                        <div style="font-size: 16px" class="row form-group">
                                            <div class="col-12">
                                                <label for="inputName" class="form-label"
                                                       >Name:</label
                                                >
                                                <input type="hidden" name="userId" value="${sessionScope.account.userId}"/>
                                                <input
                                                    type="text"
                                                    value="${sessionScope.account.userName}"
                                                    name="name"
                                                    id="inputName"
                                                    readonly
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="inputEmail" class="form-label"
                                                       >Email:</label
                                                >
                                                <input
                                                    type="email"
                                                    value="${sessionScope.account.email}"
                                                    name="email"
                                                    id="inputEmail"
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="inputPhone" class="form-label"
                                                       >Phone:</label
                                                >
                                                <input
                                                    type="number"
                                                    value="${sessionScope.account.phoneNumber}"
                                                    name="phone"
                                                    id="inputPhone"
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="subject" class="form-label"
                                                       >Subject:</label
                                                >
                                                <input
                                                    type="text"
                                                    placeholder="Your Subject"
                                                    name="subject"
                                                    id="subject"
                                                    required
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="inputMessage" class="form-label"
                                                       >Message:</label
                                                >
                                                <textarea
                                                    class="input-textarea"
                                                    name="message"
                                                    rows="5"
                                                    cols="30"
                                                    id="inputMessage"
                                                    placeholder="Write your message here"
                                                    required
                                                    ></textarea>
                                            </div>
                                            <div class="col-12">
                                                <div class="common-btn submit-btn">
                                                    <button
                                                        type="submit"
                                                        name="submit"
                                                        >
                                                        Submit Now
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </c:if>


                                <c:if test="${requestScope.feedback != null}">
                                    <form class="contuct-form" action="${pageContext.request.contextPath}/updatecontactus" method="get">
                                        <div style="font-size: 16px" class="row form-group">
                                            <span style="color: green">${requestScope.updateFeedBackSuccess}</span>
                                            <div class="col-12">
                                                <label for="inputName" class="form-label"
                                                       >Name:</label
                                                >
                                                <input type="hidden" name="action" value="update"/>
                                                <input type="hidden" name="feedbackId" value="${requestScope.feedback.feedbackId}"/>
                                                <input
                                                    type="text"
                                                    value="${sessionScope.account.userName}"
                                                    name="name"
                                                    id="inputName"
                                                    readonly
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="inputEmail" class="form-label"
                                                       >Email:</label
                                                >
                                                <input
                                                    type="email"
                                                    value="${sessionScope.account.email}"
                                                    name="email"
                                                    id="inputEmail"
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="inputPhone" class="form-label"
                                                       >Phone:</label
                                                >
                                                <input
                                                    type="number"
                                                    value="${sessionScope.account.phoneNumber}"
                                                    name="phone"
                                                    id="inputPhone"
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="subject" class="form-label"
                                                       >Subject:</label
                                                >
                                                <input
                                                    type="text"
                                                    placeholder="Your Subject"
                                                    name="subject"
                                                    id="subject"
                                                    value="${requestScope.feedback.subjectName}"
                                                    required
                                                    />
                                            </div>
                                            <div class="col-12">
                                                <label for="inputMessage" class="form-label"
                                                       >Message:</label
                                                >
                                                <textarea
                                                    class="input-textarea"
                                                    name="message"
                                                    rows="5"
                                                    cols="30"
                                                    id="inputMessage"
                                                    placeholder="Write your message here"
                                                    required
                                                    >${requestScope.feedback.note}</textarea>
                                            </div>
                                            <div class="col-12">
                                                <div class="common-btn submit-btn">
                                                    <button
                                                        type="submit"
                                                        name="submit"
                                                        >
                                                        Edit Submit Now
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </c:if>


                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--  CONTACT-US-SECTION END  -->

        <!-- CONTACT-MAP-SECTION START  -->

        <div class="map-section">
            <div class="container">

                <div id="map">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3732.9059051077606!2d105.96965017532919!3d20.673406799888827!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135c7fec983b6a3%3A0x6a54c6f01fa0c114!2zTmjDoCBWxINuIEjDs2EgS2ltIFF1eQ!5e0!3m2!1sen!2s!4v1710163516722!5m2!1sen!2s" width="1185" height="430" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
        </div>

        <!-- CONTACT-MAP-SECTION START  -->

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
        <script src="${pageContext.request.contextPath}/js/bootstrop-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/popper.js"></script>
        <script src="${pageContext.request.contextPath}/js/swiper.js"></script>
        <script src="${pageContext.request.contextPath}/js/mmenu.js"></script>
        <script src="${pageContext.request.contextPath}/js/leaflet.js"></script>
        <script src="${pageContext.request.contextPath}/js/script.js"></script>
        <script src="${pageContext.request.contextPath}/js/profile.js"></script>
        <script></script>

        <!-- JS-SCRIPT END  -->
    </body>

</html>
