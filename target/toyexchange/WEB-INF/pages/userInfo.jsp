<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>

	<h1>Welcome ${user.username}, Following is your information.</h1>
	<form:form commandName="user" name="user" action="/toyexchange/users/update" method="POST">
		<form:hidden path="username" />Email address:  ${user.username}<br>
Your post code? <form:input path="postCode" />
		<br>
First Name: <form:input path="firstName" />
		<br>
Last Name: <form:input path="lastName" />
		<br>
Your interests: 
        <label><form:checkbox path="interests" value="Action figures" />Action figures</label>
		<label><form:checkbox path="interests" value="Cars and radio controlled" />Cars and radio controlled </label>
		<label><form:checkbox path="interests" value="Construction toys" />Construction toys </label>
		<label><form:checkbox path="interests" value="Creative toys" />Creative toys </label>
		<label><form:checkbox path="interests" value="Dolls" />Dolls</label>
		<label><form:checkbox path="interests" value="Educational toys" /> Educational toys</label>
		<br>
		<input type="submit" name="Update account" value="Update your information">
		<br>
		<c:out value="${message}"></c:out>
	</form:form>
	<div>
		<a href="/toyexchange/users/userinfo?email=${user.username}">Basic Information</a> 
		<a href="/toyexchange/users/privacy?email=${user.username}">Basic Information</a> 
		<a href="/toyexchange/users/preference?email=${user.username}">Basic Information</a>
	</div>
</body>
</html>