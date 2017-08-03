package samples.inheritance.animals.v2;

public class Snake extends Animal {

	private boolean poisonous;

	public void bite() {
		String withOrWithout = poisonous ? "with" : "without";
		System.out.println(this.getName() + " biting " + withOrWithout + " poison!");
	}

	// Getters and setters

	// Note that the Java convention for boolean getters is not
	// "getSomeField" but "isSomeField".
	public boolean isPoisonous() {
		return poisonous;
	}

	public void setPoisonous(boolean poisonous) {
		this.poisonous = poisonous;
	}
}
