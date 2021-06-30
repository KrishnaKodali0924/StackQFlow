package com.SQFLow.nosql.contracts;

import com.SQFLow.nosql.entity.Answer;

public interface IAnswerDAO {
	
	int insertOne(Answer answer);

	Answer findById(String aid);

	void addUpVote(String aid);

	void addDownVote(String aid);
	
	Iterable<Answer> getAnswers(String qid);
	
	Iterable<Answer> getUserAnswers(String uid);
}
