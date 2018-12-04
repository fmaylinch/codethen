package samples;

import java.util.Scanner;

/** Example of reading from keyboard, to ask data to the user */
public class ScannerExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Tell me your name: ");
		String name = scanner.next();

		System.out.print("Tell me your age: ");
		int age = Integer.parseInt( scanner.next() );

		System.out.print("Tell me your height in meters: ");
		double height = Double.parseDouble( scanner.next() );

		System.out.println(name + ", " + age + " years, " + (height * 100) + " cm");

		if (age >= 18) {
			System.out.println("you are an adult");
		} else if (age >= 13 ) {
			System.out.println("you're a teenager");
		} else {
			System.out.println("you're a kid");
		}
	}
}
