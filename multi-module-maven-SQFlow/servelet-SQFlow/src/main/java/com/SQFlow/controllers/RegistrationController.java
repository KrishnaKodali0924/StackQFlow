package com.SQFlow.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SQFlow.beans.Registration;
import com.SQFlow.beanscreator.RegistrationCreator;
import com.SQFlow.service.RegistrationValidation;
import com.SQFlow.sql.entity.User;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		Registration reg = RegistrationCreator.createRegistrationBean(req);
		user.setEmail(reg.getEmailId());
		user.setUserName(reg.getUserName());
		user.setGender(reg.getGender());
		user.setPassword(reg.getPassword());
		resp.setContentType("text/html");
		if (RegistrationValidation.isNewUser(user)) {
			req.getSession().setAttribute("email", reg.getEmailId()); 
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			resp.getWriter().println("<p style=\"color:red\">*email id already exist</p>");
			user = null;
			req.getRequestDispatcher("registration.html").include(req, resp);
		}
	}
	
}
