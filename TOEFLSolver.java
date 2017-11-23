import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TOEFLSolver {

	public static void main(String[] args) {
		
		File file1 = new File("pg2600");
		File file2 =  new File("pg7178");
		
		
		
		try {
			Scanner scan1 = new Scanner(file1);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			Scanner scan2 = new Scanner(file2);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
}
	
