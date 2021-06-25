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
		mongoClient = MongoUtil.mongoUtilCodedRegistray();
		collection = MongoUtil.getCollectionFromDB("team4DB", "questions", Question.class);
	}

	@Override
	public void insertOne(Question question) {
		collection.insertOne(question);
	}

	@Override
	public Question findQuestionByQId(int qid) {
		return (Question) collection.find(eq("Qid", qid)).first();
	}

	@Override
	public Iterable<Question> findQuestionByUId(int uid) {
		return collection.find(eq("userId", uid)).into(new ArrayList<Question>());
	}

	@Override
	public Iterable<Question> findAll() {
		return collection.find().into(new ArrayList<Question>());
	}

	@Override
	public void addUpVote(int qid) {
		collection.updateOne(eq("Qid", qid), Updates.set("upVotes", findQuestionByQId(qid).getUpVote() + 1));
	}

	@Override
	public void addDownVote(int qid) {
		collection.updateOne(eq("Qid", qid), Updates.set("upVotes", findQuestionByQId(qid).getDownVote() + 1));

	}

}
