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
 * This class extends from the class Object Deck and represents the Deck of
 * the Cards.It calls the necessary methods from the super class in order to
 * create the Deck and draw cards from the deck
 *
 */
public class CardDeck extends ObjectDeck{
	/**
	 * @param a as Card. It takes a variable number of Cards
	 * @contructor
	 * 
	 * This constructor takes as parameter a variable number of cards and
	 * creates a deck using the super class's constructor 
	 */
	public CardDeck(Card...a) {
			super(a);							//creation of the deck
	}
	/**
	 * @return a Card.
	 * 
	 * This method uses the super class to draw a card from the deck
	 * and adds it to the owner's hand.
	 */
	public Object deal() {
		return super.deal();					//card draw
	}
}
