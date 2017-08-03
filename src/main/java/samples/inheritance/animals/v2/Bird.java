package samples.inheritance.animals.v2;

public class Bird extends Animal {

	private int maxHeight;

	public void fly(int height) {
		final int actualHeight = Math.min(height, maxHeight);
		System.out.println(this.getName() + " flying at " + actualHeight + " meters high!");
	}

	// Getters and setters

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
}
