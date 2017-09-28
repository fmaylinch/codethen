package samples;

import java.util.Scanner;

/** Example of reading from keyboard, to ask data to the user */
public class ScannerExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Tell me your name: ");
		String name = scanner.next();

		System.out.print("And your age: ");
		int age = scanner.nextInt();

		if (age >= 18) {
			System.out.println(name + ", you are an adult");
		} else if (age >= 13 ) {
			System.out.println(name + ", you're a teenager");
		} else {
			System.out.println(name + ", you're a kid");
		}
	}
}
