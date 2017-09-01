package samples.labyrinth;

import java.util.Arrays;
import java.util.List;

public class LabyrinthTest {

	public static void main(String[] args) {

		testMovePlayer();
		testMovePlayerMultipleTimes();
		testEscape();

		System.out.println("Tests OK!");
	}

	public static void testMovePlayer() {

		List<String> map = Arrays.asList(
			"XXXXXXX",
			"XX XX  ",
			"XX o  X",
			"XXXXXXX"
		);

		LabyrinthReader labyrinthReader = new LabyrinthReader();
		Labyrinth labyrinth = labyrinthReader.build(map);

		labyrinth.movePlayer(Direction.RIGHT);

		Position playerPosition = labyrinth.getPlayerPosition();
		TestUtil.assertEquals(playerPosition.getX(), 4);
		TestUtil.assertEquals(playerPosition.getY(), 2);
		TestUtil.assertEquals(labyrinth.isPlayerOutsideOfMap(), false);
	}

	public static void testMovePlayerMultipleTimes() {

		List<String> map = Arrays.asList(
			"X XXXXX",
			"X XX XX",
			"X    XX",
			"XX XX X",
			"XX  o X",
			"XXXXXXX"
		);

		// Note: we can inline the LabyrinthReader variable
		Labyrinth labyrinth = new LabyrinthReader().build(map);

		labyrinth.movePlayer(Direction.LEFT);
		labyrinth.movePlayer(Direction.LEFT);
		labyrinth.movePlayer(Direction.LEFT);
		labyrinth.movePlayer(Direction.UP);
		labyrinth.movePlayer(Direction.UP);
		labyrinth.movePlayer(Direction.UP);
		labyrinth.movePlayer(Direction.RIGHT);

		Position playerPosition = labyrinth.getPlayerPosition();
		TestUtil.assertEquals(playerPosition.getX(), 3);
		TestUtil.assertEquals(playerPosition.getY(), 2);
		TestUtil.assertEquals(labyrinth.isPlayerOutsideOfMap(), false);
	}

	public static void testEscape() {

		List<String> map = Arrays.asList(
			"XXXXXXX",
			"XX XXoX",
			"XX    X",
			"XX XXXX"
		);

		Labyrinth labyrinth = new LabyrinthReader().build(map);

		labyrinth.movePlayer(Direction.DOWN);
		labyrinth.movePlayer(Direction.LEFT);
		labyrinth.movePlayer(Direction.LEFT);
		labyrinth.movePlayer(Direction.LEFT);
		labyrinth.movePlayer(Direction.DOWN);
		labyrinth.movePlayer(Direction.DOWN);

		Position playerPosition = labyrinth.getPlayerPosition();
		TestUtil.assertEquals(playerPosition.getX(), 2);
		TestUtil.assertEquals(playerPosition.getY(), 4);
		TestUtil.assertEquals(labyrinth.isPlayerOutsideOfMap(), true);
	}
}
