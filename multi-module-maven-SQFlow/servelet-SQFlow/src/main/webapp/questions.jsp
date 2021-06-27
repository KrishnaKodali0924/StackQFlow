<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Questions</title>
	</head>
	<body>
		<% Question qDetails = (Question)request.getAttribute("qdetails"); %>
		<h3><%= qDetails.getTitle() %></h3>
		<h5><%= qDetails.getQuestion() %></h5>
		
		<form name="votes" method="post" action="votes">
			 <input type="hidden" name="qid" value="<%=qDetails.getQID()%>"/>
			<input type="submit" name="upvote" value=<%=String.valueOf(qDetails.getUpVotes())%> /> 
			<input type="submit" name="downvote" value=<%=String.valueOf(qDetails.getDownVotes())%> />
		</form>
	</body>
</html>