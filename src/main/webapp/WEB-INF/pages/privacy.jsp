<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security</title>
<script>
	function updatePrivacy() {
		if($("#newPass").val().length < 6 || $("#newPass").val() != $("#newPassRepeat").val()){
			$("#warning").html("New password should be at least 6 characters");
			alert("1");
		}
		else{
			alert("2");
			$.ajax({
				type: "POST",
				url : "/toyexchange/users/updatePrivacy",
				data : {
				    username: $("#username").val(),
					oldPass: $("#oldPass").val(), 
					newPass: $("#newPass").val()
				},
				success : function(msg) {
					alert("into function");
					if(msg == "success"){
						window.alert("success");
						$("#success").html("Your new password has been set");
					}
					else{
						$("#warning").html("Please check your old password");
					}
				}
			});
		}
	}
</script>
</head>
<body>
	<div>
		<a href="/toyexchange/users/userinfo?email=${user.username}">Basic Information</a> <br>
		<a href="/toyexchange/users/privacy?email=${user.username}">Privacy</a> <br>
		<a href="/toyexchange/users/preference?email=${user.username}">Preferences</a> <br>
	</div>
	<div>
	<form>
	<label id = "warning"></label>
	<input  type="hidden" id="username" name="username" value="${user.username}"/>
	<label>Please enter your old password: </label> <input type = "password" name = "oldPass" id = "oldPass"><br>
	<label>Please enter your new password: </label> <input type = "password" name = "newPass" id = "newPass"><br>
	<label>Please re-enter your new password: </label> <input type = "password" name = "newPassRepeat" id = "newPassRepeat"><br>
	<input type="button" onclick="updatePrivacy()" value="Update password">
	<div id = "success"></div>
	</form>
	</div>
</body>
</html>