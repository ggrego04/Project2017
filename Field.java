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
 * This class represents the field of the players, both the 
 * owner and the enemy fields, it contains the place the monsters 
 * are placed, and the place the Spell Cards are placed
 */
public class Field {
	MonsterCard monster[]=new MonsterCard[5];												//a table of MonsterCards size 5 is declared
	SpellCard spell[]=new SpellCard[5];														//a table of SpellCards size 5 is declared
	/**
	 * @return monster as a table of type MonsterCard
	 */
	public MonsterCard[] getMonsters() {
		return monster;
	}
	/**
	 * @param monster as a table of MonsterCards
	 * 
	 * Initializes this.monster with monster
	 */
	public void setMonsters(MonsterCard[] monster) {
		this.monster = monster;
	}
	/**
	 * @return spell as a table of type SpellCard
	 */
	public SpellCard[] getSpells() {
		return spell;
	}
	/**
	 * @param spell as a table of SpellCards
	 * 
	 * Initializes this.spell with spell
	 */
	public void setSpells(SpellCard[] spell) {
		this.spell = spell;
	}
	/**
	 * @param enemyfield as field. Indicates the field
	 * of the enemy player
	 * 
	 * This method enables the turn effects for each of the Spell cards
	 * on the field
	 */
	public void cardTurnEffects(Field enemyfield) {
		for(int i=0;i<this.spell.length;i++) {
			//this loop starts from the start of the spell Cards place until the end 
			if(this.spell[i]!=null) {
				//if there is a Spell Card in the field, then it enables its turn effect by calling the function turnEffect
				this.spell[i].turnEffect(this,enemyfield);
			}
		}
	}
	/**
	 * @param card as MonsterCard. Indicates the card that is going to be played
	 * 
	 * @return a boolean value
	 * 
	 * This method adds a MonsterCard of the player's choice in the
	 * field
	 */
	public boolean addMonsterCard(MonsterCard card) {
		boolean full=true;																		//a boolean variable full is declared
		for(int i=0;i<this.monster.length;i++) {
			//this loop starts from the start of the monster cards place until the end
			if(this.monster[i]==null) {
				//if there is a null place then full takes the value false
				full=false;
				break;																			//breaks the loop
			}
		}
		if(full==false) {
			//if the field is not full
			for(int i=0;i<this.monster.length;i++) {
				//this loop starts from the start of the monster cards place until the end
				if(this.monster[i]==null) {
					//if there is a null place then the monster card we want to play is taking its place
					this.monster[i]=card;
					break;																		//breaks the loop
				}
			}
			return true;																		//when the move is completed successfully it returns the value true
		}else {
			return false;																		//if the field is full then it returns the value false
		}

	}
	/**
	 * @param card as SpellCard. Indicates the card that is going to be played
	 * 
	 * @return a boolean value
	 * 
	 * This method adds a SpellCard of the player's choice in the
	 * field
	 */
	public boolean addSpellCard(SpellCard card) {
		boolean full=true;																		//a boolean variable full is declared
		for(int i=0;i<this.spell.length;i++) {
			//this loop starts from the start of the spell cards place until the end
			if(this.spell[i]==null) {
				//if there is a null place then full takes the value false
				full=false;
				break;																			//breaks the loop
			}
		}
		if(full==false) {
			//if the field is not full
			for(int i=0;i<this.spell.length;i++) {
				//this loop starts from the start of the spell cards place until the end
				if(this.spell[i]==null) {
					//if there is a null place then the spell card we want to play is taking its place
					this.spell[i]=card;
					break;																		//breaks the loop
				}
			}
			return true;																		//when the move is completed successfully it returns the value true
		}else {
			return false;																		//if the field is full then it returns the value false
		}

	}
}
