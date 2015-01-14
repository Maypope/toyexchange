<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form>
		<label><form:checkbox path="regularNote" value="regular notification" />Do you want to receive email
			notification of new toys? </label>
		<label>Frequency:</label>
		<form:radiobutton path="frequency" value="Everyday" />Every day
		<form:radiobutton path="frequency" value="Everyweek" />Every week
	    <label><form:checkbox path="interestNote" value="interest notification" />Email you once there are new toys of
			your interests? </label>
			<input type="submit" name="Update preference" value="Update your preference">

	</form:form>
	<div>
		<a href="/toyexchange/users/userinfo?email=${user.username}">Basic Information</a> <a
			href="/toyexchange/users/privacy?email=${user.username}">Basic Information</a> <a
			href="/toyexchange/users/preference?email=${user.username}">Basic Information</a>
	</div>
</body>
</html>