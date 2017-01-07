<%--
  Created by IntelliJ IDEA.
  User: stancioi
  Date: 12/24/2016
  Time: 12:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Online Store</title>
</head>
<body>
    <h1>Buy your favourite products</h1>
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Available quantity</th>
            <th>Quantity to add to shopping cart</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <form action="/add_to_shopping_cart">
                    <td>
                        <input name="id" value="${product.id}" readonly="readonly" />
                    </td>
                    <td>
                        <c:out value="${product.productName}" />
                    </td>
                    <td>
                        <c:out value="${product.description}" />
                    </td>
                    <td>
                        <c:out value="${product.price}" /> <span>$</span>
                    </td>
                    <td>
                        <c:out value="${product.quantity}" />
                    </td>
                    <td>
                        <input name="desiredQuantity" type="text"  />
                        <input type="submit" value="Add to shopping cart" />
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Shopping cart</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <tbody>
            <c:forEach items="${shoppingCart.productToRequestedQuantityAndPrice}" var="productQuantityAndPrice">
                <tr>
                    <td>
                        <c:out value="${productQuantityAndPrice.key.id}" />
                    </td>
                    <td>
                        <c:out value="${productQuantityAndPrice.key.productName}" />
                    </td>
                    <td>
                        <c:out value="${productQuantityAndPrice.value.first}" />
                    </td>
                    <td>
                        <c:out value="${productQuantityAndPrice.value.second}" /> $
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
