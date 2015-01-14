package com.github.popemay.service;

import org.hibernate.validator.internal.constraintvalidators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.github.popemay.controller.model.ChangePassRequest;
import com.github.popemay.controller.model.UserRequest;
import com.github.popemay.repository.IUserRepository;
import com.github.popemay.repository.UserRepository;
import com.github.popemay.repository.model.User;

@Service

//写业务逻辑
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private Password password;

	public void save(UserRequest user) {
		user.setPassword(encryptPw(user.getPassword()));
		repository.insert(transform(user));
	}
	
	public String encryptPw(String originPw){
		return password.createPassword(originPw);
	}
	
	public User find(String email){
		return repository.find(email);
	}
	
	public void update(UserRequest user){
		repository.updateInfo(transform(user));
	}

	public void changePass(ChangePassRequest user){
			repository.updatePass(user);
	}
	
	public void validate(UserRequest user, BindingResult result) {
		String email = user.getUsername();
		String password = user.getPassword();
		String passwordRepeat = user.getPasswordRepeat();
		if (email == null || email.trim().length() == 0) {
			result.addError(new FieldError("user", "username", "Please input your email address"));
		} else if (!emailValidator.isValid(email.trim(), null)) {
			result.addError(new FieldError("user", "username", "This is not a valid email address"));
		} else if (repository.find(email) != null) {
			result.addError(new FieldError("user", "username", "The email has been used before"));
		}
		if (password == null || password.length() < 6) {
			result.addError(new FieldError("user", "password", "Passowrd should contain at least 6 characters"));
		} else if (!password.equals(passwordRepeat)) {
			result.addError(new FieldError("user", "password", "Please check that your passwords match and try again."));
		}
	}

	public boolean rightInfo(String username, String password){
		if (repository.find(username) == null || 
			!encryptPw(password).equals(repository.find(username).getPassword())) {
			return false;
		}
		return true;
	}
	
	public User transform(UserRequest user) {
		User transformedUser = new User();
		transformedUser.setFirstName(user.getFirstName());
		transformedUser.setInterests(user.getInterests());
		transformedUser.setLastName(user.getLastName());
		transformedUser.setPassWord(user.getPassword());
		transformedUser.setPostCode(user.getPostCode());
		transformedUser.setUsername(user.getUsername());
		return transformedUser;
	}

}
