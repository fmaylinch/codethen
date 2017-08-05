package samples.inheritance.game.dice;

public interface Dice {

	/**
	 * Returns a number from 0 to n-1.
	 * Simulates the throwing of a dice of n sides (although 0-based).
	 */
	int nextInt(int n);
}
