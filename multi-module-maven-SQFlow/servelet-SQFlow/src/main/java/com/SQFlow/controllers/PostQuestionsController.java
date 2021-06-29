package com.SQFlow.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
		String uid = (String) req.getSession().getAttribute("email");
		
		resp.setContentType("text/html;charset=UTF-8");
		if(uid == null) {
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login to post a question');");
			out.println("location='login.html';");
			out.println("</script>");	
		}
		else {
			String title = req.getParameter("title");
			String question = req.getParameter("question");
			
			Date date = new Date();
			
			Question qDetails = new Question(null, title, question, 0, 0, uid, null, date);
			
			QuestionDAO questionDAO = new QuestionDAO();
			questionDAO.insertOne(qDetails);
			
			req.getRequestDispatcher("uquestions").forward(req, resp);
		}
	}

}
