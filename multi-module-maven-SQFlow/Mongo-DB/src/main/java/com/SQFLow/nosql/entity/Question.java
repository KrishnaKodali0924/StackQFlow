package com.SQFLow.nosql.entity;

import java.util.Date;
import java.util.List;

public class Question {
	private String QID;
	private String title;
	private String question;
	private int upVotes;
	private int downVotes;
	private String UID;
	private Date timestamp;
	
	public Question() {
	}
	
	public Question(String qID, String title, String question, int upVotes, int downVotes, String status, String uID,
			Date timestamp) {
		super();
		QID = qID;
		this.title = title;
		this.question = question;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
		UID = uID;
		this.timestamp = timestamp;
//		AIDList = aIDList;
	}


	public String getQID() {
		return QID;
	}

	public void setQID(String qID) {
		QID = qID;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
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

	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Question: " + (QID != null ? "QID=" + QID + ", " : "")
				+ (title != null ? "qTitle=" + title + ", " : "")
				+ (question != null ? "question=" + question + ", " : "") + "upVotes=" + upVotes + ", downVotes="
				+ downVotes + ", " 
				+ (UID != null ? "UID=" + UID + ", " : "") + (timestamp != null ? "timestamp=" + timestamp + ", " : "");
	}
}
