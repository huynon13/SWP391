<%-- 
    Document   : soldbyitems
    Created on : Mar 3, 2024, 6:00:15 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card card-default Sold-card-table">
    <div class="card-header justify-content-between">
        <h2>Sold by Category</h2>
    </div>
    <div
        class="card-body py-0 compact-units"
        data-simplebar
        style="height: 534px"
        >
        <table class="table">
            <tbody>

                <c:forEach items="${sessionScope.totalProductSoldByCategory}" var="category">
                    <tr>
                        <td class="text-dark">${category.key.categoryName}</td>
                        <td class="text-center">${category.value}</td>
                        <td class="text-right">
                            33%
                            <i
                                class="mdi mdi-arrow-up-bold text-success pl-1 font-size-12"
                                ></i>
                        </td>
                    </tr>

                </c:forEach>



            </tbody>
        </table>
    </div>
</div>