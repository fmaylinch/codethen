package samples.inheritance.game;

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

	/** Returns the next attack */
	int attack();

	/** Receives the hit from another entity */
	void receiveHit(int hit);
}
