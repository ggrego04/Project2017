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
 * This class represents the players, both the owner and the enemy,
 * their hands and their decks.
 *
 */
public class Player {
	CardDeck MainDeck;														//a MainDeck as CardDeck is declared
	SpecialDeck specialDeck;												//a specialDeck as SpecialDeck is declared
	Card hand[]=new Card[5]; 												//a table with size 5 that has Cards and represents the hand of the player
	Special nextSpecial;													//a nextSpecial variable as Special is declared
	int lifePoints;															//a variable lifePoints as integer is declared
	/**
	 * @param cd as CardDeck. Represents the deck of the player
	 * 
	 * @param sd as SpecialDeck. Represents the special deck of the player
	 * 
	 * @param lp as integer. Represents the life points of the player
	 * 
	 * @constructor
	 * 
	 * This constructor creates the object Player using as parameters the
	 * CardDeck of the player,his Special Deck and his life points given by the user
	 */
	public Player(CardDeck cd,SpecialDeck sd,int lp) {
		this.MainDeck=cd;													//MainDeck takes the value of cd
		this.specialDeck=sd;												//specialDeck takes the value of sd
		this.lifePoints=lp;													//lifePoints takes the value of lp
	}
	/**
	 * @param cd as CardDeck. Represents the deck of the player
	 * 
	 * @param sd as SpecialDeck. Represents the special deck of the player
	 * 
	 * @constructor
	 * 
	 * This constructor creates the object Player using as parameters the
	 * CardDeck of the player, his Special Deck and adjusts his life points to 5000
	 */
	public Player(CardDeck cd,SpecialDeck sd) {
		this.MainDeck=cd;													//MainDeck takes the value of cd
		this.specialDeck=sd;												//specialDeck takes the value of sd
		this.lifePoints=5000;												//lifePoints takes the value 5000
	}
	/**
	 * @return hand as a table of Card type Objects
	 */
	public Card[] getHand() {
		return hand;
	}
	/**
	 * @param hand as a table of Card type objects
	 * 
	 * This method initializes this.hand with hand
	 */
	public void setHand(Card[] hand) {
		this.hand = hand;													
	}
	/**
	 * @return nextSpecial as Special. Special Card
	 */
	public Special getNextSpecial() {
		return nextSpecial;
	}
	/**
	 * @param nextSpecial as Special. Special Card
	 * 
	 * This method initializes this.nextSpecial with nextSpecial
	 */
	public void setNextSpecial(Special nextSpecial) {
		this.nextSpecial = nextSpecial;
	}
	/**
	 * @return lifePoints as integer
	 */
	public int getLifePoints() {
		return lifePoints;
	}
	/**
	 * @param lifePoints as integer
	 * 
	 * This method initializes this.lifePoints with lifePoints
	 */
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	/**
	 * @param count as integer. The number of cards we want to draw
	 * 
	 * @return a boolean value that shows us if a card has been drawn
	 * succesfully or not
	 * 
	 * This method takes as parameter an integer that indicates the amount
	 * of cards you want to draw, checks the deck from the start till the end
	 * until he finds a non null object, which then returns
	 */
	public boolean draw(int count) {
		boolean handfull=true;													//a new boolean variable handfull is declared and initialized										
		if(MainDeck.isEmpty()) {
			//checks if the Deck is empty
			return false;														//if it's empty it returns false
		}else {
			for(int i=0;i<this.hand.length;i++) {
				//this loop starts from the start of the hand until the end and checks if it's full
				if(this.hand[i]==null) {
					//if it's not full then handfull takes the value false
					handfull=false;
				}
			}
			for(int i=0;i<count;i++) {
				//this loop starts from 0 until the counter value and checks if there is an empty space to place the new card
				if(handfull==false) {
					if(this.hand[i]==null) {
						this.hand[i]=(Card) MainDeck.deal();					//if the loop finds an empty space, then it calls the method deal to draw a card
					}else {
						count=count+1;											//otherwise, it increases the counter by one, to check the next place
					}
				}else {	
					return true;												//if the hand is full, it returns true again anyway, but doesn't draw a card
				}
			}
			return true;														//if the card is placed succesfully in a spot in the hand then returns true
		}
	}
	/**
	 * This method, draws a Special Card from the Special Deck
	 * and adds it to the next Special spot
	 */
	public void drawSpecialCard() {
		if((this.nextSpecial==null)&&(!this.specialDeck.isEmpty())) {
			//if the next Special spot is empty and the Special deck is not, it draws a card
			this.nextSpecial=(Card) specialDeck.deal();
		}
	}
	/**
	 * This method prepares the players for the net round. It draws
	 * them a card from the Main Deck and a Special Card. If the deck
	 * is empty then the player takes 500 damage to his life Points
	 */
	public void nextTurnPrep() {
		boolean a=draw(1);														//a boolean variable a is declared and calls the function draw
		if(a==false) {
			//if the function returns false then the player takes 500 damage to his life points
			this.lifePoints=this.lifePoints-500;
		}
		drawSpecialCard();														//It draws then a Special Card
	}
	/**
	 * @param whichCard as integer. It indicates which card the player
	 * wants to play
	 * 
	 * @param myField as Field. It indicates the players field
	 * 
	 * @return a boolean value
	 * 
	 * This method takes as parameters the player's field, the number of
	 * the card the player wants to play, checks that it is within the range 
	 * of the hand and plays the card
	 */
	public boolean playCardFromHand(int whichCard, Field myField){
		if((whichCard>5)||(whichCard<0)) {
			//if whichCard is not within the range of the hand it returns false
			return false;
		}else {
			if(this.hand[whichCard] instanceof MonsterCard) {
				//if the card we want to play is a MonsterCard then it calls the addMonsterCard and places the card into an empty spot
				boolean a=myField.addMonsterCard((MonsterCard) this.hand[whichCard]);
				if(a==true) {
					//if it's successfully placed then the previous place in the hand is nulled
					this.hand[whichCard]=null;
				}
				return a;														//It returns whether the move happened or not
			}else {
				if(this.hand[whichCard] instanceof SpellCard) {
					//if the card we want to play is a SpellCard then it calls the addSpellCard and places the card into the field
					boolean a= myField.addSpellCard((SpellCard)this.hand[whichCard]);
					if(a==true) {
						//if it's successfully placed then the previous place in the hand is nulled
						this.hand[whichCard]=null;
					}
					return a;													//It returns whether the move happened or not
				}else {
					return false;												//if it's not any of the above then it returns false
				}
			}
		}
	}
	/**
	 * @param myField as Field. Indicates the field of the player
	 * 
	 * @return a boolean value
	 * 
	 * This method takes as parameters the player's field, and plays the 
	 * Special card, from the nextSpecial spot
	 */
	public boolean playSpecial(Field myField) {
		if(nextSpecial==null) {
			//if it's empty returns false
			return false;
		}else {
			if(nextSpecial instanceof MonsterCard) {
				//if the card we want to play is a MonsterCard then it calls the addMonsterCard and places the card into an empty spot
				boolean a= myField.addMonsterCard((MonsterCard) nextSpecial);
				if(a==true) {
					//if it's successfully placed then the nextSpecial spot is nulled
					nextSpecial=null;
				}
				return a;														//It returns whether the move happened or not
			}else {
				if(nextSpecial instanceof TrapCard) {
					//if the card we want to play is a TrapCard then it just nulls the nextSpecial spot and returns true
					nextSpecial=null;
					return true;
				}else {
					return false;												//returns false if nothing of the above happened
				}
			}
		}
	}
	/**
	 * @param change as integer
	 * 
	 * This method changes the life points of a player using the parameter
	 * change
	 */
	public void changeLifePoints(int change) {
		this.lifePoints=this.lifePoints+change;									//change is added on the life points
	}
	/**
	 * @return a boolean value
	 * 
	 * This method checks if the life points of a player are less or equal
	 * to zero. If they are, then the player is dead and loses the game
	 */
	public boolean isDefeated() {
		if(this.lifePoints<=0) {
			//if the life points are less or equal to zero then it returns true
			return true;
		}else {
			//if it's not then it returns false
			return false;
		}
	}

}
