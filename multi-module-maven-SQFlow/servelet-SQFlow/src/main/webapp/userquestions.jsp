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
	</head>
	<body>
		<form method="post" action="">
		<%
			Iterator<Question> uQuestions = request.getAttribute("uQuestions.jsp");
			out.println(uQuestions.next().getTitle());
		%>
		</form>
	</body>
</html>