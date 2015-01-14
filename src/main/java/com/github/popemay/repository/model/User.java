package com.github.popemay.repository.model;
import java.util.List;

public class User {
	public static final String USER_COLLECTION = "users";

	private String username;
	private String password;
	private String postCode;
	private String firstName;
	private String lastName;
	private List<String> interests;
	private boolean regularNote;
	private String frequency;
	private boolean interestNote;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public boolean isRegularNote() {
		return regularNote;
	}

	public void setRegularNote(boolean regularNote) {
		this.regularNote = regularNote;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public boolean isInterestNote() {
		return interestNote;
	}

	public void setInterestNote(boolean interestNote) {
		this.interestNote = interestNote;
	}

}
