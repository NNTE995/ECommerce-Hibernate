<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
</head>
<body>
    <h1>products list</h1>
    
    <div>
    	<form:form action="getProductByName" method="get">
  	    	<input path="productName" name="productName" type="text">
  	    	<input type="submit" value="search product">
  	    	<input path="userId" name="userId" type="hidden" value="${userId}">
    	</form:form>

    	
    </div>
    <div align="center">
        
        <table>
            <tr>
                <td><center>Product Name: </center></td>
                <td><center>Product Category: </center></td>
                <td><center>Price: </center></td>
                <td><center>Available Quantity: </center></td>
            </tr>
            <c:forEach items="${productsList}" var="prod" >
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
                    <td><input type="submit" value="add to cart"></td>
                    
                    <td><a href="deleteProduct/${prod.productId}">delete</a>
                    
                    </form:form>
                    
                </tr>
                <!-- limpiar output de la lista de productos -->
                
            </c:forEach>
            <tr>
                <!--td><a href="viewCart">View Cart</a> </td-->
               <td><a href="viewCart?userId=${userId}">View Cart</a> 
               		<a href="showPurchases?userId=${userId}">My purchases</a> 
               </td>
            </tr>
        </table>
    </div>

</body>
</html>