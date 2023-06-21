<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../../resources/style.css">
</head>
<body>
		${requestScope.msg}
<h3>Account Create</h3>
<form action="signUp" method="post">
	<label>EmailId</label>
	<input type="email" name="emailid"><br/>
	<label>Password</label>
	<input type="password" name="password"><br/>
	<input type="submit" value="SignUp">
	<input type="reset" value="reset">
</form>
<br/>
<a href="/ContactManagementApplication/index">Login</a>
</body>
</html>