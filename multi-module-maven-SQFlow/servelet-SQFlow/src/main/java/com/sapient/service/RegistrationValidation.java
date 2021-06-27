package com.sapient.service;

import com.SQFlow.sql.dao.UserDAO;
import com.SQFlow.sql.entity.User;

public class RegistrationValidation {
	private RegistrationValidation() {
	}

	public static boolean isNewUser(User user) {
		UserDAO userController = new UserDAO();
		user.setUserId(userController.crypt(user.getEmail()));
		return userController.addUser(user);
	}
}
