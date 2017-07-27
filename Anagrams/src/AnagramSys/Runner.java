package AnagramSys;

import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
	input Input = new input();	
	
	//ArrayList<String> wordArray = Input.sortArray(Input.inputFromFile());
	//System.out.println(Input.sortWord("TESTING"));
	Input.Process(Input.sortArray(Input.inputFromFile()));
	
	//Input.Process(wordArray);
	}
}
