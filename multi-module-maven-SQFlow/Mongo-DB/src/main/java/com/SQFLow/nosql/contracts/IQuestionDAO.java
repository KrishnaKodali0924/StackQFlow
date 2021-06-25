package com.SQFLow.nosql.contracts;

import com.SQFLow.nosql.entity.Question;

public interface IQuestionDAO {
	public void insertOne(Question question);

	public Question findQuestionByQId(int qid);

	public Iterable<Question> findQuestionByUId(int uid);

	public Iterable<Question> findAll();

	public void addUpVote(int qid);

	public void addDownVote(int qid);

}
