package com.SQFlow.sql.contracts;

import com.SQFlow.sql.entity.User;

public interface IUserDAO {
	public boolean addUser(User user);

	public User getUserFromId(String uId);

	public User getUserFromEmail(String email);
}
