package com.fssa.bitwallet.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.User;

public class TestUserService {

	User validUser = new User("gokul", "gokul@gmail.com", "Luffy@123",LocalDate.of(2005, 04, 05));
	User updateUser = new User("gokulraj", "gokul@gmail.com", "Luffy@123", LocalDate.of(2005, 04, 06));
	User deleteUser = new User("gokul", "gokul@gmail.com", "Luffy@123", LocalDate.of(2005, 04, 05));

	@Test
	void testAddUser() {

		try {
			Assertions.assertTrue(UserService.addUser(validUser));
		} catch (InvalidInputException | DaoException e) {

			e.printStackTrace();
		}

	}

	@Test
	void testUpdateUser() {

		try {
			Assertions.assertTrue(UserService.updateUser(updateUser));
		} catch (InvalidInputException | DaoException e) {

			e.printStackTrace();
		}

	}

	@Test
	void testDeleteUser() {

		try {
			Assertions.assertTrue(UserService.deleteUser(deleteUser));
		} catch (InvalidInputException | DaoException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetUserById() {

		try {
			Assertions.assertEquals(UserService.getUserbyEmail(validUser.getEmail()).getUsername(),validUser.getUsername());
		} catch (InvalidInputException | DaoException e) {
			e.printStackTrace();
		}
	}
}
