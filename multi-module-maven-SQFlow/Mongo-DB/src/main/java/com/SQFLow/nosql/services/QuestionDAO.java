package com.SQFLow.nosql.services;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import com.SQFLow.nosql.contracts.IQuestionDAO;
import com.SQFLow.nosql.entity.Question;
import com.SQFLow.nosql.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;

public class QuestionDAO implements IQuestionDAO {
	private MongoClient mongoClient;
	private MongoCollection collection;

	public QuestionDAO() {
		mongoClient = MongoUtil.mongoUtil();
		collection = MongoUtil.getCollectionFromDB("teamDB", "questions", Question.class);
	}

	@Override
	public void insertOne(Question question) {
		collection.insertOne(question);
	}

	@Override
	public Question findById(String qid) {
		return (Question) collection.find(eq("QID", qid)).first();
	}

	@Override
	public Iterable<Question> findQuestion(String uid) {
		return collection.find(eq("UID", uid)).into(new ArrayList<Question>());
	}

	@Override
	public Iterable<Question> findAll() {
		return collection.find().into(new ArrayList<Question>());
	}

	@Override
	public void addUpVote(String qid) {

		collection.updateMany(eq("QID", qid), Updates.set("upVotes", findById(qid).getUpVotes() + 1))
				.getModifiedCount();
	}

	@Override
	public void addDownVote(String qid) {
		collection.updateMany(eq("QID", qid), Updates.set("downVotes", findById(qid).getDownVotes() + 1))
				.getModifiedCount();
	}

}
