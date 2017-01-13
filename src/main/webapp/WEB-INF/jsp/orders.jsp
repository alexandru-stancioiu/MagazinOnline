<%--
  Created by IntelliJ IDEA.
  User: stancioi
  Date: 1/10/2017
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h1>Previous orders</h1>
<table style="text-align: center; border: 1px black">
    <tbody>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Products</th>
        <th>Total price</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>
                <c:out value="${order.id}" />
            </td>
            <td>
                <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${order.timestamp}" />
            </td>
            <td>
                <c:forEach items="${order.orderItems}" var="orderItem">
                    <c:out value="${orderItem.product.productName}" />
                    <c:out value="${orderItem.quantity}" /> x
                    <c:out value="${orderItem.product.price}" /> $
                    <br/>
                </c:forEach>
            </td>
            <td>
                <c:out value="${order.totalPrice}" /> $
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/">Return to main page</a>
<a href="/logout">Logout</a>
</body>
</html>
