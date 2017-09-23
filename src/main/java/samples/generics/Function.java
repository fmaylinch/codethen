package samples.generics;

/**
 * In Java we can't pass functions by parameter in Java,
 * but we can simulate it using an interface.
 *
 * If the interface has only one method, it can be used with lambdas ("arrow functions").
 *
 * Note this interface is generic,
 * so the {@link Arg} and {@link Return} types can be specified as needed.
 */
@FunctionalInterface
interface Function<Arg, Return> {
	Return apply(Arg arg);
}