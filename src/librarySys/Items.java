package librarySys;


import java.util.ArrayList;

public class Items {

	private static int totalItems = -1;
	public int itemNumber;
	public String title;
	public int year;
	public String condition;
	public int loanLength;
	public boolean isAvailable;

	public Items(String title, int year, String condition, int loanLength, boolean isAvailable) {
		totalItems++;
		itemNumber = totalItems;
		this.itemNumber = itemNumber;
		this.title = title;
		this.year = year;
		this.condition = condition;
		this.loanLength = loanLength;
		this.isAvailable = isAvailable;
	}

	public Items() {
	}

	public Items getItemId(Library lib) {
		Library mainLib = new Library();
		return mainLib.itemList.get(itemNumber);
	}

	public void addItem() {

	}

	public void removeItem() {

	}

	public void updateItem() {

	}

	public String toString() {
		return "Item Number: " + itemNumber + "\tTitle: " + title + "\tYear: " + year + "\tCondition: " + condition
				+ "\tLoan Length: " + loanLength + "\tAvailable: " + isAvailable;
	}

	public boolean getIsAvailable() {
		
		return isAvailable;
	}

}
