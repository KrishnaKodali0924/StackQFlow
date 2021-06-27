package com.SQFlow.nosql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.SQFLow.nosql.entity.Answer;
import com.SQFLow.nosql.services.AnswerDAO;

public class AnswerDAOTest {
	
	@BeforeClass
	public static void addingData() {
		AnswerDAO testDAO = new AnswerDAO();
		
		testDAO.insertOne(new Answer("A101", "You can use docker", 5, 1, "U101", "Q101", new Date()));
		testDAO.insertOne(new Answer("A102", "try with jenkins", 4, 2, "U102", "Q101", new Date()));
	}
	
	public AnswerDAO ansDAO;
	
	@Before
	public void init() {
		ansDAO = new AnswerDAO();
	}
	
	@Test
	public void testFindById() {
		assertEquals(new Answer("A101", "You can use docker", 5, 1, "U101", "Q101", new Date()), ansDAO.findById("A101"));
	}
	
	@Test
	public void testFindByIdNull() {
		assertNull(ansDAO.findById("A105"));
	}
}
