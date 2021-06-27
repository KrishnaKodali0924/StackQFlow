package com.SQFLow.nosql.contracts;

import com.SQFLow.nosql.entity.Question;

public interface IQuestionDAO {
	void insertOne(Question question);
	
	Question findById(String qid);
	
	Iterable<Question> findAll();
	
	Iterable<Question> findQuestion(String uid);
	
	void addUpVote(String qid);

	void addDownVote(String qid);
}
