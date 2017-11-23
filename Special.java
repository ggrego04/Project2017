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
 * This interface indicates whether a card is a Special Card
 * or not. If it's a Special Card it means it has a Special effect 
 * when played in the field
 *
 */
public interface Special {
	/**
	 * @param owner as Field. Indicates the player's field
	 * 
	 * @param enemy as Field. Indicates the enemy's field
	 * 
	 * This method enables the Special Card's Instant Effect
	 */
	public void instantEffect(Field owner,Field enemy);
}
