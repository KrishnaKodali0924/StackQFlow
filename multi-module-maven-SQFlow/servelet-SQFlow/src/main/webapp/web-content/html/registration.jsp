<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registration Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body style="margin-top:10%; margin-left:10%">
	<h2>Enter your details for registration :</h2>
	<form method="post" action="registration"/>
		<table border="2px">
				<tr>
					<td>Enter user name</td>
					<td><input type="text" name="user-name"/></td>
				</tr>
				<tr>
					<td>Enter email</td>
					<td><input type="email" name="email"/></td>
				</tr>
				<tr>
					<td>Enter user password</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td>Select gender</td>
					<td>
						<input type="radio" name="gender" value="male"/> male
						<input type="radio" name="gender" value="female"/> female
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"/></td>
					<td><input type="reset" value="Reset"/></td>
				</tr>
			</table>
	</form>
</body>
</html>