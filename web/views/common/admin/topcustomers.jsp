<%-- 
    Document   : newcustomers
    Created on : Mar 3, 2024, 6:01:35 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div
    class="card ec-cust-card card-table-border-none card-default"
    >

    <div class="card-header justify-content-between">
        <h2>Top Customers</h2>
    </div>

    <div class="card-body pt-0 pb-15px">
        <table class="table">
            <tbody>

                <c:forEach items="${sessionScope.topUserByTotalMoney}" var="customer">

                    <tr>
                        <td>
                            <div class="media">
                                <div class="media-image mr-3 rounded-circle">
                                    <a href="${pageContext.request.contextPath}/views/admin/item-page/userprofile.jsp?userId=${customer.key.userId}"
                                       ><img
                                            class="profile-img rounded-circle w-45"
                                            src="${pageContext.request.contextPath}/${customer.key.image}"
                                            alt="customer image"
                                            /></a>
                                </div>
                                <div class="media-body align-self-center">
                                    <a href="${pageContext.request.contextPath}/views/admin/item-page/userprofile.jsp?userId=${customer.key.userId}">
                                        <h6 class="mt-0 text-dark font-weight-medium">
                                            ${customer.key.userName}
                                        </h6>
                                    </a>
                                    <small>${customer.key.email}</small>
                                </div>
                            </div>
                        </td>
                        <td></td>
                        <td class="text-dark d-none d-md-block">${customer.value}&nbsp;VNĐ</td>
                    </tr>

                </c:forEach>





            </tbody>
        </table>
    </div>
</div>