package hw1.task2;

import java.math.BigDecimal;

public class Main {
	
	public static Account user1 = new Account();
	public static Account user2 = new Account();

	public static void main(String args[]) {
		user1.setBalance(new BigDecimal(13000));
		user1.setAccountId(1234567L);
		user2.setBalance(new BigDecimal(500));
		user2.setAccountId(7654321L);
		
		
		MoneyOperationsObject moneyOperations = new MoneyOperationsObject();
		MoneyTransferObject moneyTransfer = new MoneyTransferObject();
		
		moneyOperations.sub(user1, new BigDecimal(1000));
		System.out.println(user1);
		moneyOperations.add(user2, new BigDecimal(1000));
		System.out.println(user2);
		
		moneyTransfer.transferMoney(user1, user2, new BigDecimal(500));
		System.out.println(user1);
		System.out.println(user2);
	}
}
