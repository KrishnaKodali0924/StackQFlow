package com.sapient.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFlow.sql.entity.User;
import com.sapient.beancreater.RegistrationCreator;
import com.sapient.beans.Registration;
import com.sapient.service.RegistrationValidation;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/web-content/html/registration")
@Slf4j
public class RegistrationController extends HttpServlet {
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
			req.getRequestDispatcher("/web-content/html/login.html").forward(req, resp);
		} else {
			resp.getWriter().println("<p style=\"color:red\">*email id already exist</p>");
			user = null;
			req.getRequestDispatcher("/web-content/html/registration.jsp").include(req, resp);
		}
	}
}
