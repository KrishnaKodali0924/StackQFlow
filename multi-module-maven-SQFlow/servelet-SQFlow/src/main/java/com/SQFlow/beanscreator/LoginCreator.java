package com.SQFlow.beanscreator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.SQFlow.beans.Login;

public class LoginCreator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginCreator() {

	}

	public static Login createLoginBean(HttpServletRequest request) {
		Login login = new Login();
		login.setEmailId(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		return login;
	}

}