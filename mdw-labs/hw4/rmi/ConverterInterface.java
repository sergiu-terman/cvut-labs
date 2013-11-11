package hw4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConverterInterface extends Remote {
	
	
	/**
	 * @param from, String - currency from wich to be converted
	 * @param to, String - currency to be converted 
	 * @param amount, Double - how much money should be converted
	 * @return String - result of the money converting
	 */
	public String convert(String from, String to, Double amount) throws RemoteException;
}
