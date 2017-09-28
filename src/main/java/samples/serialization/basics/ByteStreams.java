package samples.serialization.basics;

import samples.serialization.Util;

import java.io.*;

/**
 * Streams represent low-level (bytes, zeros and ones) data transfer.
 * In this example we copy (read/write) an image file, byte by byte.
 */
public class ByteStreams {

	public static void main(String[] args) throws IOException {

		InputStream in; // input, for reading data (bytes, zeros and ones)
		OutputStream out; // output, for writing data

		String inputFilePath = Util.baseFolder + "/code-then.jpg";
		String outputFilePath = Util.baseFolder + "/code-then-copy.jpg";

		in = new FileInputStream(inputFilePath);
		out = new FileOutputStream(outputFilePath);

		int b = in.read();

		while (b != -1) { // read() returns -1 when there are no more bytes to read
			out.write(b);
			b = in.read();
		}

		in.close();
		out.close();

		System.out.println("File `" + outputFilePath + "` created");
	}
}
