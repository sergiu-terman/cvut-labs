package hw1.task2;

import java.math.BigDecimal;

public class MoneyOperationsObject implements MoneyOperations {

	@Override
	public boolean sub(Account from, BigDecimal amount) {
		BigDecimal value = from.getBalance().subtract(amount);
		
		if (amount == null ||
			amount.compareTo(BigDecimal.ZERO) < 0 ||
			from.getBalance().compareTo(BigDecimal.ZERO) < 0 ||
			from.getBalance() == null ||
			value.compareTo(BigDecimal.ZERO) < 0)
			return false;
		
		from.setBalance(value);
		return true;
	}

	@Override
	public boolean add(Account to, BigDecimal amount) {
		if (amount == null ||
			amount.compareTo(BigDecimal.ZERO) < 0 ||
			to.getBalance() == null ||
			to.getBalance().compareTo(BigDecimal.ZERO) < 0)
			return false;
		
		to.setBalance(to.getBalance().add(amount));
		return true;
	}
	
}
