package com.SQFlow.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFlow.beancreater.LoginCreator;
import com.SQFlow.beans.Login;
import com.SQFlow.service.LoginValidation;
import com.SQFlow.sql.entity.User;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/login")
@Slf4j
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		String uid = "";
		String contextPath = req.getContextPath();// We need this path to set cookie's path.
		Cookie[] cookies = req.getCookies();
		Cookie cookieToProcess = null;
		for (Cookie cookie : cookies) {
			// Search cookie you need.
			if (cookie.getName().equals("email")) {
				cookieToProcess = cookie;
				break;
			}
		}
		Login login = LoginCreator.createLoginBean(req);
		user.setEmail(login.getEmailId());
		user.setPassword(login.getPassword());
		resp.setContentType("text/html");
		boolean loginValid = LoginValidation.isUserValid(user);
		if (cookieToProcess != null && !cookieToProcess.getValue().equals("")) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			if (loginValid) {
				// No such cookie.
				// Possibly user enters your site for the first time or they disabled cookies.
				// In this case we create a new cookie.
				String cookieName = "email";
				String cookieValue = user.getEmail();
				Cookie newCookie = new Cookie(cookieName, cookieValue);
				newCookie.setPath(contextPath);
				resp.addCookie(newCookie);
				req.getRequestDispatcher("index.jsp");
			} else {
				resp.getWriter().println("<p style=\"color:red\">*Login Credentials are incorrect</p>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}

	}
}