package samples.labyrinth;


import java.util.List;

public class Labyrinth {

	public static final char TILE_WALL = '@';
	public static final char TILE_SPACE = ' ';

	private List<String> rows;
	private Position playerPosition;

	/**
	 * Creates a Labyrinth from a list of strings.
	 * The {@link Labyrinth#TILE_WALL} represent the walls.
	 * The {@link Labyrinth#TILE_SPACE} are ways where the player can move around.
	 * The map must be a rectangle (all map lines have the same length).
	 */
	public Labyrinth(List<String> rows) {
		this.rows = rows;
	}

	public Position getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(Position playerPosition) {
		this.playerPosition = playerPosition;
	}

	/**
	 * Says if player is outside of map.
	 * Don't call if you have not set the player position yet.
	 */
	public boolean isPlayerOutsideOfMap() {

		if (playerPosition == null) {
			throw new IllegalStateException("You have not set the player position yet!");
		}

		return isOutsideOfMap(playerPosition);
	}

	/**
	 * Moves the player to the given direction.
	 * If the player can't move to that direction, the player doesn't move.
	 */
	public void movePlayer(Direction direction) {

		final Position destination;

		// Get coordinates just to make the expressions below shorter
		final int x = playerPosition.getX();
		final int y = playerPosition.getY();

		if (direction == Direction.LEFT) {
			destination = new Position(x - 1, y);
		} else if (direction == Direction.RIGHT) {
			destination = new Position(x + 1, y);
		} else if (direction == Direction.UP) {
			destination = new Position(x, y - 1);
		} else if (direction == Direction.DOWN) {
			destination = new Position(x, y + 1);
		} else {
			// Note: This `else` helps the Java compiler, because there's no way we can
			// exit this `if` statement without setting destination.
			// Try removing this `else` and see the error that the compiler shows.
			throw new IllegalArgumentException("unexpected direction: " + direction);
		}

		if (isOutsideOfMap(destination)) {

			playerPosition = destination;

		} else {

			// Note: We only check destination tile if the destination is not outside of map.
			// Otherwise we would get an OutOfBoundsException because we will get a position
			// that doesn't exist in the map

			char destTile = rows.get(destination.getY()).charAt(destination.getX());

			if (destTile != TILE_WALL) {
				playerPosition = destination;
			}
		}
	}

	/** Returns true if the given position is outside of the map rectangle */
	private boolean isOutsideOfMap(Position pos) {
		return
			pos.getX() < 0 || pos.getX() >= getMapWidth() ||
			pos.getY() < 0 || pos.getY() >= getMapHeight();
	}


	// Note: These are convenience methods to make it clear that we're getting the map size

	private int getMapHeight() {
		return rows.size();
	}

	private int getMapWidth() {
		return rows.get(0).length();
	}
}
