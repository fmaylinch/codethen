package samples.inheritance.game.players;

import samples.inheritance.game.dice.Dice;

public class Zombie extends Player {

	@Override
	public int attack(Dice dice) {
		return dice.nextInt(3) + 2;
	}
}
