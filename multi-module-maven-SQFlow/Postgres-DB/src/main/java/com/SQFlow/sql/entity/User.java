package com.SQFlow.sql.entity;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userName;
	private String email;
	private String password;
	private String gender;
}
