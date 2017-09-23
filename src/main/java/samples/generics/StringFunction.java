package samples.generics;

/**
 * In Java we can't pass functions by parameter in Java,
 * but we can simulate it using an interface.
 *
 * If the interface has only one method, it can be used with lambdas ("arrow functions").
 *
 * Note this function is limited to taking one String and returning another.
 * See {@link Function} for a generic version that can take any input and output type.
 */
@FunctionalInterface
interface StringFunction {
	String apply(String arg);
}