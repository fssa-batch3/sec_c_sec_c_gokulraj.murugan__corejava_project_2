package com.fssa.bitwallet.service;

import java.util.List; 

import com.fssa.bitwallet.dao.TransactionDAO;
import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Transaction;
import com.fssa.bitwallet.validator.TransactionValidator;

public class TransactionService {

	public static boolean addTransaction(Transaction trans) throws InvalidInputException, DaoException {

		if (TransactionValidator.validate(trans)) {

			TransactionDAO.addTransaction(trans);
		}
		return true;
	}

	public static List<Transaction> readTransatByUserId(int id) throws DaoException {

		return TransactionDAO.readTransatByUserId(id);

	}
}
