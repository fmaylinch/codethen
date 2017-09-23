package samples.generics;

import java.util.Arrays;
import java.util.List;

public class GenericExample {

	public static void main(String[] args) {

		System.out.println("--- Simple example of a class with generic type ---");

		Box<Integer> b1 = new Box<>(10);
		System.out.println( "box b1 has: " + b1.getValue() );
		b1.setValue(20);
		System.out.println( "box b1 has: " + b1.getValue() );

		Box<String> b2 = new Box<>("hello");
		System.out.println( "box b2 has: " + b2.getValue() );
		b2.setValue("bye");
		System.out.println( "box b2 has: " + b2.getValue() );


		System.out.println("--- Using our stringMap() function (NOT generic) ---");

		List<String> animals = Arrays.asList("cat", "horse", "dog");
		System.out.println("Animals: " + animals);

		// We use stringMap to transform each animal to uppercase.
		// We create an instance of StringFunction to "pass the function".
		// This is called an "anonymous class".
		List<String> uppercased = FunctionUtil.stringMap(animals, new StringFunction() {
			@Override
			public String apply(String word) {
				return word.toUpperCase();
			}
		});
		System.out.println("Animals (uppercased): " + uppercased);

		// Here we do the same but using a lambda instead of anonymous class
		List<String> uppercased2 = FunctionUtil.stringMap(animals, word -> word.toUpperCase());
		System.out.println("Animals (uppercased): " + uppercased2);


		System.out.println("--- Using our generic map() function ---");

		// Similar to before, but we use map() which takes a Function
		List<String> uppercased3 = FunctionUtil.map(animals, new Function<String, String>() {
			@Override
			public String apply(String word) {
				return word.toUpperCase();
			}
		});
		System.out.println("Animals (uppercased): " + uppercased3);

		// Here we do the same but using a lambda instead of anonymous class
		List<String> uppercased4 = FunctionUtil.map(animals, word -> word.toUpperCase());
		System.out.println("Animals (uppercased): " + uppercased4);


		// The good thing of the generic map() is that it can be used
		// with any input and output type, like taking string and returning int

		List<Integer> lengths = FunctionUtil.map(animals, new Function<String, Integer>() {
			@Override
			public Integer apply(String word) {
				return word.length();
			}
		});
		System.out.println("Lengths: " + lengths);

		List<Integer> lengths2 = FunctionUtil.map(animals, word -> word.length());
		System.out.println("Lengths: " + lengths2);
	}
}
