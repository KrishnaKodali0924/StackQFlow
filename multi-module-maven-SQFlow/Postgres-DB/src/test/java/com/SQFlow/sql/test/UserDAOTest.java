package com.SQFlow.sql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.SQFlow.sql.dao.UserDAO;
import com.SQFlow.sql.entity.User;

public class UserDAOTest {
	
	@BeforeClass
	public static void addingData() {
		UserDAO testDAO = new UserDAO();

		testDAO.addUser(new User("U101", "Aneesha", "a@gmail.com", "12345", "female"));
		testDAO.addUser(new User("U102", "Sailaja", "s@gmail.com", "1234", "female"));
		testDAO.addUser(new User("U103", "Bitan", "b@gmail.com", "123", "male"));
		testDAO.addUser(new User("U104", "Krishna", "k@gmail.com", "4567", "male"));
	}
	
	public UserDAO userDAO;
	
	@Before
	public void init() {
		userDAO = new UserDAO();
	}
	
	@Test
	public void testGetUserFromId(String userid) {
		assertEquals(new User("U101", "Aneesha", "a@gmail.com", "12345", "female"), userDAO.getUserFromId("U101"));
	}
	
	@Test
	public void testGetUserFromIdNull() {
		assertNull(userDAO.getUserFromId("U105"));
	}
}
