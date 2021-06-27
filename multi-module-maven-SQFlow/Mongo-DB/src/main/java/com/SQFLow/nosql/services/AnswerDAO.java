package com.SQFLow.nosql.services;

import static com.mongodb.client.model.Filters.eq;

import com.SQFLow.nosql.contracts.IAnswerDAO;
import com.SQFLow.nosql.entity.Answer;
import com.SQFLow.nosql.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;

public class AnswerDAO implements IAnswerDAO {

	private MongoClient mongoClient;
	private MongoCollection collection;
	
	public AnswerDAO() {
		mongoClient = MongoUtil.mongoUtilCodedRegistray();
		collection = MongoUtil.getCollectionFromDB("bitanDB", "answers", Answer.class);
	}
	
	@Override
	public void insertOne(Answer answer) {
		collection.insertOne(answer);
	}
	
	@Override
	public Answer findById(String aid) {
		return (Answer) collection.find(eq("AID", aid)).first();
	}

	@Override
	public void addUpVote(String aid) {

		collection.updateMany(eq("AID", aid), Updates.set("upVotes", findById(aid).getUpVotes() + 1))
				.getModifiedCount();
	}

	@Override
	public void addDownVote(String aid) {
		collection.updateMany(eq("AID", aid), Updates.set("downVotes", findById(aid).getDownVotes() + 1))
				.getModifiedCount();
	}

}
