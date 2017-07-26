package AnagramSys;

public class Runner {
	public static void main(String[] args) {

	input Input = new input();	
	Input.sortArray(Input.inputFromFile());
	System.out.println(Input.sortWord("TESTING"));
	}
}
