package samples.kotlin;

/**
 * Example of using Kotlin class from Java
 */
public class KotlinFromJava {

	public static void main(String[] args) {

		final KotlinPerson person = new KotlinPerson("Jed", 30);
		person.setLastName("Bruins");
		System.out.println(person.fullName());
	}
}
