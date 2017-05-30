<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<h2> Manage Products </h2>
<div id="CreateProduct">

<form action="manage_product_add">

<input type="text" name="id"><input type="text" name="name">
<input type="text" name="description"><input type="submit" value="Create Product">

</form>
</div>
<div id="UpdateProduct">

<form action="manage_product_update">

<input type="text" name="id" value="${selectedProduct.id }">
<input type="text" name="name" value="${selectedProduct.id }">
<input type="text" name="description" value="${selectedProduct.id }">
<input type="submit" value="Update Product">

</form>
</div>
<h2> Delete/Update the Products </h2>

<div id="ShowProduct">


<table>
<thead>
<tr>
<td>Product ID</td>
<td>Product Name</td>
<td>Product Description</td>
<td> Action </td>
</tr>


</thead>

<c:forEach var="product" items="${productList}">

<tr>
<td> ${product.id} </td>
<td> ${product.name} </td>
<td> ${product.description} </td>

<td> <a href="manage_product_delete/${product.id }"> Delete </a>
 <a href="manage_product_edit/"> Edit </a>

 </td>

 </tr>




</table>
</c:forEach>
</div>

</body>
</html>