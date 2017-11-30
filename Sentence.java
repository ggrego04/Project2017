import java.util.ArrayList;

/**
 * @author Gregory Gregoriades
 * @author Christos Achilleos
 * 
 * This class creates an Object named Sentence, which takes a sentence
 * splits it to words and adds them to a list
 */
public class Sentence {

	private ArrayList<String> list= new ArrayList<String>();;
	
	/**
	 * @param text as String
	 * 
	 * This Constructor creates the Object Sentence. It take sa text and 
	 * splits it into parts using  "," , "-" , "--" , ":" , ";" ," ' " 
	 * and spaces. Then it adds them to a list.
	 */
	public Sentence(String text){
				
		
		String [] tokenised	= text.split("'|\\ +|\\,|\\:|\\-|\\--|\\;");
		
		for(int i=0;i<tokenised.length ;i++){
			if(!tokenised[i].isEmpty()) {	
			list.add(tokenised[i]);
			}
		}
	}


	/**
	 * @return an ArrayList<String>
	 * 
	 * This method returns the list of a Sentence
	 */
	public ArrayList<String> getList() {
		return list;
	}
	
	
	
}
