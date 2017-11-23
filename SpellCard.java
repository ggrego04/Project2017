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
 *This class Represents a Spell card in the game, that has a
 *Special effect when played. It extends from the class Card.
 */
public class SpellCard extends Card{
	/**
	 * @param n as String. The name of the card
	 * 
	 * @param d as String. The description of the card
	 * 
	 * @constructor
	 * 
	 * This constructor calls the super class using the parameters
	 * name and description given by the user
	 */
	public SpellCard(String n,String d) {
		super(n,d);
	}
	/**
	 * @param ownerField as Field. Indicates the player's field
	 * 
	 * @param enemyField as Field. Indicates the enemy's field 
	 * 
	 * This method enables the turn effects a Spell Card may have.
	 * For example, At the end of the turn the player's monsters
	 * take 100 more points to their power.
	 */
	public void turnEffect(Field ownerField,  Field enemyField) {
		for(int i=0;i<ownerField.monster.length;i++) {
			//this loop starts from the start of the monster cards field until the end
			if(ownerField.monster[i]!=null) {
				//If there's a non null place then the Monster Card in that place gains +100 power
				ownerField.monster[i].power=ownerField.monster[i].power+100;
				ownerField.monster[i].canAttack=true;											//It also makes the monster Card able to attack
			}
		}
	}
	/**
	 * @param ownerField as Field. Indicates the player's field
	 * 
	 * @param enemyField as Field. Indicates the enemy's field 
	 * 
	 * This method is called when a Spell Card is destroyed. The
	 * effect that it has is to reduce the power of the enemy's 
	 * Monster Cards by 300. 
	 */
	public void destroyedEffect(Field ownerField,  Field enemyField) {
		for(int i=0;i<enemyField.monster.length;i++) {
			//this loop starts from the start of the enemy's monster cards field
			if(enemyField.monster[i]!=null) {
				//if there's a non null place then the power of that Monster Card is reduced by 300
				enemyField.monster[i].power=enemyField.monster[i].power-300;
			}
		}
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
}
