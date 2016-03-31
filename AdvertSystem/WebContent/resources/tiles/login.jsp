<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	<script type="text/javascript">
		$(document).ready(function(){
			document.f.username.focus();
		})
	</script>
	
	<h3>Login with Username and Password</h3>
	<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
		<table class="formTable">
			<tr>
				<td>Username:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td>Remember Me:</td>
				<td><input type="checkbox" name='remember-me' checked="checked" /></td>
			</tr>
			<tr>
			<c:if test="${param.error!=null}">
				<td></td><td class="error">Login failed due bad credentials</td>
			</c:if>
			</tr>
			<tr>
				<td></td><td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
	<a href="<c:url value="/createAccount"/>">Create Account</a>