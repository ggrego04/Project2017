import java.util.ArrayList;

public class Sentence {

	private ArrayList<String> list= new ArrayList<String>();;
	
	public Sentence(String text){
				
		
		String [] tokenised	= text.split("'|\\ +|\\,|\\:");
		
		for(int i=0;i<tokenised.length ;i++){
			if(!tokenised[i].isEmpty()) {	
			list.add(tokenised[i]);
			}
		}
	}
	
	public void print(){
		
		
		for (int t =0; t< list.size(); t++){
			System.out.println(list.get(t));
		}
		
	}

	public int size() {
		return this.list.size();

	}

	public String get(int j) {
		return this.list.get(j);
	}
	public ArrayList<String> getList() {
		return list;
	}
	
	
	
}
