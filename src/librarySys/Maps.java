package librarySys;


public class Maps extends Items {

	public int size;
	public String type;
	
	public Maps(String type, String title, int year, String condition, int loanLength, int size, boolean isAvailable) {
		super(title, year, condition, loanLength, isAvailable);
		this.size=size;
		this.type= type;
	}
	
	public String toString(){
		return type + "," +super.toString() + "," + size;
		
	}
	

}

