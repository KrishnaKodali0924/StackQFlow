package com.SQFLow.nosql.entity;

import java.util.Date;

public class Answer {
	private String aID;
	private String Answer;
	private int upVotes;
	private int downVotes;
	private String uID;
	private String qID;
	private Date timestamp;
	
	public Answer() {
		
	}
	
	public Answer(String aID, String answer, int upVotes, int downVotes, String uID, String qID, Date timestamp) {
		super();
		this.aID = aID;
		Answer = answer;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
		this.uID = uID;
		this.qID = qID;
		this.timestamp = timestamp;
	}

	public String getaID() {
		return aID;
	}
	public void setaID(String aID) {
		this.aID = aID;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public int getUpVotes() {
		return upVotes;
	}
	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}
	public int getDownVotes() {
		return downVotes;
	}
	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getqID() {
		return qID;
	}
	public void setqID(String qID) {
		this.qID = qID;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "Answer:" + (aID != null ? "aID=" + aID + ", " : "") + (Answer != null ? "Answer=" + Answer + ", " : "")
				+ "upVotes=" + upVotes + ", downVotes=" + downVotes + ", " + (uID != null ? "uID=" + uID + ", " : "")
				+ (qID != null ? "qID=" + qID + ", " : "") + (timestamp != null ? "timestamp=" + timestamp : "");
	}
	
}
