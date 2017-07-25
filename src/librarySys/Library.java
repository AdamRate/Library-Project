package librarySys;

import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Library {

	ArrayList<Person> peopleList = new ArrayList<>();
	ArrayList<Items> itemList = new ArrayList<>();

	public void checkOutItem(int itemId, Person p1) {
		for (int i = 0; i <= p1.listOfBorrowedItems.size(); i++) {
			if (p1.listOfBorrowedItems.size() < 4 && itemList.get(itemId).getIsAvailable() == true) {
				itemList.get(itemId).isAvailable = false;
				p1.listOfBorrowedItems.add(itemId);
				System.out.println("Person: " + p1.uniqueId + " \tBorrowed Item: " + itemId + "  " + "\tPerson " + p1.uniqueId + "s loaned books: " + p1.listOfBorrowedItems + "\n");
				break;
			} else
				System.out.println("Item is Unavailable");
		}
	}

	public void checkInItem(int itemId, Person p1) {
		for (int i = 0; i < p1.listOfBorrowedItems.size(); i++) {
			if (p1.listOfBorrowedItems.get(i) == itemId) {
				itemList.get(itemId).isAvailable = true;
				p1.listOfBorrowedItems.remove(itemId);
				System.out.println("Person " + p1.uniqueId + " Returned Item: " + itemId);
			} else
				System.out.println("User " + p1.uniqueId + " has not checked out item " + itemId);
			break;
		}
		System.out.println("User " + p1.uniqueId + "s checked out books are: " + p1.listOfBorrowedItems + "\n");
	}

	public String listAvailItems() {
		System.out.println("Items Available are: ");
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).isAvailable == true) {
				System.out.println(itemList.get(i));
			}
		}
		return null;
	}

	public String listOutItems() {
		System.out.println("\nItems on loan are: ");
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).isAvailable == false) {
				System.out.println(itemList.get(i));
			}
		}
		System.out.println("");
		return null;
	}

	public void init() {
		createItemList();
		createPeopleList();
	}

	public String createItemList() {
		{
			itemList.add(new Books("Book 1", 1995, "Good", 7, "Author 1", true, true));
			itemList.add(new Maps("Map 1", 2010, "Excellent", 7, 70, true));
			itemList.add(new Newspapers("Newspaper 1", 2011, "Poor", 1, "Monday", "June 6th", true));
			itemList.add(new Books("Book 2", 1900, "Poor", 7, "Author 2", true, true));
			itemList.add(new Maps("Map 2", 2010, "Excellent", 7, 60, true));
		}
		return "3 Items Added";
	}

	public String createPeopleList() {
		{
			peopleList.add(new Person("Test", "McTest"));
			peopleList.add(new Person("Cheese", "McCheese"));
			peopleList.add(new Person("FirstName2", "Surname2"));
			peopleList.add(new Person("FirstName3", "Surname3"));
		}
		return "Users Created";
	}

	public void addItem(Items Item) {
		itemList.add(Item);
		System.out.println("Item Added" + "\n");
	}

	public void addBook(String title, int year, String condition, int loanlength, String author, boolean isHardback,
			boolean isAvailable) {
		itemList.add(new Books(title, year, condition, loanlength, author, isHardback, isAvailable));
		System.out.println("Book Added- " + title + "\n");
	}

	public void addMap(String title, int year, String condition, int loanLength, int size, boolean isAvailable) {
		itemList.add(new Maps(title, year, condition, loanLength, size, isAvailable));
		System.out.println("Map Added- " + title + "\n");
	}

	public void addNewspaper(String title, int year, String condition, int loanLength, String day, String date,
			boolean isAvailable) {
		itemList.add(new Newspapers(title, year, condition, loanLength, day, date, isAvailable));
		System.out.println("Newspaper Added- " + title + "\n");
	}

	public void removeItem(int itemId) {
		itemList.remove(itemId);
		System.out.println("Item " + itemId + " has been removed.\n");
	}

	public Person getPeopleList(int i) {
		return peopleList.get(i);
	}

	public String registerUser(String Firstname, String Surname) {
		peopleList.add(new Person(Firstname, Surname));
		return "New Person Added: " + Firstname + " " + Surname +"\n";
	}

	public void removeUser(int userId) {
		int i;
		for (i = 0; i < peopleList.size() - 1; i++) {
			if (peopleList.get(i).uniqueId == userId) {
				peopleList.remove(i);
				System.out.println(
						"\nPerson " + i + " Removed: " + peopleList.get(i).firstName + " " + peopleList.get(i).surname + "\n");
			}
		}
	}

	public String updatePerson(int userId, String Name, String Surname) {
		System.out.print("User " + userId + ": " + peopleList.get(userId).firstName + " " + peopleList.get(userId).surname + "   Updated to   " );
		peopleList.get(userId).firstName = Name;
		peopleList.get(userId).surname = Surname;
		System.out.print(peopleList.get(userId).firstName + " " + peopleList.get(userId).surname + "\n");
		return null;
	}

	public void updateItem(int itemId) {
		System.out.println(("Item: " + itemId) + (itemList.get(itemId).title));
	}

	public void printItemList() {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("TEST.txt"));
			for (Items item : itemList) 
				pw.println(item+"\n");
				pw.close();
				System.out.println("File Printed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toString() {

		Person userId = getPeopleList(1);
		return "Items: " + userId.listOfBorrowedItems.get(0) + " ," + userId.listOfBorrowedItems.get(1) + ", "
				+ userId.listOfBorrowedItems.get(3) + " ," + userId.listOfBorrowedItems.get(3);

	}

}
