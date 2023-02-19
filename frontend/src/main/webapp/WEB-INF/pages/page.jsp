<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}">
</c:set>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Shopping ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Bootstrap quartz theme -->
<!-- 
<link href="${css}/bootswatch-pulse-theme.css" rel="stylesheet">
 -->
<!-- Add custom CSS here -->
<link href="${css}/shopping.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<script>
			window.menu = '${title}'
		</script>
		<!-- Navigation bar -->
		<%@include file="./commons/navbar.jsp"%>
		<div class="content">
			<!-- page content -->
			<c:if test="${homeSelected == true}">
				<%@include file="./commons/home.jsp"%>
			</c:if>

			<c:if test="${productsSelected == true}">
				<%@include file="products.jsp"%>
			</c:if>

			<c:if test="${categoryProductsSelected == true}">
				<%@include file="products.jsp"%>
			</c:if>

			<c:if test="${aboutSelected == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${contactSelected == true}">
				<%@include file="contact.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="./commons/footer.jsp"%>

		<!-- JavaScript -->
		<script src="${js}/jquery-1.10.2.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<script src="${js}/shopping.js"></script>
	</div>
</body>

</html>
