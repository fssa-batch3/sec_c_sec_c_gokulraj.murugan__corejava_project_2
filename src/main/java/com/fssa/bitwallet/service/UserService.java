package com.fssa.bitwallet.service;

import com.fssa.bitwallet.dao.UserDAO;
import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.User;
import com.fssa.bitwallet.util.Logger;
import com.fssa.bitwallet.validator.UserValidator;

public class UserService {
 
	public static boolean addUser(User user) throws InvalidInputException, DaoException {

		if (UserValidator.validate(user)) {

			UserDAO.addUser(user);

		} 
		return true;
	}

	public static boolean updateUser(User user) throws InvalidInputException, DaoException {

		if (UserValidator.validate(user)) {

			UserDAO.updateUser(user);

		}
		return true;
	}

	public static boolean deleteUser(User user) throws InvalidInputException, DaoException {

		if (UserValidator.validate(user)) {

			UserDAO.deleteUser(user);

		}
		return true;
	}

	public static boolean getUserbyId(int id) throws InvalidInputException, DaoException {

		if (UserValidator.validateId(id)) {

			User user  = UserDAO.getUserById(id);
			printUser(user);
		}
		return true;
	}
	
	public static void printUser(User user) {
		
		Logger.info("UserName :" + user.getUsername());
		Logger.info("Id :" + user.getId());
		Logger.info("Email :"+user.getEmail());
		Logger.info("DOB :"+user.getDOB());
		Logger.info("Password :"+user.getPassword());		
		
	}


}
