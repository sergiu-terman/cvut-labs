package hw1.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
	public static String input = "bank_account: XXXX-XXXX/XXXX\n" + 
						   "owner_name: NAME\n" +
						   "owner_surname: SURNAME\n" +
						   "expiration: JAN/2020";
	
	public static final String ACCOUNT_PREFIX = "accountPrefix";
	public static final String ACCOUNT_SUFFIX = "accountSuffix";
	public static final String NAME = "name";
	public static final String SURNAME = "surname";
	public static final String EXPIRATION = "exp";
	
	public static void main(String args[]) {
		List<Map<String, String>> newList = new ArrayList<Map<String,String>>();
		newList.add(processInput(input));
		System.out.println(getXml(newList));
	}
	
	
	public static Map<String, String> processInput(String input) {
		Map<String, String> result = new HashMap<String, String>();
		
		String[] lines = input.split("\n");
		for (String line : lines) {
			if (line.contains("bank_account")) {
				String[] values = line.split(" |/");
				result.put(ACCOUNT_PREFIX, values[1]);
				result.put(ACCOUNT_SUFFIX, values[2]);
			}
			
			if (line.contains("owner_name"))
				result.put(NAME, line.split(" ")[1]);
			
			if (line.contains("owner_surname"))
				result.put(SURNAME, line.split(" ")[1]);
			
			if (line.contains("expiration"))
				result.put(EXPIRATION, line.split(" ")[1]);
		}
		return result;
	}
	
	public static String getXml(List<Map<String, String>> input) {
		String result = "";
		
		for (Map<String, String> entity : input) {
			result += "<bankAccount>\n";
			
			result += "\t<accountPrefix>" + entity.get(ACCOUNT_PREFIX) + "</accountPrefix>\n";
			result += "\t<accountSuffix>" + entity.get(ACCOUNT_SUFFIX) + "</accountSuffix>\n";
			result += "\t<owner>" + entity.get(NAME) + " " + entity.get(SURNAME) + "</owner>\n";
			result += "\t<exp>" + entity.get(EXPIRATION) + "</exp>\n";
			
			result += "</bankAccount>\n\n";
		}
		
		return result;
	}

}
