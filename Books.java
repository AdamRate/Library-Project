package librarySys;

public class Books extends Items {

	public String author;
	public boolean isHardback;

	public Books(String title, int year, String condition, int loanLength, String author, boolean isHardback,
			boolean isAvailable) {
		super(title, year, condition, loanLength, isAvailable);

		this.author = author;
		this.isHardback = isHardback;

	}
	
	public String toString() {
		return super.toString() + "\tAuthor: " + author + "\tIs a Hardback? " + isHardback;

	}

}
