import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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
	public void sorting() {
		Object[] a = words.entrySet().toArray();
		Arrays.sort(a, new Comparator() {
		    public int compare(Object o1, Object o2) {
		        return ((Map.Entry<String, Integer>) o2).getValue()
		                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
		    }
		});
		for (Object e : a) {
		    System.out.println(((Map.Entry<String, Integer>) e).getKey() + " : "
		            + ((Map.Entry<String, Integer>) e).getValue());
		}
	}

}
