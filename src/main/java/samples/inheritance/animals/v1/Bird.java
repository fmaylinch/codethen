package samples.inheritance.animals.v1;

public class Bird extends Animal {

	public int maxHeight;

	public void fly() {
		System.out.println(this.name + " flying at " + maxHeight + " meters high!");
	}
}
