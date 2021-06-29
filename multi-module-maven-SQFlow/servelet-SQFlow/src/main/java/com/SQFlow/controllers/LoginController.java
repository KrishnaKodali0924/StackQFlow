package com.SQFlow.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SQFlow.beans.Login;
import com.SQFlow.beanscreator.LoginCreator;
import com.SQFlow.service.LoginValidation;
import com.SQFlow.sql.entity.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		HttpSession session = req.getSession(); 
		
		String uid = "";
		Login login = LoginCreator.createLoginBean(req);
		user.setEmail(login.getEmailId());
		user.setPassword(login.getPassword());
		resp.setContentType("text/html");
		boolean loginValid = LoginValidation.isUserValid(user);
		
		if (session.getAttribute("name") != null) {
			resp.getWriter().println("<p style=\"color:red\">*Already logged in</p>");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else {
			if (loginValid) {
				session.setAttribute("email", user.getEmail());
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			} else {
				resp.getWriter().println("<p style=\"color:red\">*Login Credentials are incorrect</p>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
	
	}
}
