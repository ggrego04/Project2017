import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

/**
 * This class imlements all the functions that find the
 * similarity of words. First a large text is read, and
 * then it's split into sentences that have words. Afterwards
 * the question comes and asks to find the most similar word
 * out of 3 words with another.
 * 
 * @author Gregory Gregoriades
 * @author Christos Achilleos
 *
 */
public class TOEFLSolver {
	public static ArrayList<ArrayList<String>> getSentenceLists(String text) {
		ArrayList<ArrayList<String>> t = new ArrayList();
		String[] tokenised = text.split("\\!|\\.+");
		for (int i = 0; i < tokenised.length; i++) {
			t.add((new Sentence(tokenised[i])).getList());
		}
		return t;
	}

	/**
	 * @param filenames as ArrayList<String>
	 * @return an ArrayList with ArrayLists <String>
	 * 
	 * This method takes as parameter the ArrayList that contains 
	 * all the filenames. It creates two tables that contain files
	 * and scanners. Afterwards each file in the table is read, it
	 * is added in another String table. At the end it calls the 
	 * getSentenceLists method to get an ArrayList of ArrayLists
	 * of String and then it returns it.
	 */
	public static ArrayList<ArrayList<String>> get_sentence_lists_from_files(ArrayList<String> filenames) {
		File[] f = new File[filenames.size()];
		Scanner scan[] = new Scanner[filenames.size()];
		for (int i = 0; i < filenames.size(); i++) {
			f[i] = new File(filenames.get(i));
			try {
				scan[i] = new Scanner(f[i]);
			} catch (FileNotFoundException e) {
				
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

	/**
	 * @param t as ArrayList of ArrayList<String>
	 * @return a HashMap<String,HashMap<String,Integer>>
	 * 
	 * This method takes as parameter an ArrayList of ArrayLists of Strings.
	 * Sets the value for the semantic descriptors by placing all words in the hashmap
	 * 
	 */
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

	/**
	 * @param word as String
	 * @param s as ArrayList<ArrayList<String>>
	 * @return a HashMap<String, Integer>
	 * 
	 * This method is called in the previous method and it takes as parameters
	 * a String and an ArrayList of ArrayLists of Strings. When the word is equal
	 * to the String in the ArrayList, it searches the ArrayList that contains the
	 * word we are looking for and it adds in a HashMap the amount of each of the 
	 * other words that appear with the requested word in the same List. Then it 
	 * returns the HashMap.
	 * 
	 */
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
	/**
	 * @param word as String
	 * @param choices as an ArrayList <String>
	 * @param semantic_descriptors as HashMap<String, HashMap<String, Integer>>
	 * 
	 * @return a String
	 * 
	 * This method finds the place of the word in the given HashMap. It creates
	 * a table with doubles that the cosine_similarity of the two words will finally
	 * be stored in. Then it searches the certain table for the biggest value and then
	 * returns the specific word.
	 */
	public static String most_similar_word(String word, ArrayList<String> choices,HashMap<String, HashMap<String, Integer>> semantic_descriptors) {
		HashMap<String, Integer> h = new HashMap();
		h = semantic_descriptors.get(word);
		HashMap<String, Integer> hush = new HashMap();
		
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
		return choices.get(position);

	}

	/**
	 * @param vec as HashMap<String,Integer>
	 * @return a double
	 * 
	 * This method takes as parameter a HashMap<String,Integer> and sums up
	 * the square of each word in the HashMap and returns it.
	 */
	public static double norm(HashMap<String, Integer> vec) {
		double sum_of_squares = 0.0;

		for (String word : vec.keySet()) {
			sum_of_squares += (vec.get(word) * vec.get(word));
		}
		//System.out.println(Math.sqrt(sum_of_squares));
		return Math.sqrt(sum_of_squares);
	}

	/**
	 * @param vec1 as HashMap<String, Integer>
	 * @param vec2 as HashMap<String, Integer>
	 * 
	 * @return a double
	 * 
	 * This method checks first if the two given vectors are empty. If they
	 * are, then it returns -1. If not, a loop, sums up the total of the 
	 * products of each similar word in the two vectors and returns it divided
	 * by the product of their norm (a method that is called and finds the square
	 * of the vectors's words sum). 
	 */
	public static double cosine_similarity(HashMap<String, Integer> vec1, HashMap<String, Integer> vec2) {
		double dot_product = 0.0;
		if (vec1.isEmpty() || vec2.isEmpty() || vec1 == null || vec2 == null) {
			return -1.0;
		}
		for (String key : vec1.keySet()) {
			if (vec2.containsKey(key)) {

				dot_product += vec1.get(key) * vec2.get(key);

			}
		}
		return dot_product / (norm(vec1) * norm(vec2));
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * 
	 * This is the main method. It uses all the necessary methods that
	 * fill the ArrayLists, create the HashMaps, find the similarity
	 * of the words and prints out the correct answer in a series of choices
	 * entered by the user that request the most similar wordcin all the choices.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> filenames = new ArrayList();
		ArrayList<ArrayList<String>> text = new ArrayList();
		HashMap<String, HashMap<String, Integer>> vec = new HashMap();
		String temp;
		String questions = null;
		boolean flag = true;
		do {
			System.out.print("Add more files? y / n: ");
			if (sc.next().equals("y")) {
				System.out.print("Give me the filename: ");
				temp = sc.next();
				filenames.add(temp);
			} else {
				System.out.println("Give the question file: ");
				flag = false;
				questions=sc.next();
			}
		} while (flag);
		
		File q = new File(questions);
		Scanner s = new Scanner(q);
		
		ArrayList<String[]> quest = new ArrayList();
		
		while(s.hasNextLine()) {
			
			quest.add(s.nextLine().split("\\ "));
			
		}
		text = get_sentence_lists_from_files(filenames);
		System.out.println(text);
		vec = build_semantic_descriptors(text);
		//System.out.println(vec);
		ArrayList<String> choices = new ArrayList();
		choices.add(quest.get(0)[2]);
		choices.add(quest.get(0)[3]);
		System.out.println(most_similar_word(quest.get(0)[0], choices, vec));

	}
}
