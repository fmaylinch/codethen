package samples.generics;

/**
 * A {@link Box} contains a value of type {@link T}.
 *
 * @param <T> this is the generic type, which will be specified when creating the {@link Box} instance.
 */
public class Box<T> {

	private T value;

	public Box(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
