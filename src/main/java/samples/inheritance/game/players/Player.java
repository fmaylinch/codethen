package samples.inheritance.game.players;

import samples.inheritance.game.Entity;

/**
 * Notes:
 * An abstract class:
 * - May have abstract methods (i.e. not implemented).
 * - Can't be instantiated (can't do `new Player()`).
 * - It's meant to be extended (e.g. `class Rat extends Player`)
 */
public abstract class Player implements Entity {

	private int health;

	public Player() {
		this.health = 10;
	}

	public boolean isAlive() {
		return this.health > 0;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public abstract int attack();

	public void receiveHit(int hit) {
		this.health -= hit;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + health + ")";
	}
}
