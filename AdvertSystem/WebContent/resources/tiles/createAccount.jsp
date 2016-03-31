<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	<sf:form id="userdetails" method="post"
		action="${pageContext.request.contextPath}/doCreateAccount" commandName="user">
		<table class="formTable">
			<tr>
				<td class="label">Username:</td>
				<td><sf:input path="username" class="control" name="username" type="text" /><br/><div class="error"><sf:errors path="username"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input path="email" class="control" name="email" type="text" /><br/><div class="error"><sf:errors path="email"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input id="password" path="password" class="control" name="password" type="password" /><br/><div class="error"><sf:errors path="password"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" class="control" name="confirmpass" type="password" /><div id="matchpass"></div></td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input class="control" name="submit" type="submit" value="Create Account" /></td>
			</tr>
		</table>
	</sf:form>