package com.SQFLow.nosql.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Question {
	private String qId;
	private String question;
	private int upVote;
	private int downVote;
	private Date timeStamp;
	private String uId;
}
