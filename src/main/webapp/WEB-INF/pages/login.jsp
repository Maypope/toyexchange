<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>toyexchange.com sign in</title>
<script>
	function formcheck() {
		if (document.user.username.value && document.user.password.value) {
			return true;
		} else {
			$("#warning").html("Please input your email address and password");
			return false;
		}
	}
</script>
</head>
<body>
	<h1>Welcome to toyexchange.com.</h1>
	<h2>What is your email address?</h2>
	<p id="warning"></p>
	<form:form commandName="user" name="user" action="/toyexchange/users/login" method="POST" onsubmit="return formcheck()">
		My email address is: <form:input path="username" />
		<br>
		Please enter your password: <form:password path="password" />
		<br>
		<input type="submit" value="Sign in">
		<br>
		<button type="button" onclick="window.location.href='/toyexchange/users/create'">Create a new account</button>
		<br>
	</form:form>
	<c:out value="${errorInfo}"></c:out>
</body>
</html>