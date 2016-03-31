<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<table class="formTable">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Service</th>
		
		<c:forEach var="iter" items="${adverts}">
			<tr>
				<td>${iter.id}</td>
				<td>${iter.name}</td>
				<td>${iter.email}</td>
				<td>${iter.advert}</td>
			</tr>
		</c:forEach>
</table>
