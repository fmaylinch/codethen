package samples.inheritance.animals.v1;

public class Bird extends Animal {

	public int maxHeight;

	public void fly(int height) {
		final int actualHeight = Math.min(height, maxHeight);
		System.out.println(this.name + " flying at " + actualHeight + " meters high!");
	}
}
