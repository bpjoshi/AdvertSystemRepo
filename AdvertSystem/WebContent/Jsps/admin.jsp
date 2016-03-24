<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<center><h3>Authorised Users Only!</h3></center>

<table class="formTable" align="center">
<tr style="font-size: 17px">
<td>Username</td><td>Email</td><td>Role</td><td>Enabled</td>
</tr>
<c:forEach items="${userList}" var="user">
<tr><td><c:out value="${user.username}" /></td><td><c:out value="${user.email}" /></td><td><c:out value="${user.authority}" /></td><td><c:out value="${user.enabled}" /></td></tr>
</c:forEach>
</table>

</body>
</html>