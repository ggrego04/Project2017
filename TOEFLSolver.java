import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TOEFLSolver {
	public static ArrayList<ArrayList<String>> getSentenceLists(String text) {
		ArrayList <ArrayList<String>> t=new ArrayList();
		String[] tokenised	= text.split("\\."+"\\;"+"\\!");
		for(int i=0;i<tokenised.length;i++) {
			t.add((new Sentence (tokenised[i])).getList());
		}
		return t;
	}

	public static void main(String[] args) throws FileNotFoundException {

		File file1 = new File("temp.txt");
		File file2 = new File("pg7178.txt");
		ArrayList<ArrayList<String>> SentenceList=new ArrayList();
		ArrayList<ArrayList<String>> SentenceList2=new ArrayList();
		
		Scanner scan1 = new Scanner(file1);

		Scanner scan2 = new Scanner(file2);
		
		String textF1 = null;
		String textF2 = null;
		String textF3= textF1+textF2;
		
		while(scan1.hasNextLine()){
			
			textF1 = textF1 + scan1.nextLine();
			
		}
		SentenceList=getSentenceLists(textF1);
		
		while (scan2.hasNextLine()){
			
			textF2 = textF2 + scan2.nextLine();
		}
		SentenceList2=getSentenceLists(textF2);
		/*String[]	keimeno = textF1.split("\\.");
		
		ArrayList<Sentence> prot = new ArrayList<Sentence>();
		
		for(int i =0; i< keimeno.length; i++){
			
			prot.add(new Sentence(keimeno[i]));
			
		}*/
		
		//VectorWord vector = new VectorWord(prot, "may");
		//vector.printWords();
		
		
		
	}
}
