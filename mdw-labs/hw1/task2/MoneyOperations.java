package hw1.task2;

import java.math.BigDecimal;

public interface MoneyOperations {
	
	public boolean sub(Account from, BigDecimal amount);
	
	public boolean add(Account to, BigDecimal amount);
}
