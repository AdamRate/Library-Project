package AnagramSys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class input {

	public  ArrayList<String> inputFromFile() {
		BufferedReader br = null;
		FileReader fr = null;
		String FILENAME = "Anagrams.txt";
		try {
			fr = new FileReader(FILENAME);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		br = new BufferedReader(fr);
		String sCurrentLine;
		ArrayList<String> wordArray = new ArrayList<>();
		try {
			while ((sCurrentLine = br.readLine()) != null) {
				wordArray.add(sCurrentLine);
			}
			System.out.println(wordArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordArray;
	}

	public  void sortArray(ArrayList<String> wordArray) {

		for (int i = 0; i < wordArray.size(); i++) {
			String test = wordArray.get(i);
			char[] ar = test.toCharArray();
			Arrays.sort(ar);
			String sorted = String.valueOf(ar);
			wordArray.set(i, sorted);
		}
		System.out.println(wordArray);
	}

	public String sortWord(String Input) {
		char[] ar = Input.toCharArray();
		Arrays.sort(ar);
		String sorted = String.valueOf(ar);

		return sorted;
	}
	
	public void Process(String sortedValue){
		int i=0;
		HashMap<String, Integer> map = new HashMap<>();
		map.put(sortedValue, i);
		if (map.get(sortedValue) == null){
	//	int i1 =	map.entrySet("1");
		}
		
	}
}
