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
 *This class Represents a Trap card in the game, that has 
 *a Special effect when played. It extends from the class Card
 *and implements from the interface Special.
 */
public class TrapCard extends Card implements Special{
	/**
	 * @param n as String. The name of the card
	 * 
	 * @param d as string. The description of the card
	 * 
	 * @constructor
	 * 
	 * This constructor uses the super class to create a TrapCard
	 * by the use of the name and description given by the user
	 */
	public TrapCard(String n,String d) {
		super(n,d);
	}
	/**
	 * @param o as Object
	 * 
	 * @return a boolean value (true or false)
	 * 
	 * This method compares 2 objects and checks if they are the same.
	 * If they are, then it returns the value true, if not, it returns 
	 * the value false. It uses the method equals from the super class
	 */
	public boolean equals(Object o) {
		return super.equals(o);
	}
	/** 
	 * @param owner as Field. Indicates the player's field
	 * 
	 * @param enemy as Field. Indicates the enemy field
	 * 
	 * This method enables the instant effect of a Special Card.
	 * Trap Cards have instant effect when they are played, and that is to
	 * destroy the first enemy Spell Card
	 */
	public void instantEffect(Field owner,Field enemy) {
		for(int i=0;i<enemy.spell.length;i++) {
			//this loop starts from the start of the spell card field until the end
			if(enemy.spell[i]!=null) {
				//if there is a non null place then it calls the destroyed effect, to destroy the fist spell card it finds
				enemy.spell[i].destroyedEffect(owner, enemy);
				enemy.spell[i]=null;													//nulls the value of the spot it found the card in the enemy's spell card field
				break;																	//breaks the loop
			}
		}
	}
}
