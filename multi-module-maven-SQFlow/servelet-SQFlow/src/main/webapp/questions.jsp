<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<% Question qDetails = (Question)request.getAttribute("qdetails"); %>
	<head>
		<meta charset="ISO-8859-1">
		<title>Questions</title>
		<link rel="stylesheet" href="./css/qstyle.css">
		<script src="https://kit.fontawesome.com/bf0e6bc6b3.js" crossorigin="anonymous"></script>
	</head>
	<body style="background-color: lightblue">
	<div style="margin-left: 10%; margin-top: 3%" class"jumbotron">
	<h1 class="display-3">StackQFlow</h1>
	</div>
		<h2 class="display-5"><%=qDetails.getTitle()%></h2>
		
		<label for="question"><h5 class="display-5">Question</h5></label><br>
		<textarea id="question" disabled class="form-control" rows="10"><%=qDetails.getQuestion()%></textarea><br><br>
		
		<form name="votes" method="post" action="votes">
			<input type="hidden" name="qid" value="<%=qDetails.getQID()%>"/>
			<i class="fas fa-arrow-up"></i><input type="submit" name="upvote" value=<%=String.valueOf(qDetails.getUpVotes())%> /> 
			<i class="fas fa-arrow-down"></i><input type="submit" name="downvote" value=<%=String.valueOf(qDetails.getDownVotes())%> />
		</form>
		<br><hr>
	</body>
</html>