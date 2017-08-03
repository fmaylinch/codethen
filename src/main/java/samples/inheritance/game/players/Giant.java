package samples.inheritance.game.players;

import java.util.Random;

public class Giant extends Player {

	private Random random;
	private boolean vulnerable;

	public Giant() {
		this.random = new Random();
		this.vulnerable = false;
	}

	@Override
	public int attack() {

		if (random.nextInt(3) == 0) {
			this.vulnerable = true;
			return random.nextInt(3) + 4;
		} else {
			this.vulnerable = false;
			return 0;
		}
	}

	@Override
	public void receiveHit(int hit) {
		super.receiveHit(vulnerable ? hit*2 : hit/2);
	}
}
