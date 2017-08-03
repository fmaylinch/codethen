package samples.inheritance.animals.v2;

public class Main {

	public static void main(String[] args) {

		Bird bird = new Bird();
		bird.setName("eagle");
		bird.setNumLegs(2);
		bird.setMaxHeight(1000);
		bird.walk();
		bird.fly(500);

		Snake snake = new Snake();
		snake.setName("cobra");
		snake.setNumLegs(0);
		snake.setPoisonous(true);
		snake.walk();
		snake.bite();
	}
}
