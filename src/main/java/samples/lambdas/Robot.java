package samples.lambdas;

public class Robot {

	private final String name;

	public Robot(String name) {
		this.name = name;
	}


	public void performAction(Action action, boolean execute) {
		if (execute) {
			action.perform();
		}
	}
}
