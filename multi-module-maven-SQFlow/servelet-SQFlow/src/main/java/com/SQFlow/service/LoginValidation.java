package com.SQFlow.service;

import com.SQFlow.sql.dao.UserDAO;
import com.SQFlow.sql.entity.User;

public class LoginValidation {
	private LoginValidation() {
	}

	public static boolean isUserValid(User user) {
		UserDAO userController = new UserDAO();
		User trueUser = userController.getUserFromEmail(user.getEmail());
		if (trueUser == null)
			return false;
		if (!trueUser.getPassword().equals(user.getPassword()))
			return false;
		user.setUserName(trueUser.getUserName());
		user.setUserId(trueUser.getUserId());
		user.setGender(trueUser.getGender());
		return true;	
	}
}