<%--
  Created by IntelliJ IDEA.
  User: stancioi
  Date: 12/25/2016
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Catalog</title>
</head>
<body>
    <h1>Catalog</h1>

    <table style="text-align: center">
        <tbody>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <form action="/update_delete_product">
                    <td>
                        <input name="id" type="text" value="${product.id}" readonly="readonly" />
                    </td>
                    <td>
                        <input name="productName" type="text" value="${product.productName}" />
                    </td>
                    <td>
                        <input name="description" type="text" value="${product.description}" />
                    </td>
                    <td>
                        <input name="price" type="text" value="${product.price}" /> <span>$</span>
                    </td>
                    <td>
                        <input name="quantity" type="text" value="${product.quantity}" />
                    </td>
                    <td>
                        <input name="action" type="submit" value="Update" />
                    </td>
                    <td>
                        <input name="action" type="submit" value="Delete" />
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/add_product">Add new product to catalog</a>
    <a href="/">Return to main page</a>
    <a href="/logout">Logout</a>
</body>
</html>
