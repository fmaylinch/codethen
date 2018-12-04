package samples.serialization.gson;

import com.google.gson.Gson;
import samples.serialization.Util;

import java.io.FileReader;
import java.io.IOException;

/**
 * Reads gyms from file (in JSON format).
 */
public class ReadGyms {

	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader(Util.baseFolder + "/gyms.json");

		Gson gson = new Gson();

		// Use Gson to read JSON and convert it to a GymList object
		GymList gymList = gson.fromJson(reader, GymList.class);

		reader.close();

		// Display the gyms (those that are visible)
		for (Gym gym : gymList.getGyms()) {
			if (gym.isVisible()) {
				System.out.println( gym.getName() + ": " + gym.getPrice() + "€");
			}
		}
	}
}
