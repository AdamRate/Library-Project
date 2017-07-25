package librarySys;

import java.util.ArrayList;

public class Person {

	private static int totalPeople;
	public int uniqueId;
	public String firstName;
	public String surname;
	public ArrayList<Integer> listOfBorrowedItems = new ArrayList<>(); 

	public Person(String firstName, String surname) {
		totalPeople++;
		this.uniqueId = totalPeople;
		this.firstName = firstName;
		this.surname = surname;
		
	}

	public int returnItem() {
		return 0;
	}

	public String hasBorrowed() { // List of borrowed items
		return null;
	}

	public String toString() {
		return "Items:" + listOfBorrowedItems.get(1);

	}

}
