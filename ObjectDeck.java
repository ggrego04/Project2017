package cy.ucy.cs.ID917281.HW4;
/**
 * @author Gregory Gregoriades
 * 
 * @date 15/11/17
 * 
 * @version 1.0
 * 
 * @id 917281
 * 
 * This class Represents a Deck of Objects (Cards). It is used to hold a 
 * number of Cards, and can hold them in a table. This is an abstract class
 *
 */
public class ObjectDeck {
	Object table[];													//It is an Object table that represents the deck of Cards 
	public ObjectDeck(Object o[]) {
		this.table=o;
	}
	/**
	 * @return an Object
	 * 
	 * At first this method checks if the deck is empty.If it is then it returns null.
	 * If it is not then it draws the next card from the deck.
	 */
	public Object deal() {
		Object a=null;													//an Object a is initialized
		if(!isEmpty()) {
			//if the deck is not empty return the next card from the deck
			for(int i=0;i<this.table.length;i++) {
				//this loop starts from the beginning of the deck until the end, or until it finds a non null Object
				if(this.table[i]!=null) {
					a=this.table[i];									//If it finds a non null Object, it's moved in a
					this.table[i]=null;									//the place that the Object was is initialized with the value null
					break;												//stops the loop
				}
			}
			return a;													//returns the Card drawn
		}else {
			return null;												//if the Deck is empty, returns null
		}
	}
	/**
	 * @return a boolean value(true or false)
	 * 
	 * This method is used to check if a Deck of cards is empty or not.
	 * If it is empty, the value true is returned and if it's not, it returns false
	 */
	public boolean isEmpty() {
		boolean flag=true;												//a new boolean variable flag is initialized 
		for(int j=0;j<this.table.length;j++) {
			//this loop starts from the start until the end of the deck and checks if there's a non null object
			if(this.table[j]!=null) {
				//if there's a non null object, the flag takes the value false
				flag=false;
			}
		}
		return flag;													//returns whether the deck is empty or not
	}
	/**
	 * @return an integer that represents the number of cards currently in the deck
	 * 
	 * This method calculates the number of cards in the deck
	 */
	public int size() {
		int count=0;													//a new integer variable count is initialized
		for(int j=0;j<this.table.length;j++) {
			//this loop starts from the top of the deck until the end and checks if there are non null objects
			if(this.table[j]!=null) {
				//if an object is not null the counter is added by 1
				count=count+1;
			}
		}
		return count;													//returns the counter value
	}
	
}
