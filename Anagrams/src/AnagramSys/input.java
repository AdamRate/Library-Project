package AnagramSys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class input {

	public ArrayList<String> inputFromFile() {

		BufferedReader br = null;
		FileReader fr = null;
		String FILENAME = "wordList.txt";
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
			// System.out.println(wordArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordArray;
	}

	public ArrayList<String> sortArray(ArrayList<String> wordArray) {

		for (int i = 0; i < wordArray.size(); i++) {
			String test = wordArray.get(i);
			char[] ar = test.toCharArray();
			Arrays.sort(ar);
			String sorted = String.valueOf(ar);
			wordArray.set(i, sorted);
		}
		return wordArray;
	}

	public String sortWord(String Input) {
		char[] ar = Input.toCharArray();
		Arrays.sort(ar);
		String sorted = String.valueOf(ar);
		return sorted;
	}

	public void Process(ArrayList<String> sortedValue) {
		int j = 0;
		int v = 0;
		int Biggest = 0;
		String BiggestEntry = "";

		Entry<String, Integer> entry = null;
		HashMap<String, Integer> map = new HashMap<>();
		for (j = 0; j < sortedValue.size(); j++)
			if (map.containsKey(sortedValue.get(j))) {
				v = map.get(sortedValue.get(j));
				v++;
				map.put(sortedValue.get(j), v);
			} else
				map.put(sortedValue.get(j), 0);

		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			entry = it.next();

			if (entry.getValue() > Biggest) {
				Biggest = entry.getValue();
				BiggestEntry = entry.getKey();
			}
		}
		// System.out.println(map.size());
		System.out.println("Most anagrams is: " + BiggestEntry + " With : " + Biggest + " Instances");
	}

}
