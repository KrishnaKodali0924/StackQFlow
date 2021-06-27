<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<% Question qDetails = (Question)request.getAttribute("qdetails"); %>
	<head>
		<meta charset="ISO-8859-1">
		<title>Questions</title>
		<link rel="stylesheet" href="qstyle.css">
	</head>
	<body>
		
		<h2><%=qDetails.getTitle()%></h2>
		
		<label for="question">Question</label><br>
		<textarea id="question" disabled rows="10" cols="200"><%=qDetails.getQuestion()%></textarea><br><br>
		
		<form name="votes" method="post" action="votes">
			<input type="hidden" name="qid" value="<%=qDetails.getQID()%>"/>
			<input type="submit" name="upvote" value=<%=String.valueOf(qDetails.getUpVotes())%> /> 
			<input type="submit" name="downvote" value=<%=String.valueOf(qDetails.getDownVotes())%> />
		</form>
		<br><hr>
	</body>
</html>