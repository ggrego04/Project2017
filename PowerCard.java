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
 *This class Represents a Spell card called Power Card, it give's
 *the player's monster Cards +100 on their power at the end of the turn but
 *when destroyed it removes 300 points on their power. It extends from the
 *class SpellCard and implements from the interface Special.
 */
public class PowerCard extends SpellCard implements Special{
	/**
	 * @constructor
	 * 
	 * This is a constructor that Creates the Power Card. It uses the 
	 * super class, the name and description given by the user to 
	 * initialize the Card's characteristics
	 */
	public PowerCard() {
		super("Power Card","Increases power of monsters by 100 each turn.");
	}
	/**
	 * @param ownerField as Field. Indicates the player's field
	 * 
	 * @param enemyField as Field. Indicates the enemy's field 
	 * 
	 * This method enables the turn effects of the Power Card (give the
	 * power of the enemy's monster Cards +100). It calls the super
	 * class's method turnEffect for this action.
	 */
	public void turnEffect(Field ownerField,  Field enemyField) {
		super.turnEffect(ownerField, enemyField);
	}
	/**
	 * @param ownerField as Field. Indicates the player's field
	 * 
	 * @param enemyField as Field. Indicates the enemy's field 
	 * 
	 * This method enables the destroyed effects of the Power Card (reduce the
	 * power of the enemy's monster Cards by 300). It calls the super class's 
	 * method destroyedEffect for this action.
	 */
	public void destroyedEffect(Field ownerField,  Field enemyField) {
		super.destroyedEffect(ownerField, enemyField);
	}
}
