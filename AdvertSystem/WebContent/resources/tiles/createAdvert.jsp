<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/doCreateAdvert" commandName="advert">
		<table class="formTable">
			<tr>
				<td class="label">Name:</td>
				<td><sf:input path="name" class="control" name="name" type="text" /><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input path="email" class="control" name="email" type="text" /><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Service:</td>
				<td><sf:textarea path="advert" class="control" name="advert" rows="3" cols="16"></sf:textarea><br/><sf:errors path="advert" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input class="control" name="submit" type="submit" value="Create Advert" /></td>
			</tr>
		</table>
	</sf:form>
	<br /> <br />
		<!--  <a href="${pageContext.request.contextPath}/logout">Logout</a><br /> -->
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
		<a href="${pageContext.request.contextPath}/admin">Admin Page</a>
		</sec:authorize>