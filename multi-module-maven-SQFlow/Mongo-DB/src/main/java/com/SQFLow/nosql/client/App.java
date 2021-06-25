package com.SQFLow.nosql.client;

import java.util.ArrayList;
import java.util.Date;

import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.QuestionDAO;

public class App {

	public static void main(String[] args) {
		QuestionDAO qcontroller = new QuestionDAO();
		Question question = new Question();
		question.setQID("Q001");
		question.setQuestion("Is this a question?");
		question.setAIDList(new ArrayList<String>());
		question.setDownVotes(5);
		question.setUpVotes(10);
		question.setStatus("open");
		question.setTimestamp(new Date());
		question.setUID("bwjfnooibn");
		qcontroller.insertOne(question);
	}

}
