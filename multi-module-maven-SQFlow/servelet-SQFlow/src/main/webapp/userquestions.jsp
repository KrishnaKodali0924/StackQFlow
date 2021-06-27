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
	<body style="background-color: lightblue">
	<div style="margin-left: 10%; margin-top: 3%" class"jumbotron">
	<h1 class="display-3">StackQFlow</h1>
	</div>
	<div class="container">
		<a class="btn btn-primary" style="width: 100px"href="postquestion.html">Post Question</a>
		<%List<Question> uQuestions = (ArrayList<Question>)(request.getAttribute("uQuestions")); %>
		<form method="post" action="">
		<%
			if(uQuestions!=null){
				for(Question question: uQuestions){
					out.println("<hr>");
					out.println("<a class='search' href='show-questions?qid=" + question.getQID() + " 'target='_blank'>" + question.getTitle() + "</a>");
				}
			}
		%>
		</form>
		</div>
	</body>
</html>