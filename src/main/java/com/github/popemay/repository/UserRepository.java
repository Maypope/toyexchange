package com.github.popemay.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.github.popemay.controller.model.ChangePassRequest;
import com.github.popemay.repository.model.User;
import com.mongodb.WriteResult;

import static com.github.popemay.repository.model.User.*;

@Repository
public class UserRepository implements IUserRepository {
	// 这个类用来访问mongoDB
	private static final String USERNAME = "username";

	@Autowired
	private MongoTemplate mongoTemplate;

	public void insert(User user) {
		mongoTemplate.insert(user, USER_COLLECTION);
	}

	public User find(String email) {
		Query query = new Query(Criteria.where(USERNAME).is(email));
		return mongoTemplate.findOne(query, User.class, USER_COLLECTION);

	}

	public void updateInfo(User user) {
		Query query = new Query(Criteria.where(USERNAME).is(user.getUsername()));
		Update update = new Update();
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastName());
		update.set("postCode", user.getPostCode());
		update.set("interests", user.getInterests());
		mongoTemplate.updateFirst(query, update, User.class, USER_COLLECTION);
	}

	public void updatePass(ChangePassRequest user) {
		Query query = new Query(Criteria.where(USERNAME).is(user.getUsername()));
		Update update = new Update();
		update.set("password", user.getNewPass());
		mongoTemplate.updateFirst(query, update, User.class, USER_COLLECTION);
	}

	public int delete(String email) {
		Query query = new Query(Criteria.where(USERNAME).is(email));
		WriteResult result = mongoTemplate.remove(query, User.class, USER_COLLECTION);
		return result.getN();
	}
}
