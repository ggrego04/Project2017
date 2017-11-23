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
 * This class extends from the class Object Deck and implements the interface 
 * Special. It represents the Deck of Special Cards.It calls the necessary 
 * methods from the super class in order to create the Deck and draw cards from the deck
 *
 */
public class SpecialDeck extends ObjectDeck implements Special{
	/**
	 * @param s as Special. It takes a variable number of Special Cards
	 * 
	 * @contructor
	 * 
	 * This constructor takes as parameter a variable number of special cards and
	 * creates a deck using the super class's constructor 
	 */
	public SpecialDeck(Special...s) {
		super(s);													//creation of the special deck
	}
	/**
	 * @return a Special Card.
	 * 
	 * This method uses the super class to draw a card from the Special deck
	 * and adds it to the owner's hand.
	 */
	public Object deal() {
		return super.deal();										//draws from the deck
	}
	/** 
	 * @param the Field of the owner and the Field of the enemy
	 * This is an overriden method,that has its source from the interface Special
	 */
	@Override
	public void instantEffect(Field owner, Field enemy) {
		
	}
}
