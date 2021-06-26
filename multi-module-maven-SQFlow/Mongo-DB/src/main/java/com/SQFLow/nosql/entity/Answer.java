package com.SQFLow.nosql.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
	private String AID;
	private String Answer;
	private int upVotes;
	private int downVotes;
	private String UID;
	private String QID;
	private Date timestamp;

}