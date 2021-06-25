package com.SQFlow.sql.dao;

import javax.persistence.EntityManager;

import com.SQFlow.sql.contracts.IUserDAO;
import com.SQFlow.sql.entity.User;

public class UserDAO implements IUserDAO {

	public boolean addUser(User user, EntityManager entityManager) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User getUserFromId(String uId, EntityManager entityManager) {
		return entityManager.find(User.class, uId);
	}

	public User getUserFromEmail(String email, EntityManager entityManager) {
		String userId = crypt(email);
		return getUserFromId(userId, entityManager);
	}

	public String crypt(String str) {
		String uid = "";
		for (int i = 0; i < str.length(); i++) {
			uid = uid + (char) (128 - str.charAt(i));
		}
		return uid;
	}
}
