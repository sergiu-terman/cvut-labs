package com.weblogic.tutorial.logic;

import java.util.ArrayList;
import java.util.List;

public class ContactDB {
	
	public static List<Contact> contacts = new ArrayList<Contact>();
	static {
		contacts.add(new Contact("Sergiu Terman", "terman.sergiu@gmail.com"));
		contacts.add(new Contact("Ana Balica", "ana.balica@gmail.com"));
		contacts.add(new Contact("Eugeniu Ungureanu", "e.ungureanu92@gmail.com"));
		contacts.add(new Contact("Mihai Iachimovschi", "mihai.iachimovschi@gmail.com"));
	}
	
	public ContactDB() {
		
	}
	
	public static void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public static void deleteContact(String key) {
		System.out.println("Contact deleted");
		for (Contact cont : contacts) {
			if (cont.getMail().equals(key)) {
				contacts.remove(cont);
				break;
			}
		}
	}
}
