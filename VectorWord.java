import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VectorWord {
	ArrayList<Word> vector1 = new ArrayList<Word>();
	
	public VectorWord(Word...s) {
		for(Word o:s) {
			vector1.add(o);
		}
	}
}
