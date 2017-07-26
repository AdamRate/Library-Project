package librarySys;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Library {

	ArrayList<Person> peopleList = new ArrayList<>();
	ArrayList<Items> itemList = new ArrayList<>();

	public void checkOutItem(int itemId, Person p1) {
		for (int i = 0; i <= p1.listOfBorrowedItems.size(); i++) {
			if (p1.listOfBorrowedItems.size() < 4 && itemList.get(itemId).getIsAvailable() == true) {
				itemList.get(itemId).isAvailable = false;
				p1.listOfBorrowedItems.add(itemId);
				System.out.println("Person: " + p1.uniqueId + " \tBorrowed Item: " + itemId + "  " + "\tPerson "
						+ p1.uniqueId + "s loaned books: " + p1.listOfBorrowedItems + "\n");
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
			itemList.add(new Books("Book", "Book1", 1995, "Good", 7, "Author1", true, true));
			itemList.add(new Maps("Map", "Map1", 2010, "Excellent", 7, 70, true));
			itemList.add(new Newspapers("Newspaper", "Newspaper1", 2011, "Poor", 1, "Monday", "June6th", true));
			itemList.add(new Books("Book", "Book2", 1900, "Poor", 7, "Author2", true, true));
			itemList.add(new Maps("Map", "Map2", 2010, "Excellent", 7, 60, true));
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

	public void addBook(String type, String title, int year, String condition, int loanlength, String author,
			boolean isHardback, boolean isAvailable) {
		itemList.add(new Books(type, title, year, condition, loanlength, author, isHardback, isAvailable));
		System.out.println("Book Added- " + title + "\n");
	}

	public void addMap(String type, String title, int year, String condition, int loanLength, int size,
			boolean isAvailable) {
		itemList.add(new Maps(type, title, year, condition, loanLength, size, isAvailable));
		System.out.println("Map Added- " + title + "\n");
	}

	public void addNewspaper(String type, String title, int year, String condition, int loanLength, String day,
			String date, boolean isAvailable) {
		itemList.add(new Newspapers(type, title, year, condition, loanLength, day, date, isAvailable));
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
		return "New Person Added: " + Firstname + " " + Surname + "\n";
	}

	public void removeUser(int userId) {
		int i;
		for (i = 0; i < peopleList.size() - 1; i++) {
			if (peopleList.get(i).uniqueId == userId) {
				peopleList.remove(i);
				System.out.println("\nPerson " + i + " Removed: " + peopleList.get(i).firstName + " "
						+ peopleList.get(i).surname + "\n");
			}
		}
	}

	public String updatePerson(int userId, String Name, String Surname) {
		System.out.print("User " + userId + ": " + peopleList.get(userId).firstName + " "
				+ peopleList.get(userId).surname + "   Updated to   ");
		peopleList.get(userId).firstName = Name;
		peopleList.get(userId).surname = Surname;
		System.out.print(peopleList.get(userId).firstName + " " + peopleList.get(userId).surname + "\n");
		return null;
	}

	public void updateItem(int itemId, String title, int year, String condition, int loanLength, boolean isAvailable) {
		System.out.print(("Item: " + itemId) + " " + (itemList.get(itemId).title) + " Updated to: ");
		itemList.get(itemId).title = title;
		itemList.get(itemId).year = year;
		itemList.get(itemId).condition = condition;
		itemList.get(itemId).loanLength = loanLength;
		itemList.get(itemId).isAvailable = isAvailable;
		System.out.print(
				itemList.get(itemId).title + " " + itemList.get(itemId).year + " " + itemList.get(itemId).condition
						+ " " + itemList.get(itemId).loanLength + " " + itemList.get(itemId).isAvailable + "\n");
	}

	public void printItemList() {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("TEST.txt"));
			for (Items item : itemList)
				pw.println(item);
			pw.close();
			System.out.println("File Printed");
			System.out.println(itemList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readInFromFile() {
		final String FILENAME = "TEST.txt";

		BufferedReader br = null;
		FileReader fr = null;
		String[] out = null;
		String[] out2 = null;
		String holder = "";
		String title = "";
		String author = "";
		boolean isHardback = false;
		boolean isAvailable = false;
		String type = "";
		String condition = "";
		int year = -1;
		int size = -1;
		int itemNo = -1;
		int loanLength = -1;
		String day;
		String date;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			String allData = "";
			while ((sCurrentLine = br.readLine()) != null) {
				allData = allData + "\n" + sCurrentLine;
			}
			out = allData.split("\n");
			for (int i = 1; i < out.length; i++) {
				out2 = out[i].split(",");
				for (int j = 0; j < out2.length; j++) {

					if (out2[j].equals("Book") || out2[j].equals("Newspaper") || out2[j].equals("Map")) {

						System.out.println("Processing Item");
						// Type
						type = allData.split("\n")[i];
						type = type.split(",")[0];
						// ItemNumber
						holder = allData.split("\n")[i];
						holder = holder.split(",")[1];
						itemNo = Integer.parseInt(holder);
						// Title
						title = allData.split("\n")[i];
						title = title.split(",")[2];
						// Year
						holder = allData.split("\n")[i];
						holder = holder.split(",")[3];
						year = Integer.parseInt(holder);
						// Condition
						holder = allData.split("\n")[i];
						condition = holder.split(",")[4];
						// Loan Length
						holder = allData.split("\n")[i];
						holder = holder.split(",")[5];
						loanLength = Integer.parseInt(holder);
						// Availability
						holder = allData.split("\n")[i];
						holder = holder.split(",")[6];
						isAvailable = (holder != null);
					}

					if (out2[j].equals("Book")) {
						System.out.println("Process Book");

						// Author
						holder = allData.split("\n")[i];
						holder = holder.split(",")[7];
						author = holder;
						// isHardback
						holder = allData.split("\n")[i];
						holder = holder.split(",")[8];
						isHardback = (holder != null);

						itemList.add(
								new Books(type, title, year, condition, loanLength, author, isHardback, isAvailable));
					}

					if (out2[j].equals("Map")) {
						System.out.println("Process Map");
						holder = allData.split("\n")[i];
						holder = holder.split(",")[7];
						size = Integer.parseInt(holder);

						itemList.add(new Maps(type, title, year, condition, loanLength, size, isAvailable));
					}

					if (out2[j].equals("Newspaper")) {
						System.out.println("Process Newspaper");
						holder = allData.split("\n")[i];
						date = holder.split(",")[7];

						holder = allData.split("\n")[i];
						day = holder.split(",")[8];

						itemList.add(new Newspapers(type, title, year, condition, loanLength, date, day, isAvailable));
					}
					break;

				}
				System.out.println(itemList);
			}

		} catch (

		IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String toString() {

		Person userId = getPeopleList(1);
		return "Items: " + userId.listOfBorrowedItems.get(0) + " ," + userId.listOfBorrowedItems.get(1) + ", "
				+ userId.listOfBorrowedItems.get(3) + " ," + userId.listOfBorrowedItems.get(3);
	}

}
