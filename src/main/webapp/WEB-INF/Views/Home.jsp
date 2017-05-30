<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ page isELIgnored="false" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<center>
		<h2>Welcome to HomeCart</h2>
</center>
<a href="LoginPage">    <button type="button" class="btn btn-info">
<span class="glyphicon glyphicon-user">Login</span></button></a>

	
	<tex-align=left><a href="RegistrationPage"> <button type="button" class="btn btn-info">
	<span class="glyphicon glyphicon-user">Register</span></button></a>
	
	<br>
<jsp:include page="Header.jsp"></jsp:include>

	
	
	<hr color="blue">
	<c:if test="${isAdmin=='true'}">
		<jsp:include page="Admin/adminhome.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedCategories=='true'}">

	<jsp:include page="Admin/category.jsp"></jsp:include>  

	</c:if>

	
	<c:if test="${isAdminClickedSuppliers=='true'}">
		<jsp:include page="Admin/supplier.jsp"></jsp:include> <br>
	</c:if>

<c:if test="${isAdminClickedProducts=='true'}">
<jsp:include page="Admin/product.jsp"></jsp:include> <br>
</c:if>
	

	
	<c:if test="${isUserClickedLogin=='true'}">

		<jsp:include page="Login.jsp"></jsp:include>

	</c:if>


	<c:if test="${isUserClickedRegister=='true' }">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>
	
	<%@include file="Courosel.jsp" %>
	
</body>
</html>