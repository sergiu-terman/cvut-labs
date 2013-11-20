package com.web.service;

import javax.jws.WebService;

import org.python.modules.newmodule;

@WebService
public class AccountService {
	
	public Boolean check(String account) {
		return Accounts.checkAccount(account);
	}
	
	public String balance(String account) {
		try {
			return String.valueOf(Accounts.getBalance(account));
		} catch (Exception e) {
			return("No such account in database");
		}
	}
	
	public String changeBalance(String account, String amount, String operator) {
		if (!Accounts.checkAccount(account))
			return "No such account in database";
		
		try {
			Double realAmount = Double.parseDouble(amount);
			switch (operator) {
			case "+":
				if (!Accounts.increaseBalance(account, realAmount))
					throw new Exception();
				break;
			case "-":
				if (!Accounts.decreaseBalance(account, realAmount))
					return "Not enough funds for executing the transfer";
				break;
			default:
				return "Wrong operator";
			}
			
		} catch (NumberFormatException e) {
			return "Amount is in wrong format";
		}
		  catch (Exception e) {
			return "An error occurred";
		}
		return "Transaction executed with success";
	}
	
	public Boolean transfer(String from, String to, String amount) {
		try {
			return Accounts.transfer(from, to, Double.parseDouble(amount));
		} catch (Exception e) {
			return false;
		}
	}
}
