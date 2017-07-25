package librarySys;

public class Newspapers extends Items {

	public String day;
	public String date;
	public String type;
	
	public Newspapers(String type, String title, int year, String condition, int loanLength, String day, String date, boolean isAvailable) {
		super(title, year, condition, loanLength, isAvailable);
		this.day=day;
		this.date=date;
		this.type= type;
	}

	public String toString(){
		return "Type: " + type + "\t" +super.toString() + "\tDate: " + date + "\tDay: " + day; 
		}
	
}

