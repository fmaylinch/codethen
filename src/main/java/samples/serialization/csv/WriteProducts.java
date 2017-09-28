package samples.serialization.csv;

import samples.serialization.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * This program asks the user for a list of products and writes
 * them into a CSV file (products.csv).
 */
public class WriteProducts {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Give me the products");

		Writer writer = new FileWriter(Util.baseFolder + "/products.csv");
		writer.write("Name,Price\n");

		System.out.print("Product name (enter 'stop' to finish): ");
		String name = scanner.next();

		while ( !name.equals("stop") ) {

			System.out.print("Product price: ");
			double price = scanner.nextDouble();

			writer.write(name + "," + price + "\n");

			System.out.print("Product name (enter 'stop' to finish): ");
			name = scanner.next();
		}

		writer.close();
	}
}
