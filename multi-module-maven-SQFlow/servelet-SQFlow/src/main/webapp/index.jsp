<%@page import="org.apache.log4j.config.PropertyGetter"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.SQFLow.nosql.services.QuestionDAO"%>
<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>StackQFlow</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<h1>StackQFlow</h1>
		<a href="./login.html">Login</a>
		<a href="./registration.html">Registration</a>
		<a href="./uquestions" target="_blank"> User Questions</a>
		
		<form method="post" action="">
		<%
			int count = 0;
			QuestionDAO questionDAO = new QuestionDAO();
			Iterator<Question> iterator = questionDAO.findAll().iterator();
			while(iterator.hasNext() && count < 10) {
				count++;
				Question qIterator = iterator.next();
				out.println("<hr>");
				out.println("<a class='search' href='show-questions?qid=" + qIterator.getQID() + " 'target='_blank'>" + qIterator.getTitle() + "</a>");	
			}
		%>
		</form>
	</body>
</html>