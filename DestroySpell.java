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
 *This class Represents a card in the game, that has a Special
 *effect when played. This effect is to destroy the first enemy Spell Card.
 *It extends from the class TrapCard and implements from the interface Special.
 */
public class DestroySpell extends TrapCard implements Special{
	/**
	 * @constructor
	 * 
	 * This constructor calls the super class to create a new object.
	 * The super class's method takes as parameters the name and 
	 * description of the card
	 */
	public DestroySpell() {
		super("Destroy Spell", "Destroys the enemy’s first spell card.");
	}
	/** 
	 * @param owner as Field. Indicates the player's field
	 * 
	 * @param enemy as Field. Indicates the enemy field
	 * 
	 * This method enables the instant effect of the card by using
	 * the super class's method instantEffect.
	 */
	public void instantEffect(Field owner,Field enemy) {
		super.instantEffect(owner, enemy);
	}
}
