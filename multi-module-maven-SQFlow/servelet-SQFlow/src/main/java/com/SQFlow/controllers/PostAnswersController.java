package com.SQFlow.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFLow.nosql.entity.Answer;
import com.SQFLow.nosql.services.AnswerDAO;
import com.SQFLow.nosql.services.QuestionDAO;

@WebServlet("/post-answer")
public class PostAnswersController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = (String) req.getSession().getAttribute("email");
		
		if(email == null) {
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login to post a question');");
			out.println("location='login.html';");
			out.println("</script>");	
		}
		
		else {
			String qid = req.getParameter("qid");
			String answer = req.getParameter("answer");
			
			Date date = new Date();
			Answer aDetails = new Answer(null, answer, email, qid, date, 0, 0);
			
			AnswerDAO answerDAO = new AnswerDAO();
			QuestionDAO questionDAO = new QuestionDAO();
			
			int ansCount = answerDAO.insertOne(aDetails);
			questionDAO.addAnswer(qid, "A" + ansCount);
			
			req.setAttribute("qdetails", questionDAO.findById(qid));
			req.getRequestDispatcher("questions.jsp").forward(req, resp);
		}	
	}
}