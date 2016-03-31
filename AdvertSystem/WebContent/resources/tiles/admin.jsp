<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table class="formTable">
<tr style="font-size: 17px">
<td>Username</td><td>Email</td><td>Role</td><td>Enabled</td>
</tr>
<c:forEach items="${userList}" var="user">
<tr><td><c:out value="${user.username}" /></td><td><c:out value="${user.email}" /></td><td><c:out value="${user.authority}" /></td><td><c:out value="${user.enabled}" /></td></tr>
</c:forEach>
</table>
