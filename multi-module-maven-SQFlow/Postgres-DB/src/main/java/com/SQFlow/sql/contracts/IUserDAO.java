package com.SQFlow.sql.contracts;

import javax.persistence.EntityManager;

import com.SQFlow.sql.entity.User;

public interface IUserDAO {
	public boolean addUser(User user, EntityManager entityManager);

	public User getUserFromId(String uId, EntityManager entityManager);

	public User getUserFromEmail(String email, EntityManager entityManager);
}
