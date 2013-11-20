package com.web.service;

import java.util.HashMap;

public class Accounts {
	private static HashMap<String, Double> accounts = new HashMap<String, Double>(){{
		put("4534-3423-6343-4563", 345234.4);
		put("4533-7123-8635-2445", 543.3);
		put("3234-1234-1234-8645", 4352443235.32);
		put("7435-3444-5242-3443", 34234324.1);
		put("1324-4234-4334-5344", 434.134);
		put("4234-5344-7777-7777", 123255.34);
		put("3454-5343-4524-6435", 34234.5);
		put("1111-1111-1111-1111", 5234.123);
	}};
	
	public static HashMap<String, Double> getAccount() {
		return accounts;
	}
	
	/**
	 * Check if the account exists in database
	 * @param account, that should be checkeds
	 * @return boolean, true if account exists, false if it doesn't
	 */
	public static boolean checkAccount(String account) {
		if (accounts.get(account) == null)
			return false;
		return true;
	}
	
	/**
	 * Get the balance value of an account
	 * @param account, from which balance value is issued
	 * @return Double, the balance value
	 * @throws Exception
	 */
	public static Double getBalance(String account) throws Exception {
		if (!checkAccount(account))
			throw new Exception("No such account in database");
		return accounts.get(account);
	}
	
	/**
	 * Perform a transaction between to bank accounts
	 * @param from, account from which money is taken
	 * @param to, account to which money is transfered
	 * @param amount, ammount of money implied in transaction
	 * @return boolean, true if everything is okay, false if there is an error in transaction
	 */
	public static boolean transfer(String from, String to, Double amount) {
		try {
			if (decreaseBalance(from, amount) && increaseBalance(to, amount))
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Increases the balance of account
	 * @param account, to which to transfer the money
	 * @param amount, money that should be transfered
	 * @return boolean, true if everything is okay, false if there is an error in transaction
	 */
	public static boolean increaseBalance(String account, Double amount) {
		try {
			accounts.put(account, accounts.get(account) + Math.abs(amount));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Decreases the balance of account
	 * @param account, from which money should be taken
	 * @param amount, money that should be taken
	 * @return boolean, true if everything is okay, false if there is an error in transaction
	 */
	public static boolean decreaseBalance(String account, Double amount) {
		try {
			Double userAmount = getBalance(account);
			if (userAmount < amount)
				return false;
			accounts.put(account, userAmount - Math.abs(amount));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
