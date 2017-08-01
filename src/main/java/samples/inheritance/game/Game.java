package samples.inheritance.game;

import samples.inheritance.game.players.*;

import java.util.Random;

public class Game {

	private final Random random;

	public Game() {
		random = new Random();
	}

	public void start() {

		Knight knight = new Knight();
		int numEnemies = 3;

		System.out.println("Game starts. The knight will fight " + numEnemies + " enemies!");

		for (int i = 0; i < numEnemies && knight.isAlive(); i++) {

			// We could declare enemy as Entity too
			Player enemy = nextEnemy();

			fight(knight, enemy);
		}

		if (knight.isAlive()) {
			System.out.println("The knight wins!!! :D");
		} else {
			System.out.println("Poor knight was killed... X-O");
		}
	}

	/** Performs a fight between 2 entities while both are alive */
	private void fight(Entity p1, Entity p2) {

		System.out.println("--- " + p1 + " vs " + p2 + " ... fight! ---");

		while (p1.isAlive() && p2.isAlive()) {

			int a1 = p1.attack();
			int a2 = p2.attack();

			System.out.println(p1 + " hits " + a1 + ", " + p2 + " hits " + a2);

			p1.receiveHit(a2);
			p2.receiveHit(a1);

			// waitMillis(1000);
		}

		System.out.println(p1 + ", " + p2);
	}

	/** Pauses the program for a while */
	private void waitMillis(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// never happens
		}
	}

	/** Generates a random enemy */
	private Player nextEnemy() {

		int num = random.nextInt(3);

		switch (num) {
			case 0: return new Rat();
			case 1: return new Skeleton();
			case 2: return new Zombie();
			default: throw new RuntimeException("unexpected!");
		}

		/* The switch statement above is equivalent to:

		if (num == 0) {
			return new Rat();
		} else if (num == 1) {
			return new Skeleton();
		} else if (num == 2) {
			return new Zombie();
		} else {
			throw new RuntimeException("unexpected!");
		}
		*/
	}
}
