package samples.serialization.basics;

import samples.serialization.Util;

import java.io.*;

/**
 * Reader/Writer represent character-level (strings) data transfer.
 * In this example we copy a text file, character by character.
 */
public class CharacterStreams {

	public static void main(String[] args) throws IOException {

		Reader reader; // input, for reading characters (strings)
		Writer writer; // output, for writing characters

		String inputFilePath = Util.baseFolder + "/input.txt";
		String outputFilePath = Util.baseFolder + "/output.txt";

		reader = new FileReader(inputFilePath);
		writer = new FileWriter(outputFilePath);

		int b = reader.read();

		while (b != -1) { // read() returns -1 when there are no more bytes to read
			writer.write(b);
			b = reader.read();
		}

		reader.close();
		writer.close();

		System.out.println("File `" + outputFilePath + "` created");
	}
}
