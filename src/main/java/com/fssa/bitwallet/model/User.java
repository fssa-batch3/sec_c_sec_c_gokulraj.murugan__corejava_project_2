package com.fssa.bitwallet.model;

import java.time.LocalDate;

public class User {

	private int id;
	private String username;
	private String email;
	private String password;
	private UserRole role;
	private LocalDate dateOfBirth;

	public User(String username, String email, String password, UserRole role, LocalDate dOB) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		dateOfBirth = dOB;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public LocalDate getDOB() {
		return dateOfBirth;
	}

	public void setDOB(LocalDate dOB) {
		dateOfBirth = dOB;
	}

}
