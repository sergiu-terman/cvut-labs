package hw1.task2;

import java.math.BigDecimal;

public class Account {
	private Long accountId;
	private BigDecimal balance = new BigDecimal(0);
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		if (accountId == null || balance == null)
			return "Trololo";
		
		return "User id : " + Long.toString(accountId) + "; Balance : " + balance.toString();
	}
}
