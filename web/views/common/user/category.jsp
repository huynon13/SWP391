<%-- 
    Document   : category
    Created on : Feb 26, 2024, 6:27:19 PM
    Author     : PC
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="categories-section">
    <div class="container">
        <div class="ev-top-content">
            <span>Explore them all</span>
            <h2>Categories</h2>
            <p>Explore our extensive collection of men's clothing, featuring stylish and versatile options for every occasion</p>
        </div>
        <div class="categories-grid">
            <c:forEach items="${sessionScope.numberOfProductByCategory}" var="category">
                <div class="single-categorie">
                    <a href="${pageContext.request.contextPath}/filterproductservlet?category=${category.key.categoryId}&minPrice=${sessionScope.minPrice}&maxPrice=${sessionScope.maxPrice}&orderBy=0" class="categorie-link">
                        <div class="categorie-img">
                            <img src="${pageContext.request.contextPath}/images/index-1/categories/shape-${category.key.categoryId}.png" alt="categories">
                        </div>
                        <div class="categorie-text">
                            <h5>${category.key.categoryName}</h5>
                            <span>${category.value} items</span>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
        <a href="${pageContext.request.contextPath}/filterproductservlet?category=0&minPrice=${sessionScope.minPrice}&maxPrice=${sessionScope.maxPrice}&orderBy=0" class="view-all">View All</a>
    </div>
</section>