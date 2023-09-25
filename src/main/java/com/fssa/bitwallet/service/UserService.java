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
	
	
	public static int getIdByEmail(String email) throws InvalidInputException, DaoException {

		if (UserValidator.validateEmail(email)) {

			return UserDAO.getIdByEmail(email);

		}
		 return 0;
	}

	public static boolean deleteUser(User user) throws InvalidInputException, DaoException {

		if (UserValidator.validate(user)) {

			UserDAO.deleteUser(user);

		}
		return true;
	}

	public static User getUserbyEmail(String email) throws InvalidInputException, DaoException {

		User user = null;
		
		if (UserValidator.validateEmail(email)) {

			user = UserDAO.getUserByEmail(email);
			printUser(user);
		}
		return user;
	}
	

	
	public static boolean checkMailAvailable(String email) throws InvalidInputException, DaoException {
		
		if(UserValidator.validateEmail(email)) {
			
			return UserDAO.checkMailAvailable(email);
			
		}
		return true;
	}
	
	public static boolean checkMailAndPassword(String email,String password) throws InvalidInputException, DaoException {
		
		if(UserValidator.validateEmail(email) && UserValidator.validatePassword(password)) {
			
			return UserDAO.checkMailAndPassword(email,password);
		}
		return true;
	}
	
	public static void printUser(User user) {
		
//		Logger.info("UserName :" + user.getUsername());
		Logger.info("Id :" + user.getId());
		Logger.info("Email :"+user.getEmail());
		Logger.info("DOB :"+user.getDOB());
		Logger.info("Password :"+user.getPassword());		
		
	}


}
