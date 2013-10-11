package hw1.task2;

import java.math.BigDecimal;

public class MoneyTransferObject implements MoneyTransfer {

	@Override
	public boolean transferMoney(Account from, Account to, BigDecimal amount) {
		if (from.getBalance() == null ||
			to.getBalance() == null ||
			from.getBalance().compareTo(BigDecimal.ZERO) < 0 ||
			to.getBalance().compareTo(BigDecimal.ZERO) < 0 ||
			from.getBalance().subtract(to.getBalance()).compareTo(BigDecimal.ZERO) < 0 ||
			amount == null ||
			amount.compareTo(BigDecimal.ZERO) < 0)
			return false;
		
		from.setBalance(from.getBalance().subtract(amount));
		to.setBalance(to.getBalance().add(amount));
		return true;
	}
}
