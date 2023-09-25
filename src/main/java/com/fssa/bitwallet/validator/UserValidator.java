package com.fssa.bitwallet.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.errors.UserValidatorError;
import com.fssa.bitwallet.model.User;

public class UserValidator {

	public static boolean validate(User user) throws InvalidInputException {

		if (user == null) {
			throw new InvalidInputException(UserValidatorError.INVALID_USER_NULL);
		}

		validateName(user.getUsername());
	validateEmail(user.getEmail());
		validatePassword(user.getPassword());

		validateDOB(user.getDOB());

		return true;
	}

	public static boolean validateId(int id) throws InvalidInputException {

		if (id <= 0) {
			throw new InvalidInputException(UserValidatorError.INVALID_ID);
		}
		return true;
	}

	public static boolean validateName(String name) throws InvalidInputException {

		if (name == null || name.trim().equals("")) {
			throw new InvalidInputException(UserValidatorError.INVALID_USERNAME_NULL);
		}

		String regex = "^[a-zA-Z]{3,20}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new InvalidInputException(UserValidatorError.INVALID_USERNAME_PATTERN);
		}

		return true;
	}

	public static boolean validateEmail(String email) throws InvalidInputException {

		if (email == null || email.trim().equals("")) {
			throw new InvalidInputException(UserValidatorError.INVALID_USEREMAIL_NULL);
		}

		String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new InvalidInputException(UserValidatorError.INVALID_USEREMAIL_PATTERN);
		}

		return true;
	}
	public static boolean validatePassword(String password) throws InvalidInputException {

		if (password == null || password.isEmpty()) {
			throw new InvalidInputException(UserValidatorError.INVALID_PASSWORD_NULL);
		}

		String regex = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(password);

		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new InvalidInputException(UserValidatorError.INVALID_PASSWORD_PATTERN);
		}
		return true;
	}

	public static boolean validateDOB(LocalDate dateOfBirth) throws InvalidInputException {

		LocalDate today = LocalDate.now();

		if (dateOfBirth == null) {
			throw new InvalidInputException(UserValidatorError.INVALID_DATE_NULL);
		} else if (dateOfBirth.isAfter(today)) {
			throw new InvalidInputException(UserValidatorError.INVALID_DATE_FORMAT);
		}
		return true;
	}
}
