import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TOEFLSolver {

	public void getSentenceLists(String text) {

	}

	public static void main(String[] args) throws FileNotFoundException {

		File file1 = new File("temp.txt");
		File file2 = new File("pg7178.txt");

		Scanner scan1 = new Scanner(file1);

		Scanner scan2 = new Scanner(file2);
		
		String textF1 = null;
		String textF2 = null;
		
		
		while(scan1.hasNextLine()){
			
			textF1 = textF1 + scan1.nextLine();
			
		}
		
		while (scan1.hasNextLine()){
			
			textF2 = textF2 + scan1.nextLine();
		}
		
		String[]	keimeno = textF1.split("\\.");
		
		ArrayList<Sentence> prot = new ArrayList<Sentence>();
		
		for(int i =0; i< keimeno.length; i++){
			
			prot.add(new Sentence(keimeno[i]));
			
		}
		
		VectorWord vector = new VectorWord(prot, "may");
		vector.printWords();
		
		
		
	}
}
