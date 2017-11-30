import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class TOEFLSolver {
	public static ArrayList<ArrayList<String>> getSentenceLists(String text) {
		ArrayList<ArrayList<String>> t = new ArrayList();
		String[] tokenised = text.split("\\.+");
		for (int i = 0; i < tokenised.length; i++) {
			t.add((new Sentence(tokenised[i])).getList());
		}
		return t;
	}

	public static ArrayList<ArrayList<String>> get_sentence_lists_from_files(ArrayList<String> filenames) {
		File[] f = new File[filenames.size()];
		Scanner scan[] = new Scanner[filenames.size()];
		for (int i = 0; i < filenames.size(); i++) {
			f[i] = new File(filenames.get(i));
			try {
				scan[i] = new Scanner(f[i]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayList<ArrayList<String>> SentenceList = new ArrayList();
		// ArrayList<ArrayList<String>> SentenceList2=new ArrayList();

		String t[] = new String[filenames.size()];
		t[0] = scan[0].nextLine();
		for (int i = 0; i < filenames.size(); i++) {
			while (scan[i].hasNextLine()) {
				t[i] = t[i] + " " + scan[i].nextLine();
			}
		}
		String allFiles = t[0];
		for (int i = 1; i < t.length; i++) {
			allFiles = allFiles + "." + t[i];
		}
		return SentenceList = getSentenceLists(allFiles);
		// String textF3= textF1+textF2;

	}

	public static HashMap<String, HashMap<String, Integer>> build_semantic_descriptors(ArrayList<ArrayList<String>> t) {
		HashMap<String, HashMap<String, Integer>> words = new HashMap();
		String text;

		for (int i = 0; i < t.size(); i++) {
			for (int j = 0; j < t.get(i).size(); j++) {

				if (!words.containsKey(t.get(i).get(j))) {
					words.put(t.get(i).get(j), VectorWord(t.get(i).get(j), t));
				}

			}
		}
		return words;
	}

	public static HashMap<String, Integer> VectorWord(String word, ArrayList<ArrayList<String>> s) {
		HashMap<String, Integer> vector = new HashMap();
		boolean flag = false;
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < s.get(i).size(); j++) {
				if (s.get(i).get(j).equals(word)) {
					flag = true;
				}

			}

			if (flag) {
				for (int j = 0; j < s.get(i).size(); j++) {
					if (!s.get(i).get(j).equals(word)) {
						if (!vector.containsKey(s.get(i).get(j))) {
							vector.put(s.get(i).get(j), 1);

						} else {
							vector.put(s.get(i).get(j), vector.get(s.get(i).get(j)) + 1);
						}
					}
				}
			}
			flag = false;
		}
		// sorting(vector);
		return vector;

	}

	/*
	 * public static void sorting(HashMap<String, Integer> words) { Object[] a =
	 * words.entrySet().toArray(); Arrays.sort(a, new Comparator() { public int
	 * compare(Object o1, Object o2) { return ((Map.Entry<String, Integer>)
	 * o2).getValue() .compareTo(((Map.Entry<String, Integer>) o1).getValue()); }
	 * }); for (Object e : a) { System.out.print(((Map.Entry<String, Integer>)
	 * e).getKey() + " : " + ((Map.Entry<String, Integer>) e).getValue()+" "); } }
	 */
	public static String most_similar_word(String word, ArrayList<String> choices,
			HashMap<String, HashMap<String, Integer>> semantic_descriptors) {
		HashMap<String, Integer> h = new HashMap();
		h = semantic_descriptors.get(word);

		double[] similarity = new double[choices.size()];

		for (int i = 0; i < choices.size(); i++) {

			similarity[i] = cosine_similarity(h, semantic_descriptors.get(choices.get(i)));

		}
		int position = 0;
		for (int i = 0; i < similarity.length; i++) {
			if (similarity[position] < similarity[i]) {
				position = i;
			}
		}
		//System.out.println(similarity[position]);
		return choices.get(position);

	}

	public static double norm(HashMap<String, Integer> vec) {
		double sum_of_squares = 0.0;

		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i) != null) {
				sum_of_squares += (double) (vec.get(i) * vec.get(i));
			}
		}
		return Math.sqrt(sum_of_squares);
	}

	public static double cosine_similarity(HashMap<String, Integer> vec1, HashMap<String, Integer> vec2) {
		double dot_product = 0.0;

		for (String key : vec1.keySet()) {
			if (vec2.containsKey(key)) {

				dot_product += vec2.get(key) * vec1.get(key);

			}
		}
		return dot_product / (norm(vec1) * norm(vec2));
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> filenames = new ArrayList();
		ArrayList<ArrayList<String>> text = new ArrayList();
		HashMap<String, HashMap<String, Integer>> vec = new HashMap();
		String temp;
		boolean flag = true;
		do {
			System.out.print("Add more files? y / n: ");
			if (sc.next().equals("y")) {
				System.out.print("Give me the filename: ");
				temp = sc.next();
				filenames.add(temp);
			} else {

				flag = false;
			}
		} while (flag);
		text = get_sentence_lists_from_files(filenames);
		System.out.println(text);
		vec = build_semantic_descriptors(text);
		System.out.println(vec);
		ArrayList<String> choices = new ArrayList();
		choices.add("liver");
		choices.add("sick");

		System.out.println(most_similar_word("man", choices, vec));

	}
}
