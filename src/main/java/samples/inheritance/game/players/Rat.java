package samples.inheritance.game.players;

import samples.inheritance.game.dice.Dice;

public class Rat extends Player {

	@Override
	public int attack(Dice dice) {
		return 1;
	}
}
