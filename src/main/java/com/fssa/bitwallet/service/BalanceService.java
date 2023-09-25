package com.fssa.bitwallet.service;

import java.util.List;

import com.fssa.bitwallet.dao.BalanceDAO;
import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Balance;
import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.validator.BalanceValidator;

public class BalanceService {

	public static boolean addBalance(Balance balance) throws InvalidInputException, DaoException {

		if (BalanceValidator.validate(balance)
				&& BalanceDAO.checkBalance(balance.getUserId(), balance.getCurrency().getId())) {

			return BalanceDAO.updateBalance(balance.getBalance(), balance.getCurrency().getId());

		} else if (BalanceValidator.validate(balance)) {
			return BalanceDAO.addBalance(balance);
		}
		return true;
	}

	public static List<Balance> readBalanceById(int id) throws InvalidInputException, DaoException {

		return BalanceDAO.readBalanceByUserId(id);
	}
}
