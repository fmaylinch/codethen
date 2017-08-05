package samples.inheritance.game.players;

import samples.inheritance.game.dice.Dice;

public class Skeleton extends Player {

	@Override
	public int attack(Dice dice) {
		return dice.nextInt(3) + 2;
	}

	@Override
	public void receiveHit(int hit, Dice dice) {
		if (hit > 2) {
			super.receiveHit(hit, dice);
		}
	}
}
