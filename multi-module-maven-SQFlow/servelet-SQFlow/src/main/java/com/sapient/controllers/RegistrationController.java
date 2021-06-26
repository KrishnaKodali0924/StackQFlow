package com.sapient.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SQFlow.sql.dao.UserDAO;
import com.SQFlow.sql.entity.User;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/web-content/html/registration")
@Slf4j
public class RegistrationController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		UserDAO userController = new UserDAO();
		User user = new User();
		String userName = req.getParameter("user-name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String uid = userController.crypt(email);
		user.setEmail(email);
		user.setUserId(uid);
		user.setUserName(userName);
		user.setGender(gender);
		user.setPassword(password);
		log.info("{}", user);
		userController.addUser(user);
	}
}
