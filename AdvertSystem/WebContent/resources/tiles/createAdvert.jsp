<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/doCreateAdvert" commandName="advert">
		<sf:input type="hidden" name="id" path="id" />
		<table class="formTable">
			<tr>
				<td class="label">Your Service:</td>
				<td><sf:textarea path="advert" class="control" name="advert" rows="3" cols="16"></sf:textarea><br/><sf:errors path="advert" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input class="control" name="submit" type="submit" value="Save Advert" /></td>
			</tr>
			<c:if test="${advert.id!=0}">
			<tr>
				<td></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input class="delete" name="delete" type="submit" value="Delete Advert" /></td>
			</tr>
			</c:if>
		</table>
	</sf:form>
	<br /> <br />
		<!--  <a href="${pageContext.request.contextPath}/logout">Logout</a><br /> -->
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
		<a href="${pageContext.request.contextPath}/admin">Admin Page</a>
		</sec:authorize>