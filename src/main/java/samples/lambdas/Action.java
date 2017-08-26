package samples.lambdas;

/** Represents an action that can be performed */
@FunctionalInterface
public interface Action {

	/** Performs the action */
	void perform();
}
