package com.SQFlow.beanscreator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.SQFlow.beans.Registration;

public class RegistrationCreator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RegistrationCreator() {
	}

	public static Registration createRegistrationBean(HttpServletRequest request) {
		Registration reg = new Registration();
		reg.setUserName(request.getParameter("user-name"));
		reg.setEmailId(request.getParameter("email"));
		reg.setPassword(request.getParameter("password"));
		reg.setGender(request.getParameter("gender"));
		return reg;
	}

}