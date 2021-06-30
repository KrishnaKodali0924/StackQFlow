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

import com.SQFLow.nosql.entity.Answer;
import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.AnswerDAO;
import com.SQFLow.nosql.services.QuestionDAO;

@WebServlet("/uanswers")
public class UserAsnwersController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = (String) req.getSession().getAttribute("email");
		
		AnswerDAO answerDAO = new AnswerDAO();
		Iterator<Answer> uAnswers = answerDAO.getUserAnswers(uid).iterator();
		
		List<Answer> uAnswersList = new ArrayList<Answer>();
		uAnswers.forEachRemaining(uAnswersList::add);

		req.setAttribute("uAnswers", uAnswersList);
		req.getRequestDispatcher("useranswers.jsp").forward(req, resp);

	}

}
