package samples.inheritance.animals.v1;

public class Animal {

	public String name;
	public int numLegs;

	public void walk() {
		System.out.println(this.name + " walking with " + this.numLegs + " legs");
	}
}
