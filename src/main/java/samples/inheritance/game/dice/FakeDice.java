package samples.inheritance.game.dice;

/** Fake dice for testing, where the numbers it produces are given. */
public class FakeDice implements Dice {

	private final int[] fakedNumbers;
	private int index;

	public FakeDice(int[] fakedNumbers) {
		this.fakedNumbers = fakedNumbers;
		this.index = 0;
	}

	@Override
	public int nextInt(int n) {
		return fakedNumbers[index++];
	}
}
