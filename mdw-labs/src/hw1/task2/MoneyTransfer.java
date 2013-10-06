package hw1.task2;

import java.math.BigDecimal;

public interface MoneyTransfer {
	public boolean transferMoney(Account from, Account to, BigDecimal amount);
}
