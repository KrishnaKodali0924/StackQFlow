package com.SQFlow.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.QuestionDAO;

@WebServlet("/uquestions")
public class UserQuestionsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = (String) req.getSession().getAttribute("email");
		
		
		QuestionDAO questionDAO = new QuestionDAO();
		Iterator<Question> uQuestions = questionDAO.findQuestion(uid).iterator();
		
		List<Question> uQuestionsList = new ArrayList<Question>();
		uQuestions.forEachRemaining(uQuestionsList::add);

		req.setAttribute("uQuestions", uQuestionsList);
		req.getRequestDispatcher("userquestions.jsp").forward(req, resp);
		
	}
}
