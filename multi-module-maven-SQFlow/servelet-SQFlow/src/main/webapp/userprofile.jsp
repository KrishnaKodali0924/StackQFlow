<%@page import="com.SQFlow.sql.entity.User"%>
<%@page import="com.SQFlow.sql.dao.UserDAO"%>
<%@page import="com.SQFLow.nosql.services.QuestionDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Profile</title>
		<link rel="stylesheet" href="tablestyle.css">
	</head>
	<body>
		<h1 style="text-align:center">User Profile</h1>
		<a style="margin-right:20px" href="./uquestions" target="_blank"> User Questions</a>&nbsp
		<a href="./uanswers" target="_blank"> User Answers</a><hr>
		<% 
			UserDAO userDAO = new UserDAO();
			String email = (String)request.getSession().getAttribute("email");
			User user = userDAO.getUserFromEmail(email);
		%>
		<table>
			<tr>
				<td style="height:100px;width:100px">User name</td>
				<td style="height:100px;width:100px"><%=user.getUserName() %> </td>
			</tr>
			<tr class="spaceUnder">
				<td>Email</td>
				<td><%=user.getEmail() %> </td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><%=user.getGender() %> </td>
			</tr>
		</table>
	</body>
</html>