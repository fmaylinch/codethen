package samples.inheritance.game;

import samples.inheritance.game.dice.FakeDice;
import samples.inheritance.game.players.Giant;
import samples.inheritance.game.players.Knight;

public class GameTest {

	public static void main(String[] args) {

		testGiant();

		System.out.println("tests passed!");
	}

	private static void testGiant() {

		Knight knight = new Knight();
		Giant giant = new Giant();

		FakeDice dice = new FakeDice(new int[] { 6, 0, 2,  2, 1 });
		Game game = new Game(dice);
		game.fightTurn(knight, giant);

		assertEquals(giant.getHealth(), 7);
		assertEquals(knight.getHealth(), 44);

		game.fightTurn(knight, giant);

		assertEquals(giant.getHealth(), 3);
		assertEquals(knight.getHealth(), 44);
	}


	static void assertEquals(Object actual, Object expected) {
		if (!actual.equals(expected)) {
			throw new RuntimeException("actual " + actual + " is not equals to expected " + expected);
		}
	}
}
