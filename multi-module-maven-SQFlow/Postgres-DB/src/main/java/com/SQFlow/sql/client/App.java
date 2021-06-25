package com.SQFlow.sql.client;

import javax.persistence.EntityManager;

import com.SQFlow.sql.dao.UserDAO;
import com.SQFlow.sql.entity.User;
import com.SQFlow.sql.util.JPAUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	public static void main(String[] args) {
		UserDAO controller = new UserDAO();
//		User user = new User();
//		user.setUserName("Bitan");
//		user.setEmail("bitan@gmail.com");
//		user.setGender("male");
//		user.setUserId(controller.crypt(user.getEmail()));
//		user.setPassword("12345abc");
		EntityManager entityManager = JPAUtil.getEntityManager();
		User user = controller.getUserFromEmail("bitan@gmail.com", entityManager);
		log.info("{}", user);
	}

}
