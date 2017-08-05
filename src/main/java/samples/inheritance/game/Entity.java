package samples.inheritance.game;

import samples.inheritance.game.dice.Dice;

/**
 * An entity in the game.
 *
 * Notes:
 * An interface only has method headers, with no implementation.
 * All methods declared in an interface are implicitly public and
 * abstract (i.e. not implemented).
 */
public interface Entity {

	/** Tells if the entity is alive */
	boolean isAlive();

	int getHealth();

	/** Returns the next attack depending on the dice number */
	int attack(Dice dice);

	/** Receives the hit from another entity depending on the dice number */
	void receiveHit(int hit, Dice dice);
}
