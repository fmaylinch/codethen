package samples.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Functional utilities.
 *
 * For example: map, filter, reduce, etc.
 */
public class FunctionUtil {

	/**
	 * Takes a list of strings and generates another by
	 * applying the given function to each element.
	 *
	 * Note: this is limited to string lists, see {@link #map} for a generic version.
	 */
	public static List<String> stringMap(List<String> list, StringFunction f) {

		List<String> result = new ArrayList<>();

		for (String elem : list) {
			String modified = f.apply(elem);
			result.add(modified);
		}

		return result;
	}

	/**
	 * Takes a list and generates another by
	 * applying the given function to each element.
	 *
	 * This function is generic because the input and output types
	 * are not fixed; they can be specified when using the function.
	 */
	public static <In, Out> List<Out> map(List<In> list, Function<In, Out> f) {

		List<Out> result = new ArrayList<>();

		for (In elem : list) {
			Out modified = f.apply(elem);
			result.add(modified);
		}

		return result;
	}
}
