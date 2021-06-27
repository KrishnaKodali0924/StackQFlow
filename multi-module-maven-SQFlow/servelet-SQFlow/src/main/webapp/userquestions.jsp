<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.SQFLow.nosql.services.QuestionDAO"%>
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
		<a href="postquestion.html">Post Question</a>
		<%List<Question> uQuestions = (ArrayList<Question>)(request.getAttribute("uQuestions")); %>
		<form method="post" action="">
		<%
			for(Question question: uQuestions){
				out.println("<hr>");
				out.println("<a class='search' href='show-questions?qid=" + question.getQID() + " 'target='_blank'>" + question.getTitle() + "</a>");
			}
		%>
		</form>
	</body>
</html>