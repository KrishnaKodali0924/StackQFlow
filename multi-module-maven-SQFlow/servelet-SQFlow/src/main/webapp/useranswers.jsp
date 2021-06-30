<%@page import="java.util.ArrayList"%>
<%@page import="com.SQFLow.nosql.entity.Answer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Questions</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<h1 style="text-align:center">Your Answers</h1>
		<%List<Answer> uAnswers= (ArrayList<Answer>)(request.getAttribute("uAnswers")); %>
		<form method="post" action="">
		<%
			for(Answer answer: uAnswers){
				out.println("<hr>");
				out.println("<p style='font-size: 30px'>" + answer.getAnswer() + "</p>");
			}
		%>
		</form>
	</body>
</html>