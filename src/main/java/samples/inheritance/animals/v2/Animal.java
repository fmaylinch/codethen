package samples.inheritance.animals.v2;

public class Animal {

	private String name;
	private int numLegs;

	public void walk() {
		System.out.println(this.name + " walking with " + this.numLegs + " legs");
	}

	// Getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumLegs() {
		return numLegs;
	}

	public void setNumLegs(int numLegs) {
		this.numLegs = numLegs;
	}
}
