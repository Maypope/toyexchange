package com.github.popemay.repository;

import org.springframework.stereotype.Repository;

import com.github.popemay.controller.model.ChangePassRequest;
import com.github.popemay.repository.model.User;

@Repository
public class MySqlUserRepository implements IUserRepository {
	//访问mysql
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User find(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInfo(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePass(ChangePassRequest user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
