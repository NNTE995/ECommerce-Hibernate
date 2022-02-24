<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Confirmation</title>
</head>
<body>
    <h1>Purchase Confirmation</h1>
    <div align="center">
        <table>
            <tr>
                <td><center>Product Name: </center></td>
                <td><center>Product Category: </center></td>
                <td><center>Individual price: </center></td>
                <td><center>Quantity: </center></td>
            </tr>
            <c:forEach items="${cart}" var="prod" >
                <tr>
                    <form:form action="addToCart" method="post" modelAttribute="product">
                    <input path="productId" name="productId" type="hidden" value="${prod.productId}">
                    <input path="productName" name="productName" type="hidden" value="${prod.productName}">
                    <input path="category" name="category" type="hidden" value="${prod.category}">
                    <input path="price" name="price" type="hidden" value="${prod.price}">
                    <input path="productQuantity"  name="productQuantity" type="hidden" value="${prod.productQuantity}">
                    <input path="userId" name="userId" type="hidden" value="${userId}">
                    <td><center>${prod.productName} </center></td>
                    <td><center>${prod.category} </center></td>
                    <td><center>${prod.price} </center></td>
                    <td><center>${prod.productQuantity} </center></td>
                    <!--td><input type="submit" value="add to cart"></td-->
                    </form:form>
                </tr>
            </c:forEach>
            <!-- total Y boton de regreso -->
            <tr>
                <td><a href="getProducts?userId=${userId}">Get back to the list of products</a> </td>
                <!--  td><a href="clearCart?userId=${userId}">Get back to the list of products</a> </td-->
                <td></td>
                <td><center>Total: ${total} </center></td>               
            </tr>
        </table>
    </div>
</body>
</html>