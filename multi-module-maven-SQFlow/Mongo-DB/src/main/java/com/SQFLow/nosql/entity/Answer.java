package com.SQFLow.nosql.entity;

import java.util.Date;

public class Answer {
	private String answerID;
	private String answer;
	private String userID;
	private String questionID;
	private Date timeStamp;
	private int upVotes;
	private int downVotes; 
	
	public Answer() { 
	}
	
	public Answer(String answerID, String answer, String userID, String questionID, Date timeStamp, int upVotes,
			int downVotes) {
		super();
		this.answerID = answerID;
		this.answer = answer;
		this.userID = userID;
		this.questionID = questionID;
		this.timeStamp = timeStamp;
		this.upVotes = upVotes;
		this.downVotes = downVotes;
	}
	
	public String getAnswerID() {
		return answerID;
	}

	public void setAnswerID(String answerID) {
		this.answerID = answerID;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
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

	@Override
	public String toString() {
		return "Answer: " + (answerID != null ? "answerID=" + answerID + ", " : "")
				+ (answer != null ? "answer=" + answer + ", " : "") + (userID != null ? "userID=" + userID + ", " : "")
				+ (questionID != null ? "questionID=" + questionID + ", " : "")
				+ (timeStamp != null ? "timeStamp=" + timeStamp + ", " : "") + "upVotes=" + upVotes + ", downVotes="
				+ downVotes;
	}
}
