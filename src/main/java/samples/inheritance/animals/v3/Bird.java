package samples.inheritance.animals.v3;

public class Bird extends Animal {

	private final int maxHeight;

	public Bird(String name, int maxHeight) {
		super(name, 2);
		this.maxHeight = maxHeight;
	}

	public void fly(int height) {
		final int actualHeight = Math.min(height, maxHeight);
		System.out.println(this.getName() + " flying at " + actualHeight + " meters high!");
	}

	// Getters

	public int getMaxHeight() {
		return maxHeight;
	}
}
