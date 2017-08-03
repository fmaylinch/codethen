package samples.inheritance.animals.v3;

public class Animal {

	private final String name;
	private final int numLegs;

	public Animal(String name, int numLegs) {
		this.name = name;
		this.numLegs = numLegs;
	}

	public void walk() {
		System.out.println(this.name + " walking with " + this.numLegs + " legs");
	}

	// Getters

	public String getName() {
		return name;
	}

	public int getNumLegs() {
		return numLegs;
	}
}
