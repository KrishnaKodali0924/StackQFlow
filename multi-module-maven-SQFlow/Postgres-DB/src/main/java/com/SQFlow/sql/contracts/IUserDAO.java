package com.SQFlow.sql.contracts;

import com.SQFlow.sql.entity.User;

public interface IUserDAO {
	public boolean insert(User user);

	public int getUidFromUserName(String name);

	public int getUidFromEmail(String email);

	public User getUser(int uid);
}
