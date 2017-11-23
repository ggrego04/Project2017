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
 *This class Represents a Monster card called Blue Eyes White Dragon,
 *that can attack other monster cards and do damage to the opponent’s 
 *life points. It extends from the class MonsterCard and implements 
 *from the interface Special.
 *
 */
public class BlueEyesWhiteDragon extends MonsterCard implements Special{
	/**
	 * @constructor
	 * 
	 * This is a constructor that Creates the Blue Eyes White Dragon.It uses the 
	 * super class, the name, description,base power and the boolean 
	 * value given by the user to initialize the Card's characteristics
	 */
	public BlueEyesWhiteDragon() {
		super("Blue Eyes White Dragon","The best card.",3000,true);
	}
	/** 
	 * @param the Field of the owner and the Field of the enemy
	 * This is an overriden method,that has its source from the interface Special
	 * When the card is played it has an instant effect on the board. This effect
	 * creates two more copies of the card, or less depends if the field is full or not
	 */
	public void instantEffect(Field owner,Field enemy) {
		owner.addMonsterCard(new BlueEyesWhiteDragon ());					//calls the addMonsterCard to put a copy of the card in the field
		owner.addMonsterCard(new BlueEyesWhiteDragon ());					//calls the addMonsterCard to put a copy of the card in the field
	}
}
