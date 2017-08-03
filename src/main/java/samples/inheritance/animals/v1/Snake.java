package samples.inheritance.animals.v1;

public class Snake extends Animal {

	public boolean poisonous;

	public void bite() {
		String withOrWithout = poisonous ? "with" : "without";
		System.out.println(this.name + " biting " + withOrWithout + " poison!");
	}
}
