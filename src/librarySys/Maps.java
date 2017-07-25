package librarySys;


public class Maps extends Items {

	public int size;
	
	public Maps(String title, int year, String condition, int loanLength, int size, boolean isAvailable) {
		super(title, year, condition, loanLength, isAvailable);
		this.size=size;
	}
	
	public String toString(){
		return super.toString() + "\nSize: " + size;
		
	}
	

}

