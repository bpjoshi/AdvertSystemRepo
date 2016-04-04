<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<table class="formTable">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Service</th>
		
		<c:forEach var="iter" items="${adverts}">
			<tr>
				<td>${iter.user.name}</td>
				<td>${iter.user.email}</td>
				<td>${iter.advert}</td>
			</tr>
		</c:forEach>
</table>
