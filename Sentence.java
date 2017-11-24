import java.util.ArrayList;

public class Sentence {

	private ArrayList<String> list= new ArrayList<String>();;
	
	public Sentence(String text){
				
		
		String[] tokenised	= text.split("\\ ");
		
		for(int i=0;i<tokenised.length ;i++){
			
			if (tokenised[i].charAt(tokenised[i].length() -1) == '.' ||  tokenised[i].charAt(tokenised[i].length() -1) == '!' ||  tokenised[i].charAt(tokenised[i].length() -1) == ','){
				
				String temp = tokenised[i].substring(0, tokenised[i].length() -1);
				
				tokenised[i] = temp;
				
			}
				
			list.add(tokenised[i]);
				
			
			
			
		}
		
		
		
	}
	
	public void print(){
		
		
		for (int t =0; t< list.size(); t++){
			System.out.println(list.get(t));
		}
		
	}
	
	
	
	
}
