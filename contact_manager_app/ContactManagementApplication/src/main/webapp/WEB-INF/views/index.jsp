<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
${requestScope.msg}
<h2>Spring MVC with JdbcTemplate Concept</h2>
<h3>Login page</h3>
<form action="signIn" method="post">
	<label>EmailId</label>
	<input type="email" name="emailid" required="required"><br/>
	<label>Password</label>
	<input type="password" name="password" required="required"><br/>
	<input type="submit" value="SignIn">
	<input type="reset" value="reset">
</form>
<br/>
<a href="/ContactManagementApplication/register">SignUp</a>
</body>
</html>