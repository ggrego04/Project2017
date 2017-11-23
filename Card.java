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
 * This class implements the interface Special and represents the 
 * Cards.It contains the card's name and description.It's an abstract class
 *
 */
public class Card implements Special{
	String name;															//is a String that represents the card name.
	String description;														//is a String that represents the card description.
	/**
	 * @param n as String. The name of the Card
	 * @param d as String. The description of the Card
	 * @constructor
	 * 
	 * This is a constructor that Creates the Object Card.It uses
	 * the name and description given by the user to initialize the
	 * Card's characteristics
	 */
	public Card(String n,String d) {
		this.name=n;
		this.description=d;
	}
	/**
	 * @return the card's name as String.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name as String
	 * 
	 * Initializes this.name with name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the card's description as String.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description as String
	 * 
	 * Initializes this.description with description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param o as Object
	 * 
	 * @return a boolean value (true or false)
	 * 
	 * This method compares 2 objects and checks if they are the same.
	 * If they are, then it returns the value true, if not, it returns 
	 * the value false.
	 */
	public boolean equals(Object o) {
		if(o==null) {
			//checks if the Object is null and returns false if it is.
			return false;
		}
		if(this.getClass()!=o.getClass()) {
			//checks if the type of the 2 objects is the same.If it's not then it returns false
			return false;
		}
		Card obj=  (Card) o;												//Creation of a Card obj based on the Object o
		if((this.name!=obj.name)||(this.description!=obj.description)) {
			//Checks if the name and description of the Card obj is equal to the other Card and returns false if it's not.
			return false;
		}
		return true;														//returns true if the Card obj is the same with this Card
	}
	/**
	 * @return String 
	 * 
	 * This method prints out the name and description of the Card
	 */
	public String toString() {
		return this.name+": "+this.description;
	}
	/** 
	 * @param the Field of the owner and the Field of the enemy
	 * This is an overriden method,that has its source from the interface Special
	 */
	@Override
	public void instantEffect(Field owner, Field enemy) {
	}

}
