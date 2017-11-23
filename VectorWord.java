import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VectorWord {
	ArrayList<Word> sentences = new ArrayList<Word>();
	ArrayList<VectorWord> text=new ArrayList<VectorWord>();
	public VectorWord(Word...s) {
		for(Word o:s) {
			sentences.add(o);
		}
	}
	public VectorWord(VectorWord...s) {
		for(VectorWord o:s) {
			text.add(o);
		}
	}
}
