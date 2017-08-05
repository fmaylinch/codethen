package samples.inheritance.game.dice;

import java.util.Random;

/** Real dice, that produces random numbers */
public class RealDice implements Dice {

	private Random random;

	public RealDice() {
		random = new Random();
	}

	@Override
	public int nextInt(int n) {
		return random.nextInt(n);
	}
}
