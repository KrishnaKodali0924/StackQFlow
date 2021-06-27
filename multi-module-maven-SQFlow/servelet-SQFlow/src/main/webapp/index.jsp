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
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body style="background-color: lightblue">
	<div style="margin-left: 10%; margin-top: 3%" class"jumbotron">
	<h1 class="display-3">StackQFlow</h1>
	</div>
		
		<%
			Cookie[] cookies = request.getCookies();
			Cookie cookieToProcess = null;
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email")) {
					cookieToProcess = cookie;
					break;
				}
			}
			if(cookieToProcess == null || cookieToProcess.getValue().equals("")){
		%>
		<div style="margin-left: 95%">
		<a href="login.html" class="btn btn-link">Login</a>
		<a href="registration.jsp" class="btn btn-link">Registration</a>
		</div>
		<%
			} else {
		%>
				<div style="margin-left: 95%">
		<form action="home" method="post" style="width: 70px; ">
		    <button type="submit" class="btn btn-link">Logout</button>
		</form>
				</div>
		<% 
			}
		%>
		<a href="userquestions.jsp" target="_blank"> User Questions</a>
		
		<form method="post" action="">
		<table class="table table-hover">
		<%
			int count = 0;
			QuestionDAO questionDAO = new QuestionDAO();
			Iterator<Question> iterator = questionDAO.findAll().iterator();
			while(iterator.hasNext() && count < 10) {
				count++;
				Question qIterator = iterator.next();
				out.println("<tr class=\"table-primary\">");
				out.println("<td><a class='search' href='show-questions?qid=" + qIterator.getQID() + " 'target='_blank'>" + qIterator.getTitle() + "</a></td></tr>");	
			}
		%>
		</table>
		</form>
	</body>
</html>