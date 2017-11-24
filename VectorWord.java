import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VectorWord {
	String name;
	HashMap<String, Integer> words = new HashMap<String, Integer>();
	public VectorWord(ArrayList<Sentence> s, String word) {		
		String text = "";
		this.name = word;
		try {
			// File file=new File("pg2600.txt");
			
			for(int i=0;i<s.size();i++) {
				Sentence temp = s.get(i);
				for(int j =0; j<temp.size();i++)
				text = temp.get(j);
				if (text != name) {
					if (!this.words.containsKey(text)) {
						this.words.put(text, 1);
					} else {
						this.words.put(text, words.get(text) + 1);
				
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void printWords() {
		for (String key : words.keySet()) {
			Integer count = words.get(key);
			System.out.println("The word " + key + " occurs " + count.intValue());
		}
	}

}
