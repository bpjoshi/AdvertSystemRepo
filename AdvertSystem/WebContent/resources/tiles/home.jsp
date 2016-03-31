<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<table>
<tr>
<td><a href="${pageContext.request.contextPath}/currentAdverts">View Active Advertisements</a></td>
</tr>
<tr>
<td><a href="${pageContext.request.contextPath}/createAdvert">Create An Advertisement</a></td>
</tr>

<tr>
<!--<sec:authorize access="hasAuthority('ROLE_ADMIN')">
<td><a href="${pageContext.request.contextPath}/admin">Admin Page</a></td>
</sec:authorize> -->
</tr>
</table>