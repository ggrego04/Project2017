import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VectorWord {
	ArrayList<Integer> vector = new ArrayList<Integer>();
	
	public VectorWord(int...i) {
		for(int o:i) {
			vector.add(o);
		}
	}
}
