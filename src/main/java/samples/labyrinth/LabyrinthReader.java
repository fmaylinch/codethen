package samples.labyrinth;

import java.util.List;

/**
 * Builds a Labyrinth from different sources.
 */
public class LabyrinthReader {

	// Note: `static final` is for constants in Java
	public static final char TILE_PLAYER = '·';

	/**
	 * Builds a Labyrinth from a list of strings.
	 * It must follow the constraints specified in {@link Labyrinth(List)} constructor.
	 * The map must also contain a special {@link #TILE_PLAYER} that represents
	 * the starting point of the player.
	 */
	public Labyrinth build(List<String> map) {

		Position startPosition = extractPlayerPosition(map);

		Labyrinth labyrinth = new Labyrinth(map);
		labyrinth.setPlayerPosition(startPosition);

		return labyrinth;
	}

	/**
	 * Extracts the player position in the map.
	 * Removes the player from the map.
	 */
	private Position extractPlayerPosition(List<String> map) {

		for (int i = 0; i < map.size(); i++) {
			int index = map.get(i).indexOf(TILE_PLAYER);
			if (index >= 0) {
				Position startPosition = new Position(index, i);
				// Remove player from map
				String rowWithoutPlayer = map.get(i).replace(TILE_PLAYER, Labyrinth.TILE_SPACE);
				map.set(i, rowWithoutPlayer);
				return startPosition;
			}
		}

		throw new IllegalArgumentException("the map doesn't contain the player starting point");
	}
}
