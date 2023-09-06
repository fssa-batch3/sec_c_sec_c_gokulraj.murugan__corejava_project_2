package com.fssa.bitwallet.validator;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.errors.UserValidatorError;
import com.fssa.bitwallet.model.User;
import com.fssa.bitwallet.model.UserRole;

public class TestUserValidator {

	public static User getValidUser() {

		User user = new User("Gokulraj", "gokul@gmail.com", "Luffy@123", UserRole.ADMIN, LocalDate.of(2005, 04, 06));

		return user;
	}

	public static User getInvalidUser() {

		User user = new User("Go*#&*aj", "gokulgmail", "dfuffy123", null, LocalDate.of(2025, 04, 06));

		return user;
	}

	@Test
	void testValidateName() {

		try {
			Assertions.assertTrue(UserValidator.validateName(getValidUser().getUsername()));
		} catch (IllegalArgumentException | InvalidInputException e) {

			e.printStackTrace();
		}
	}

	@Test
	void testNullValidateName() {
		try {
			UserValidator.validateName(null);
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_USERNAME_NULL, e.getMessage());
		}
	}

	@Test
	void testInvalidName() {
		try {
			UserValidator.validateName(getInvalidUser().getUsername());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_USERNAME_PATTERN, e.getMessage());
		}
	}

	@Test
	void testValidateEmail() {

		try {
			Assertions.assertTrue(UserValidator.validateEmail(getValidUser().getEmail()));
		} catch (IllegalArgumentException | InvalidInputException e) {

			e.printStackTrace();
		}
	}

	@Test
	void testNullValidateEmail() {
		try {
			UserValidator.validateEmail(null);
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_USEREMAIL_NULL, e.getMessage());
		}
	}

	@Test
	void testInvalidEmail() {
		try {
			UserValidator.validateEmail(getInvalidUser().getEmail());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_USEREMAIL_PATTERN, e.getMessage());
		}
	}

	@Test
	void testValidatePassword() {

		try {
			Assertions.assertTrue(UserValidator.validatePassword(getValidUser().getPassword()));
		} catch (IllegalArgumentException | InvalidInputException e) {

			e.printStackTrace();
		}
	}

	@Test
	void testNullValidatePassword() {
		try {
			UserValidator.validatePassword(null);
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_PASSWORD_NULL, e.getMessage());
		}
	}

	@Test
	void testInvalidPassword() {
		try {
			UserValidator.validatePassword(getInvalidUser().getPassword());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_PASSWORD_PATTERN, e.getMessage());
		}
	}

	@Test
	void testValidateUserRole() {

		try {
			Assertions.assertTrue(UserValidator.validateUserRole(getValidUser().getRole()));
		} catch (IllegalArgumentException | InvalidInputException e) {

			e.printStackTrace();
		}
	}

	@Test
	void testNullValidateUserRole() {
		try {
			UserValidator.validateUserRole(null);
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_USERROLE_NULL, e.getMessage());
		}
	}

	@Test
	void testValidateDOB() throws Exception {
		Assertions.assertTrue(UserValidator.validateDOB(getValidUser().getDOB()));

	}

	@Test
	void testNullValidateDate() {
		try {
			UserValidator.validateDOB(null);
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_DATE_NULL, e.getMessage());
		}
	}

	@Test
	void testInValidateDate() {
		try {
			UserValidator.validateDOB(getInvalidUser().getDOB());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(UserValidatorError.INVALID_DATE_FORMAT, e.getMessage());
		}
	}

}