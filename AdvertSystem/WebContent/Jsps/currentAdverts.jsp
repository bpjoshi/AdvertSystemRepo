<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Advertisements</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<br/>
<center style="font-size: 25px">Active Advertisements</center>
<br/>
<table border="5px" align="center" class="currentAdverts">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Service</th>
<c:forEach var="iter" items="${adverts}">
	<tr>
  	<td>${iter.id}</td>
   <td>${iter.name}</td>
   <td>${iter.email}</td>
   <td>${iter.advert}</td>
   </tr>
</c:forEach>
</table>
</body>
</html>