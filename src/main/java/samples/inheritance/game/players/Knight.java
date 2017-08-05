package samples.inheritance.game.players;

import samples.inheritance.game.dice.Dice;

public class Knight extends Player {

	public Knight() {
		setHealth(50);
	}

	@Override
	public int attack(Dice dice) {
		return dice.nextInt(10);
	}
}
