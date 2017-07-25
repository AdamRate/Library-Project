package librarySys;

public class Books extends Items {

	public String author;
	public boolean isHardback;
	public String type;

	public Books(String type, String title, int year, String condition, int loanLength, String author,
			boolean isHardback, boolean isAvailable) {
		super(title, year, condition, loanLength, isAvailable);

		this.author = author;
		this.isHardback = isHardback;
		this.type = type;

	}

	public String toString() {
		return "Type: " + type + "\t" +super.toString() + "\tAuthor: " + author + "\tIs a Hardback: " + isHardback;

	}

}
