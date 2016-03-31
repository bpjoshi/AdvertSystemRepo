<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a class="title" href="<c:url value='/' />" >Advert System Home</a>

<sec:authorize access="!isAuthenticated()">
<a class="login" href="${pageContext.request.contextPath}/login">Login</a>
</sec:authorize>


<sec:authorize access="isAuthenticated()">
<a class="login" href="${pageContext.request.contextPath}/logout">Logout</a>
</sec:authorize>
