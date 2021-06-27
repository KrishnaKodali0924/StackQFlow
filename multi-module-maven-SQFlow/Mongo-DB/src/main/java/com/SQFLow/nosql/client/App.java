package com.SQFLow.nosql.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.QuestionDAO;
import com.SQFLow.nosql.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

public class App {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		list.add("A001");
//		list.add("A001");

//		Question question = new Question("Q110", "Sample Question-1", "Hello this is Jan", 1, 2, "open", "U003", null, list);
		Question question = new Question();
		
		QuestionDAO questionDAO= new QuestionDAO();
		
//		questionDAO.addDownVote("Q1");
//		
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
		
				
	}
}
