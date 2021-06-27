package com.SQFLow.nosql.services;

import static com.mongodb.client.model.Filters.eq;

import com.SQFLow.nosql.contracts.IAnswerDAO;
import com.SQFLow.nosql.entity.Answer;
import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;

public class AnswerDAO implements IAnswerDAO{
	
	private MongoClient mongoClient;
	private MongoCollection<Answer> aCollection;

	public AnswerDAO() {
		mongoClient = MongoUtil.mongoUtil();
		aCollection = MongoUtil.getCollectionFromDB("teamDB", "answers", Answer.class);
	}
	
	@Override
	public void insertOne(Answer answer) {
		 aCollection.insertOne(answer);
	}

	@Override
	public Answer findById(String aid) {
		return (Answer) aCollection.find(eq("aID", aid)).first();
	}

	@Override
	public void addUpVote(String aid) {
		aCollection.updateMany(eq("aID", aid), Updates.set("upVotes", findById(aid).getUpVotes() + 1))
		.getModifiedCount();
	}

	@Override
	public void addDownVote(String aid) {
		 aCollection.updateMany(eq("aID", aid), Updates.set("downVotes", findById(aid).getDownVotes() + 1))
		.getModifiedCount();
		
	}
	
}
