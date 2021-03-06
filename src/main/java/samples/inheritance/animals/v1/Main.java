package samples.inheritance.animals.v1;

/**
 * Simple inheritance example.
 * All fields are public.
 */
public class Main {

	public static void main(String[] args) {

		Bird bird = new Bird();
		bird.name = "eagle";
		bird.numLegs = 2;
		bird.maxHeight = 1000;
		bird.walk();
		bird.fly(500);

		Snake snake = new Snake();
		snake.name = "cobra";
		snake.numLegs = 0;
		snake.poisonous = true;
		snake.walk();
		snake.bite();
	}
}
