package samples.inheritance.animals.v3;

public class Snake extends Animal {

	private final boolean poisonous;

	public Snake(String name, boolean poisonous) {
		super(name, 0);
		this.poisonous = poisonous;
	}

	public void bite() {
		String withOrWithout = poisonous ? "with" : "without";
		System.out.println(this.getName() + " biting " + withOrWithout + " poison!");
	}

	// Getters

	public boolean isPoisonous() {
		return poisonous;
	}
}
