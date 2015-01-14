<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>toyexchange.com registration</title>
<script>
	function notValidEmail(email) {
		reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
		if (email && reg.test(email)) {
			return false;
		}
		return true;
	}
	function notValidPassword(password, passwordRepeat) {
		if (password && passwordRepeat && password.length >= 6 && password === passwordRepeat) {
			return false;
		}
		return true;
	}
	function formcheck() {
		if (notValidEmail(document.user.username.value)
				|| notValidPassword(document.user.password.value, document.user.passwordRepeat.value)) {
			$("#warningMessage")
					.html(
							"There was a problem with your request. \n \
				   Missing or incorrect e-mail address. Please correct and try again.\n \
				   Please enter your password.\n \
				   Password should not less than 6 characters. \
				   Please check that your passwords match and try again.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h1>
		Registration<br> New to toyexchange.com? Register Below.
	</h1>
	<p id="warningMessage" class="warning"></p>
	<form:errors path="*" />

	<form:form commandName="user" name="user" action="/toyexchange/users" method="POST" onsubmit="return formcheck()">
My email address is: <form:input path="username" />
		<form:errors path="username" />
		<br>
Enter your password: <form:password path="password" />
		<form:errors path="password" />
		<br>
Type it again:  <form:password path="passwordRepeat" />
		<form:errors path="passwordRepeat" />
		<br>
Your post code? <form:input path="postCode" />
		<br>
First Name: <form:input path="firstName" />
		<br>
Last Name: <form:input path="lastName" />
		<br>
Please select your interests: 
<label><form:checkbox path="interests" value="Action figures" />Action figures </label>
		<label><form:checkbox path="interests" value="Cars and radio controlled" />Cars and radio controlled </label>
		<label><form:checkbox path="interests" value="Construction toys" />Construction toys </label>
		<label><form:checkbox path="interests" value="Creative toys" />Creative toys </label>
		<label><form:checkbox path="interests" value="Dolls" />Dolls</label>
		<label><form:checkbox path="interests" value="Educational toys" /> Educational toys</label>
		<br>
		<input type="submit" name="Create account" value="Create account">
		<br>
		<c:out value="${message}"></c:out>

	</form:form>
</body>
</html>