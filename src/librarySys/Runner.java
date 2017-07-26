package librarySys;

public class Runner {

	public static void main(String[] args) {
		int inputUserId =2; int itemId = 0;
		Library mainLib = new Library();
		mainLib.init();
		//mainLib.readInFromFile();
		mainLib.printItemList();
		Person person = mainLib.getPeopleList(inputUserId);
		
		mainLib.listAvailItems();				//List All Items Not checked out-- At this Point, all Items
		mainLib.checkOutItem(itemId, person);	//Check out item X for person Y
		//mainLib.removeItem(2);					// Remove item from the system
		//mainLib.addItem(new Books("Book","Book3", 1929, "Fair", 7, "Author3", true, true)); // This way is dumb and i hate it 
		//mainLib.addBook("Book","Book4", 1798, "Poor", 1, "Author4", false, true); 	//Add a new book to the system
		//mainLib.listAvailItems();						//List all available items again- No number 2, new Item at the end
	//	mainLib.listOutItems();							//List all the items on loan
	//	mainLib.checkInItem(itemId, person);			//Return Item
	//	mainLib.listAvailItems();						//List all available Items again
	//	mainLib.listOutItems();							//List all checked out items
	//	System.out.println(mainLib.registerUser("Adam", "Rate"));		//Add new User to the system
	//	mainLib.updatePerson(inputUserId+1, "Dave", "McDavid");			//Update a Users name
	//	mainLib.removeUser(inputUserId);								//Remove a User
		mainLib.updateItem(0, "Book 12", 1798, "Poor", 1, true); //Update Item
		mainLib.printItemList();		//Print List to console + file 
	}
}
