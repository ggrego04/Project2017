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
			Scanner sc = new Scanner(s);
			while (sc.hasNext()) {
				text = sc.next();
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
		printWords(this.words);
	}

	public void printWords(HashMap<String, Integer> h) {
		for (String key : h.keySet()) {
			Integer count = h.get(key);
			System.out.println("The word " + key + " occurs " + count.intValue());
		}
	}

}
