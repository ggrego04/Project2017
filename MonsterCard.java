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
 *This class Represents a Monster card in the game, that can attack 
 *other monster cards and do damage to the opponent’s life points.
 *It extends from the class Card.
 *
 */
public class MonsterCard extends Card{
	int power;																//a new integer variable power is declared that represents the current power of the monsterCard
	int basePower;															//a new integer variable basePower is declared that represents the power the monsterCard had at the start of the game
	boolean canAttack;														//a new boolean variable canAttack is declared that represents whether te monsterCard can attack or not
	/**
	 * @param n as String. The name of the Card
	 * 
	 * @param d as String. The description of the Card
	 * 
	 * @param bP as integer. The base power of the card
	 * 
	 * @param a as boolean that states whether it can attack or not
	 * 
	 * @constructor
	 * 
	 * This is a constructor that Creates the MonsterCard.It uses the 
	 * super class, the name, description,base power and the boolean 
	 * value given by the user to initialize the Card's characteristics
	 */
	public MonsterCard(String n,String d,int bP,boolean a) {
		super(n,d);															//The super class is called to initialize the Card's name and description
		this.basePower=bP;													//The base power of the card takes the value of the bP given by user 
		this.power=bP;														//The power of the card takes the value of the bP given by user too
		this.canAttack=a;													//The boolean value canAttack takes the value of a
	}
	/**
	 * @param n as String. The name of the Card
	 * 
	 * @param d as String. The description of the Card
	 * 
	 * @param bP as integer. The base power of the card
	 * 
	 * @constructor
	 * 
	 * This is a constructor that Creates the MonsterCard.It uses the 
	 * super class, the name, description,base power given by the user
	 * to initialize the Card's characteristics and sets the boolean 
	 * canAttack value to false
	 */
	public MonsterCard(String n,String d,int bP) { 
		super(n,d);															//The super class is called to initialize the Card's name and description
		this.basePower=bP;													//The base power of the card takes the value of the bP given by user
		this.power=bP;														//The power of the card takes the value of the bP given by user too
		this.canAttack=false;												//The boolean value canAttack takes the value false
	}
	/**
	 * @return the value of the power of the card as integer
	 */
	public int getPower() {
		return power;
	}
	/**
	 * @param power as integer
	 * 
	 * Initializes this.power with power
	 */
	public void setPower(int power) {
		this.power = power;
	}
	/**
	 * @return the value of canAttack as boolean
	 */
	public boolean getCanAttack() {
		return canAttack;
	}
	/**
	 * @param canAttack as boolean
	 * 
	 * Initializes this.canAttack with canAttack
	 */
	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
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
		MonsterCard obj=  (MonsterCard) o;																	//Creation of a MonsterCard obj based on the Object o
		if((super.name!=obj.name)||(super.description!=obj.description)||(this.power!=obj.power)||(this.basePower!=obj.basePower)||(this.canAttack!=obj.canAttack)) {
			//Checks if the name, the description, the power, the bse power and the canAttack value of the Card obj is equal to the other Card and returns false if it's not.
			return false;
		}
		return true;																						//returns true if the MonsterCard obj is the same with this MonsterCard
	}
	/**
	 * @return String 
	 * 
	 * This method prints out the name, the description, the power and the canAttack value of the Card
	 */
	public String toString() {
		return super.toString() + " | Power: "+this.power + " | Can  attack: " + this.canAttack;
	}
}
