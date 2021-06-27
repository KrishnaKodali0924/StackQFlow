package com.SQFlow.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.QuestionDAO;

@WebServlet("/testdb")
public class TestDBConnection extends HttpServlet {	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String qID = req.getParameter("qID");
//		String question = req.getParameter("question");
//		
//		Question questionObj = new Question();
//		questionObj.setQID(qID);
//		questionObj.setQuestion(question);
//		
//		QuestionDAO questionDAO = new QuestionDAO();
//		questionDAO.insertOne(questionObj);
		
		String value = req.getParameter("qid");
		resp.getWriter().println("<h1>" + value + "</h1> <br>");
	}

}
