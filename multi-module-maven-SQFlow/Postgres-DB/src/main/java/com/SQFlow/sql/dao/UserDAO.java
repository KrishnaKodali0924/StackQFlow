package com.SQFlow.sql.dao;

import com.SQFlow.sql.contracts.IUserDAO;
import com.SQFlow.sql.entity.User;

public class UserDAO implements IUserDAO {

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUidFromUserName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUidFromEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
