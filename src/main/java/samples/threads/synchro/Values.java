package samples.threads.synchro;

import java.util.ArrayList;
import java.util.List;

public class Values {

	private List<Integer> numbers;

	public Values() {
		numbers = new ArrayList<>();
	}

	public void addValue(int x) {
		numbers.add(x);
	}

	public boolean isEmpty() {
		return numbers.isEmpty();
	}

	public int retrieveValue() {
		int value = numbers.get(0);
		numbers.remove(0);
		return value;
	}
}
