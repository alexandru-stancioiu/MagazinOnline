<%--
  Created by IntelliJ IDEA.
  User: stancioi
  Date: 12/26/2016
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<h1>Add new product to catalog !</h1>
<form action="/do_add_product">
    <table border="1" width="30%" cellpadding="3">
        <thead>
        <tr>
            <th colspan="2">Product</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Product name</td>
            <td><input type="text" name="productName" value="" /></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><textarea name="description" rows="4" cols="50"></textarea></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="" />$</td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity" value=""/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add product"/></td>
        </tr>
        </tbody>
    </table>
</form>
<a href="/catalog">Return to Catalog</a>

</body>
</html>
