<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@page import="com.SQFLow.nosql.services.QuestionDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Answer</title>
		<link rel="stylesheet" href="qpstyle.css">
	</head>
	<body>
		<% 
			QuestionDAO questionDAO = new QuestionDAO(); 
			Question question = questionDAO.findById(request.getParameter("qid"));
		%>
		<h1><%=question.getTitle()%></h1><br>
		<h3><%=question.getQuestion()%></h3><br>
		<hr>
		<h3>Answer</h3>
		<form method = "post" action = "post-answer">
			<input type="hidden" name="qid" value="<%=question.getQID()%>"/> 
			<textarea id="answer" name="answer" rows=20 cols=150 required></textarea><br>  	
			<input type="submit" value="Submit">
		</form>
	</body>
</html>