package com.SQFLow.nosql.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.SQFLow.nosql.entity.Answer;
import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.AnswerDAO;
import com.SQFLow.nosql.services.QuestionDAO;
import com.SQFLow.nosql.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

public class App {

	public static void main(String[] args) {
		
//		QuestionDAO questionDAO= new QuestionDAO();
//		AnswerDAO answerDAO = new AnswerDAO();

		/*
		 * Questions
		 */
//		Question question = new Question(null, "Sample Question-1", "This is just a sample Question", 0, 0, "agan@gmail.com", null, null);
//		Question question = new Question();
		
		
		
//		questionDAO.insertOne(question);
		
//		System.out.println(questionDAO.findById("Q5"));
		
//		Iterator<Question> iterator = questionDAO.findAll().iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}

//		Iterator<Question> iterator = questionDAO.findQuestion("U003").iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
//		questionDAO.addDownVote("Q6");
		
//		questionDAO.addAnswer("Q1", "A1");
		
//		System.out.println(questionDAO.findById("Q2"));
		
		/*
		 * Answers
		 */
//		Answer answer = new Answer();
//		Answer answer = new Answer(null, "Sample Answer", "krishna@gmail.com", null, new Date(), 0, 0);
//		
//		System.out.println(answerDAO.insertOne(answer));
		
//		System.out.println(answerDAO.findById("A1"));
		
//		answerDAO.addUpVote("A1");
//		
//		answerDAO.addDownVote("A1");
		
//		Iterable<Answer> answers = answerDAO.getAnswers("Q2");
//		System.out.println(answers);
	}
}
