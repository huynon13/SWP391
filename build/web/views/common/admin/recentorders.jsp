<%-- 
    Document   : recentorders
    Created on : Mar 3, 2024, 6:01:04 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div
    class="card card-table-border-none card-default recent-orders"
    id="recent-orders"
    >
    <div class="card-header justify-content-between">
        <h2>Recent Orders</h2>
    </div>
    <div class="card-body pt-0 pb-5">
        <table
            class="table card-table table-responsive table-responsive-large"
            style="width: 100%">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Customer Name</th>
                    <th class="d-none d-lg-table-cell">Total Product</th>
                    <th class="d-none d-lg-table-cell">Order Date</th>
                    <th class="d-none d-lg-table-cell">Order Cost</th>
                    <th>Status</th>
                    <th></th>
                </tr>
            </thead>


            <tbody>

                <c:forEach items="${sessionScope.top5OrderRecent}" var="order">
                    <tr>
                        <td>${order.key.orderId}</td>
                        <td>
                            <a class="text-dark" href="${pageContext.request.contextPath}/views/admin/item-page/userprofile.jsp?userId=${order.key.user.userId}">${order.key.user.userName}</a>
                        </td>
                        <td class="d-none d-lg-table-cell">${order.value} item</td>
                        <td class="d-none d-lg-table-cell">${order.key.orderDate}</td>
                        <td class="d-none d-lg-table-cell">${order.key.totalMoney}&nbsp;VND</td>
                        <td>
                            <c:if test="${order.key.status == 1}">
                                <span class="badge badge-success">Completed</span>
                            </c:if>
                            <c:if test="${order.key.status == 0}">
                                <span class="badge badge-warning">On Hold</span>
                            </c:if>
                            <c:if test="${order.key.status == 2}">
                                <span class="badge badge-danger">Cancelled</span>
                            </c:if>
                        </td>

                        <td class="text-right">
                            <div
                                class="dropdown show d-inline-block widget-dropdown"
                                >
                                <a
                                    class="dropdown-toggle icon-burger-mini"
                                    href="#"
                                    role="button"
                                    id="dropdown-recent-order1"
                                    data-bs-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                                    data-display="static"
                                    ></a>
                                <ul class="dropdown-menu dropdown-menu-right">

                                    <li class="dropdown-item">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/views/user/item-page/orderdetail.jsp?orderid=${order.key.orderId}">View</a>

                                        <c:if test="${order.key.status == 0}">
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/updateorder?orderId=${order.key.orderId}&status=${2}">Cancel</a>
                                        </c:if>
                                        <c:if test="${order.key.status == 0}">
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/updateorder?orderId=${order.key.orderId}&status=${1}">Completed</a>
                                        </c:if>
                                    </li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</div>