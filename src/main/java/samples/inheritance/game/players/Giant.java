package samples.inheritance.game.players;

import samples.inheritance.game.dice.Dice;

public class Giant extends Player {

	private boolean vulnerable;

	public Giant() {
		this.vulnerable = false;
	}

	@Override
	public int attack(Dice dice) {

		if (dice.nextInt(3) == 0) {
			this.vulnerable = true;
			return dice.nextInt(3) + 4;
		} else {
			this.vulnerable = false;
			return 0;
		}
	}

	@Override
	public void receiveHit(int hit, Dice dice) {
		super.receiveHit(vulnerable ? hit*2 : hit/2, dice);
	}
}
