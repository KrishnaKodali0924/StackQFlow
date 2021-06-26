package com.SQFlow.sql.client;

import com.SQFlow.sql.dao.UserDAO;
import com.SQFlow.sql.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	public static void main(String[] args) {
		UserDAO controller = new UserDAO();
		User user = new User();
		user.setUserName("Bidisha");
		user.setEmail("bidu@gmail.com");
		user.setGender("female");
		user.setUserId(controller.crypt(user.getEmail()));
		user.setPassword("123xx2abc");
		log.info("{}", controller.addUser(user) ? "Record inserted" : "Not inserted");
		// EntityManager entityManager = JPAUtil.getEntityManager();
		// User user = controller.getUserFromEmail("bitan@gmail.com", entityManager);
		// log.info("{}", user);
	}

}
