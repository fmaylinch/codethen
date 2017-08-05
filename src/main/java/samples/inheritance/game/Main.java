package samples.inheritance.game;

import samples.inheritance.game.dice.Dice;
import samples.inheritance.game.dice.RealDice;

/** The real game */
public class Main {

	public static void main(String[] args) {

		Dice dice = new RealDice();
		Game game = new Game(dice);
		game.start();
	}
}
