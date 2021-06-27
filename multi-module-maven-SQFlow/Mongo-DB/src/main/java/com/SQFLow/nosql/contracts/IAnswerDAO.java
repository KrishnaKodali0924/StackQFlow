package com.SQFLow.nosql.contracts;

import com.SQFLow.nosql.entity.Answer;

public interface IAnswerDAO {

	void insertOne(Answer answer);

	Answer findById(String aid);

	void addUpVote(String aid);

	void addDownVote(String aid);
}
