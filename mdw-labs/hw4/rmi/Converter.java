package hw4;

import java.io.File;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Converter extends UnicastRemoteObject implements ConverterInterface {
	
	public static final String EUR = "EUR";
	public static final String USD = "USD";
	public static final String GBP = "GBP";
	
	
	public HashMap<String, HashMap<String, Double>> currencyTable = new HashMap<String, HashMap<String, Double>>();
	
	protected Converter() throws RemoteException {
		super();
		currencyTable.put(EUR, new HashMap<String, Double>(){{put(USD, 1.3355); put(GBP, 0.834635335);}});
		currencyTable.put(USD, new HashMap<String, Double>(){{put(EUR, 0.748783227); put(GBP, 0.62496094);}});
		currencyTable.put(GBP, new HashMap<String, Double>(){{put(EUR, 1.19812804); put(USD, 1.6001);}});
	}

	private static final long serialVersionUID = 3626152639354152755L;

	//@Override
	public String convert(String from, String to, Double amount) {
		return String.valueOf(currencyTable.get(from).get(to) * amount);
	}
	
	public static void main(String args[]) {
		try {
			if	(System.getSecurityManager()	==	null)	{
				System.out.println(new File(".").getAbsolutePath());
				RMISecurityManager sm = new RMISecurityManager();
				System.setSecurityManager(sm);
				
				LocateRegistry.createRegistry(1099);
				Converter obj = new Converter();
				Naming.rebind("//0.0.0.0/HelloRMI",	obj);
				
				System.out.println("RMI server started, listening to incoming requests...");
			}

		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getLocalizedMessage());
		}
	}
	
}
