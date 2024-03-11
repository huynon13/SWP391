<%-- 
    Document   : footer
    Created on : Feb 26, 2024, 6:44:10 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<footer style="background-color: #F7F4EF;" class="footer-section">
    <div class="container">
        <div class="row">
            <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex justify-content-between">
                <div class="widgets-item">
                    <div class="footer-logo">
                        <a href="${pageContext.request.contextPath}/home">
                            <img style="width: 225px;" src="${pageContext.request.contextPath}/images/footer/logo/shape-1.png" alt="footer">
                        </a>
                    </div>
                    <div class="widgets-contacts">
                        <ul>
                            <li><a href="#" class="d-flex"><i class="fa-solid fa-location-dot"></i><span>Đường 452 Linh Sơn, Thạch Thất, Hà Nội</span></a></li>
                            <li><a href="#" class="d-flex"><i class="fa-solid fa-envelope"></i> nghiemxuanloc02@gmail.com</a></li>
                            <li><a href="#" class="d-flex"><i class="fa-solid fa-phone"></i> +84 3377 83926</a></li>
                        </ul>
                    </div>
                    <div class="widgets-social">
                        <ul class="d-flex align-items-center">
                            <li><a href="https://www.facebook.com/"><i class="fa-brands fa-facebook-f"></i></a></li>
                            <li><a href="https://www.youtube.com/"><i class="fa-brands fa-youtube"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
                        
            <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex justify-content-between">
                <div class="widgets-item widgets-p-top d-sm-flex d-block justify-content-around ">
                    <div class="widgets-link-items">
                        <h6>Links</h6>
                        <ul>
                            <li><a href="#">Customer</a></li>
                            <li><a href="#">Visitor</a></li>
                            <li><a href="#">Webmaster</a></li>
                            <li><a href="#">Service</a></li>
                            <li><a href="#">Career</a></li>
                        </ul>
                    </div>
                    <div class="widgets-link-items">
                        <h6>Help</h6>
                        <ul>
                            <li><a href="#">Support</a></li>
                            <li><a href="#">Doc File</a></li>
                            <li><a href="#">Forum</a></li>
                            <li><a href="#">FAQ</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex justify-content-between">
                <div class="widgets-item widgets-p-top">
                    <h6>Recent Posts</h6>
                    <div class="recent-posts d-flex align-items-center">
                        <div class="author-img">
                            <a href="single-blog.html">
                                <img src="${pageContext.request.contextPath}/images/footer/post/shape-1.png" alt="footer">
                            </a>
                        </div>
                        <div class="author-info">
                            <span>April 15, 2021</span>
                            <br>
                            <a href="single-blog.html">Dalia enim ad minim veniam quis</a>
                        </div>
                    </div>
                    <div class="recent-posts d-flex align-items-center">
                        <div class="author-img">
                            <a href="single-blog.html">
                                <img src="${pageContext.request.contextPath}/images/footer/post/shape-2.png" alt="footer">
                            </a>
                        </div>
                        <div class="author-info">
                            <span>April 15, 2021</span>
                            <br>
                            <a href="single-blog.html">Dalia enim ad minim veniam quis</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6 col-sm-6 col-12 d-flex">
                <div class="widgets-item widgets-p-top">
                    <div class="news-letter">
                        <h6>Newsletter</h6>
                        <p>Ut enim ad minim veniam, quis nos trud exercitation ullamco laboris nisi ut aliquip modo</p>
                        <form class="widgets-form d-flex align-items-center justify-content-between" action="https://ethemestudio.com/submit" method="POST">
                            <input type="email" id="email" name="email" placeholder="Your email here" required>
                            <button type="submit"><i class="fa-regular fa-envelope"></i></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="row bottom-footer">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 d-flex align-items-center justify-content-lg-center justify-content-center pb-3">
                    <div class="footer-bottom-center">
                        <span style="font-size: 20px" style="text-align: center">Copyright 2024 © Thời Trang 360 - All rights reserved. </span>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
</footer>