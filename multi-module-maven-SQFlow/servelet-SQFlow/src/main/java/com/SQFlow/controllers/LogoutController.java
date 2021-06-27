package com.SQFlow.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/home")
@Slf4j
public class LogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();// We need this path to set cookie's path.
		Cookie[] cookies = req.getCookies();
		Cookie cookieToProcess = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("email")) {
				cookieToProcess = cookie;
				break;
			}
		}
		cookieToProcess.setValue("");
		req.getRequestDispatcher("index.jsp").include(req, resp);
		;

	}
}