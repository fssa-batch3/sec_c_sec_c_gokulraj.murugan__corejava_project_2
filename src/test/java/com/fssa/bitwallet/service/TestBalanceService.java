package com.fssa.bitwallet.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Balance;

public class TestBalanceService {
   
	public static Balance getValidBalance() {
		
		Balance balance = new Balance(2,3,3);
		
		return balance;
	}
	
	
	@Test
	void testAddBalance() {

		Balance curr = getValidBalance();

		try {
			Assertions.assertTrue(BalanceService.addBalance(curr));

		} catch ( InvalidInputException | DaoException e) {
			e.printStackTrace();
		}
	}

}
