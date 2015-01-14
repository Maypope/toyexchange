package com.github.popemay.service;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.github.popemay.controller.model.ChangePassRequest;
import com.github.popemay.controller.model.UserRequest;
import com.github.popemay.repository.model.User;

public interface IUserService {
	public void save(UserRequest user);
	
	public String encryptPw(String originPw);
	
	public User find(String email);
	
	public void update(UserRequest user);

	public void changePass(ChangePassRequest user);
	
	public void validate(UserRequest user, BindingResult result);

	public boolean rightInfo(String username, String password);
	
	public User transform(UserRequest user);
}
