<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<p></p>
<table class="formTable">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Service</th>
		
		<c:forEach var="iter" items="${advertList}">
			<tr>
				<td>${iter.user.name}</td>
				<td>${iter.user.email}</td>
				<td>${iter.advert}</td>
			</tr>
		</c:forEach>
</table>
<p></p>
<c:choose>
	<c:when test="${hasAdverts}">
		<a href="${pageContext.request.contextPath}/createAdvert">Update your Advertisement</a>
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/createAdvert">Create An Advertisement</a>
	</c:otherwise>
</c:choose>
<!--  
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
<a href="${pageContext.request.contextPath}/admin">Admin Page</a>
</sec:authorize> -->
