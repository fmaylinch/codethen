package samples.inheritance.game.players;

import java.util.Random;

public class Skeleton extends Player {

	private Random random;

	public Skeleton() {
		this.random = new Random();
	}

	@Override
	public int attack() {
		return random.nextInt(3) + 2;
	}

	@Override
	public void receiveHit(int hit) {
		if (hit > 2) {
			super.receiveHit(hit);
		}
	}
}
