package com.github.popemay.repository;

import static com.github.popemay.repository.model.User.USER_COLLECTION;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.github.popemay.controller.model.ChangePassRequest;
import com.github.popemay.repository.model.User;
import com.mongodb.WriteResult;

public interface IUserRepository {
	public void insert(User user);

	public User find(String email);
	
	public void updateInfo(User user);
	
	public void updatePass(ChangePassRequest user);

	public int delete(String email);
}