package com.sapient.beancreater;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.sapient.beans.Registration;

/**
 * Servlet implementation class RegistrationCreator
 */
public class RegistrationCreator extends HttpServlet {
	private RegistrationCreator() {

	}

	public static Registration createLoginBean(HttpServletRequest request) {
		Registration reg = new Registration();
		reg.setUserName(request.getParameter("user-name"));
		reg.setEmailId(request.getParameter("email"));
		reg.setPassword(request.getParameter("password"));
		return reg;
	}

}
