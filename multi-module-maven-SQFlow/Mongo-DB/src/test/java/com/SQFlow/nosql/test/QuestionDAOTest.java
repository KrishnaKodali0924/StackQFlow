package com.SQFlow.nosql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.services.QuestionDAO;

public class QuestionDAOTest {
	
	@BeforeClass
	public static void addingData() {
		QuestionDAO testDAO = new QuestionDAO();
		
		testDAO.insertOne(new Question("Q101", "Can I use Docker?", 5, 1, "open", "U101", new Date(), Arrays.asList("A101")) );
		testDAO.insertOne(new Question("Q102", "What can I do?", 5, 1, "open", "U102", new Date(), Arrays.asList("A102")) );
	}
	
	public QuestionDAO quesDAO;
	
	@Before
	public void init() {
		quesDAO = new QuestionDAO();
	}
	
	@Test
	public void testFindById() {
		assertEquals(new Question("Q101", "Can I use Docker?", 5, 1, "open", "U101", new Date(), Arrays.asList("A101")), quesDAO.findById("Q101"));
	}
	
	@Test
	public void testfindByIdNull() {
		assertNull(quesDAO.findById("Q103"));
	}
	
	@Test
	public void testFindQuestion() {
		assertEquals(Arrays.asList(new Question("Q101", "Can I use Docker?", 5, 1, "open", "U101", new Date(), Arrays.asList("A101")) ), quesDAO.findQuestion("U101"));
	}
	
	@Test
	public void testFindQuestionNull() {
		assertNull(quesDAO.findQuestion("U103"));
	}
	
	@Test
	public void tetsFindAll() {
		assertEquals(Arrays.asList(new Question("Q101", "Can I use Docker?", 5, 1, "open", "U101", new Date(), Arrays.asList("A101")), 
								   new Question("Q102", "What can I do?", 5, 1, "open", "U102", new Date(), Arrays.asList("A102"))), quesDAO.findAll());
	}
	
}
