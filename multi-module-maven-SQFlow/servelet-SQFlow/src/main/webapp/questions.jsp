<%@page import="java.util.Iterator"%>
<%@page import="com.SQFLow.nosql.entity.Answer"%>
<%@page import="com.SQFLow.nosql.services.AnswerDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Questions</title>
		<link rel="stylesheet" href="style.css">
	</head>
	
	<%Question qDetails = (Question)request.getAttribute("qdetails");%>
	<body>
		
		<h2><%=qDetails.getTitle()%></h2>
		
		<label for="question">Question</label><br>
		<textarea id="question" disabled rows="10" cols="200"><%=qDetails.getQuestion()%></textarea>
		
		<form name="qvotes" method="post" action="votes">
			<input type="hidden" name="qid" value="<%=qDetails.getQID()%>"/> 
			<input type="submit" name="upvote" value=<%=String.valueOf(qDetails.getUpVotes())%> /> 
			<input type="submit" name="downvote" value=<%=String.valueOf(qDetails.getDownVotes())%> />
		</form>
		<br><hr>
		<%
			out.println("<a class='answer' href='postanswers.jsp?qid=" + qDetails.getQID() + " 'target='_blank'> Answer </a>");
		%>
		<br>
		<%
			AnswerDAO answerDAO = new AnswerDAO();
			Iterator<Answer> answersToQ = answerDAO.getAnswers(qDetails.getQID()).iterator();
			while(answersToQ.hasNext()){
				Answer answer = answersToQ.next();
		%>
		<textarea id="question" disabled rows=10 cols=150><%=answer.getAnswer()%></textarea>
		
		<form name="avotes" method="post" action="a-votes">
			<input type="hidden" name="qid" value="<%=qDetails.getQID()%>"/> 
			<input type="hidden" name="aid" value="<%=answer.getAnswerID()%>"/>
			<input type="submit" name="upvote" value="<%=String.valueOf(answer.getUpVotes())%>"/> 
			<input type="submit" name="downvote" value="<%=String.valueOf(answer.getDownVotes())%>"/> 
		</form> 
		<% }%>
	</body>
</html>