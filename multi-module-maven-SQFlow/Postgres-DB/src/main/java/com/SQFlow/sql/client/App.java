package com.SQFlow.sql.client;

import com.SQFlow.sql.dao.UserDAO;
import com.SQFlow.sql.entity.User;

public class App {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setUserName("Krishna");
		user.setEmail("krishna@gmail.com");
		user.setGender("male");
		user.setUserId(userDAO.crypt(user.getEmail()));
		user.setPassword("abcdefghij");
		
//		System.out.println(userDAO.addUser(user) ? "Inserted" : "Not Inserted");
//		System.out.println(userDAO.getUserFromEmail("krishna@gmail.com").getUserId()); 
//		System.out.println(userDAO.crypt("krishna@gmail.com"));
	}

}
