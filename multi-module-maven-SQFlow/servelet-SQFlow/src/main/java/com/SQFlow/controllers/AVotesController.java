package com.SQFlow.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFLow.nosql.services.AnswerDAO;
import com.SQFLow.nosql.services.QuestionDAO;

@WebServlet("/a-votes")
public class AVotesController extends HttpServlet {

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
			out.println("alert('Login to vote');");
			out.println("location='login.html';");
			out.println("</script>");	
		}
		
		else {
			String aid = req.getParameter("aid");
			String qid = req.getParameter("qid");
			
			AnswerDAO answerDAO = new AnswerDAO();
			QuestionDAO questionDAO = new QuestionDAO();
			
			if(req.getParameter("upvote") != null)
				answerDAO.addUpVote(aid);
			else if(req.getParameter("downvote") != null)
				answerDAO.addDownVote(aid);
			req.setAttribute("qdetails", questionDAO.findById(qid));
			req.getRequestDispatcher("questions.jsp").forward(req, resp);
		}
	}
}
