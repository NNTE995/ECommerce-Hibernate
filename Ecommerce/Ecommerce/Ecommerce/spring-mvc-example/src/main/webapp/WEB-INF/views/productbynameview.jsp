<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>

<style><%@include file="../bootstrap.min.css"%></style>

</head>
<body>
    <h1>products list</h1>
    <div align="center">
        <table>
            <tr>
                <td><center>Product Name: </center></td>
                <td><center>Product Category: </center></td>
                <td><center>Price: </center></td>
                <td><center>Available Quantity: </center></td>
            </tr>
            <c:forEach items="${products}" var="prod" >
                <tr>
                    <form:form action="addToCart" method="post" modelAttribute="product">
                    
                    <input path="productId" name="productId" type="hidden" value="${prod.productId}">
                    <input path="productName" name="productName" type="hidden" value="${prod.productName}">
                    <input path="category" name="category" type="hidden" value="${prod.category}">
                    <input path="price" name="price" type="hidden" value="${prod.price}">
                    <input path="producQuantity"  name="producQuantity" type="hidden" value="${prod.productQuantity}">
                    <input path="userId" name="userId" type="hidden" value="${userId}">
                    
                    <td><center>${prod.productName}</center></td>
                    <td><center>${prod.category}</center></td>
                    <td><center>${prod.price}</center></td>
                    <td><center>${prod.productQuantity}</center></td>
                    <td><input type="submit" value="add to cart"></td>
                    </form:form>
                </tr>
            </c:forEach>
            <tr>
				<td><a href="getProducts?userId=${userId}">Get back to the list of products</a></td>
            </tr>
        </table>
    </div>
</body>
</html>