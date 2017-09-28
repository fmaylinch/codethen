package samples.serialization.java;

import samples.serialization.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Reads gyms from file (in some binary format written by ObjectOutputStream).
 */
public class ReadGyms {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Read from file
		FileInputStream fis = new FileInputStream(Util.baseFolder + "/gyms.data");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Cast to List<Gym> will work if we really saved that type of data.
		// Be careful with casts (only do it when you're sure).
		@SuppressWarnings("unchecked")
		List<Gym> gyms = (List<Gym>) ois.readObject();

		ois.close(); // will close `fis` too

		// Display the gyms (those that are visible)
		for (Gym gym : gyms) {
			if (gym.isVisible()) {
				System.out.println( gym.getName() + ": " + gym.getPrice() + "€");
			}
		}
	}
}
