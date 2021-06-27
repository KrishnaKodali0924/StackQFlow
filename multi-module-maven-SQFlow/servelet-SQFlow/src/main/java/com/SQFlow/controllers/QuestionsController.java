package com.SQFlow.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.QuestionDAO;

@WebServlet("/show-questions")
public class QuestionsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String qID = req.getParameter("qid");

		QuestionDAO questionDAO = new QuestionDAO();
		Question qDetails = questionDAO.findById(qID);

		req.setAttribute("qdetails", qDetails);
		req.getRequestDispatcher("questions.jsp").forward(req, resp);
	}
}
