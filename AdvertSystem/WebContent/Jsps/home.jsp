<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advert System Home</title>
</head>
<body>
<br/>
<br />
<br />
<table align="center">
<tr>
<td><a href="${pageContext.request.contextPath}/currentAdverts">View Active Advertisements</a></td>
</tr>
<tr>
<td><a href="${pageContext.request.contextPath}/createAdvert">Create An Advertisement</a></td>
</tr>
<tr>
<sec:authorize access="!isAuthenticated()">
<td><a href="${pageContext.request.contextPath}/login">Login</a></td>
</sec:authorize>
</tr>
</table>
</body>
</html>