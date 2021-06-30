<%@page import="com.SQFlow.sql.entity.User"%>
<%@page import="com.SQFlow.sql.dao.UserDAO"%>
<%@page import="org.apache.log4j.config.PropertyGetter"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.SQFLow.nosql.services.QuestionDAO"%>
<%@page import="com.SQFLow.nosql.entity.Question"%>
<%@ page isELIgnored="false"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>StackQFlow</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<h1 style="font-size:42px">StackQFlow</h1>
		<% 	
			String email = (String)request.getSession().getAttribute("email");
		%>
		
		<%if(email != null){%>
			<%
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUserFromEmail(email);
			%>
			<h2 style="font-family:sans-serif">Hello <%=user.getUserName() %></h2><br>
		<%}%>
		
		
		<a href="./login.html">Login</a>
		<a href="./registration.html">Registration</a>
		
		<%if(email != null){%>
			<a href="userprofile.jsp" target="_blank"> User Profile</a>
			<a href="logout">logout</a>
		<%}%>
		
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