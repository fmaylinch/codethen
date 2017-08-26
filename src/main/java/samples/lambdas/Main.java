package samples.lambdas;

/**
 * Example of how to "pass functions" as arguments in Java.
 *
 * In Java you can't do that actually, but you can do something
 * similar if you pass an object made from a {@link FunctionalInterface}
 * (i.e. an interface with only one method).
 *
 * From Java 8 you can even pass a lambda function, so the code is
 * much shorter and it looks like you're passing a function (although
 * a lambda is just a short form of passing an object that implements
 * the interface that the parameter requires).
 */
public class Main {

	public static void main(String[] args) {

		Robot chuck = new Robot("chuck");

		// Using a class
		Action action1 = new ExampleAction();

		// Using anonymous class (we could turn this into a lambda)
		Action action2 = new Action() {
			@Override
			public void perform() {
				System.out.println("anonymous action!");

			}
		};

		// Using lambda
		// Notice curly braces { } are not needed if there's only
		// one statement in the lambda function.
		Action action3 = () -> System.out.println("lambda action!");

		chuck.performAction(action1, true);
		chuck.performAction(action2, true);
		chuck.performAction(action3, true);
	}

}

class ExampleAction implements Action {

	@Override
	public void perform() {
		System.out.println("class action!");
	}
}
