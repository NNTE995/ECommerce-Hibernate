<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User historic</title>
</head>
<body>

     <c:forEach items ="${purchases}" var="purchase">
     <div>
		<!-- p>${purchase.userId}</p-->
		<p><center>${purchase.total}</center></p>
		<p><center>${purchase.date}</center></p>
	</div>
	
	<table>
            <tr>
                <td><center>Product name: </center></td>
                <td><center>Category: </center></td>
                <td><center>Price: </center></td>
                <td><center>Quantity: </center></td>
            </tr>
            <c:forEach items ="${purchase.products}" var="prod">
                <tr>
                    <td>${prod.productName}</td>
                    <td>${prod.category}</td>
                    <td>${prod.price}</td>
                    <td>${prod.productQuantity} </td>
                </tr>
            </c:forEach>            
        
        </table>

	</br>
	</hr>
     </c:forEach>
	</br>
	</hr>
                <td><a href="getProducts?userId=${userId}">Get back to the list of products</a></td>

</body>
</html>