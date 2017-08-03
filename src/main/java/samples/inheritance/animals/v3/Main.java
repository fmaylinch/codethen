package samples.inheritance.animals.v3;

/**
 * In this version, we add constructors.
 * We remove all setters.
 */
public class Main {

	public static void main(String[] args) {

		Bird bird = new Bird("eagle", 1000);
		bird.walk();
		bird.fly(500);

		Snake snake = new Snake("cobra", true);
		snake.walk();
		snake.bite();
	}
}
