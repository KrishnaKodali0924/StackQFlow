package com.SQFlow.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.QuestionDAO;

@WebServlet("/post-question")
public class PostQuestionsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String question = req.getParameter("question");
		
		String uid = "U003";
		Date date = new Date();
		
		Question qDetails = new Question(null, title, question, 0, 0, "open", uid, date, null);
		
		QuestionDAO questionDAO = new QuestionDAO();
		questionDAO.insertOne(qDetails);
		
		req.getRequestDispatcher("uquestions").forward(req, resp);
	}

}
