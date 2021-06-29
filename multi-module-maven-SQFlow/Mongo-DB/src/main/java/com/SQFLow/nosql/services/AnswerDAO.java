package com.SQFLow.nosql.services;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import com.SQFLow.nosql.contracts.IAnswerDAO;
import com.SQFLow.nosql.entity.Answer;
import com.SQFLow.nosql.util.MongoUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;

public class AnswerDAO implements IAnswerDAO{
	
	private MongoCollection<Answer> aCollection;

	public AnswerDAO() {
		MongoUtil.mongoUtil();
		aCollection = MongoUtil.getCollectionFromDB("teamDB", "answers", Answer.class);
	}
	
	@Override
	public int insertOne(Answer answer) {
		long count = aCollection.count();
		answer.setAnswerID("A"+(count+1));
		try {
			aCollection.insertOne(answer);			
			System.out.println("Inserted");
			return (int)(count+1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (Integer) null;
	}

	@Override
	public Answer findById(String aid) {
		return (Answer) aCollection.find(eq("answerID", aid)).first();
	}

	@Override
	public void addUpVote(String aid) {
		aCollection.updateMany(eq("answerID", aid), Updates.set("upVotes", findById(aid).getUpVotes() + 1))
		.getModifiedCount();
		
	}

	@Override
	public void addDownVote(String aid) {
		 aCollection.updateMany(eq("answerID", aid), Updates.set("downVotes", findById(aid).getDownVotes() + 1))
			.getModifiedCount();
	}
	
	@Override
	public Iterable<Answer> getAnswers(String qid) {
		return aCollection.find(eq("questionID", qid)).into(new ArrayList<Answer>());
	}
	
}
