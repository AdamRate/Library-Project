package librarySys;

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

	

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getLoanLength() {
		return loanLength;
	}

	public void setLoanLength(int loanLength) {
		this.loanLength = loanLength;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String toString() {
		return "Item Number:" + itemNumber + "\tTitle:" + title + "\tYear:" + year + "\tCondition:" + condition
				+ "\tLoan Length:" + loanLength + "\tAvailable:" + isAvailable;
	}

	public boolean getIsAvailable() {
		
		return isAvailable;
	}

}
