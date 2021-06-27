package com.SQFlow.beancreater;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.SQFlow.beans.Login;

/**
 * Servlet implementation class RegistrationCreator
 */
public class LoginCreator extends HttpServlet {
	private LoginCreator() {

	}

	public static Login createLoginBean(HttpServletRequest request) {
		Login login = new Login();
		login.setEmailId(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		return login;
	}

}
