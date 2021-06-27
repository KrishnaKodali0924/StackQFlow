package com.SQFlow.sql.dao;

import java.sql.SQLException;

import com.SQFlow.sql.contracts.IUserDAO;
import com.SQFlow.sql.entity.User;
import com.SQFlow.sql.util.GetConnection;

public class UserDAO implements IUserDAO{
	GetConnection gc;

	public UserDAO() {
		gc = new GetConnection();
	}
	
	public String crypt(String str) {
		String uid = "";
		for (int i = 0; i < str.length(); i++) {
			uid = uid + (char) (128 - str.charAt(i));
		}
		return uid;
	}
	
	@Override
	public boolean addUser(User user) {
		String sql = "insert into users values (?,?,?,?,?)";
		try {
			gc.ps = GetConnection.getPostGresConnection().prepareStatement(sql);
			gc.ps.setString(1, user.getUserId());
			gc.ps.setString(2, user.getUserName());
			gc.ps.setString(3, user.getEmail());
			gc.ps.setString(4, user.getPassword());
			gc.ps.setString(5, user.getGender());
			return gc.ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public User getUserFromId(String uId) {
		String sql = "select username, email, password, gender from users where uid=?";
		try {
			gc.ps = GetConnection.getPostGresConnection().prepareStatement(sql);
			gc.ps.setString(1, uId);

			gc.rs = gc.ps.executeQuery();
			if (gc.rs.next()) {
				User user = new User();
				user.setUserId(uId);
				user.setUserName(gc.rs.getString(1));
				user.setEmail(gc.rs.getString(2));
				user.setPassword(gc.rs.getString(3));
				user.setGender(gc.rs.getString(4));
				return user;
			} else {
				System.out.println("Record not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				gc.ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public User getUserFromEmail(String email) {
		String userId = crypt(email);
		return getUserFromId(userId);
	}
}
