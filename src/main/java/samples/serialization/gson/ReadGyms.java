package samples.serialization.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import samples.serialization.Util;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Reads gyms from file (in JSON format).
 */
public class ReadGyms {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		FileReader reader = new FileReader(Util.baseFolder + "/gyms.json");

		Gson gson = new Gson();
		// This type is used to tell Gson how to convert JSON string to objects
		Type type = new TypeToken<List<Gym>>(){}.getType();
		// Use Gson to read JSON and convert it to a list of gyms
		List<Gym> gyms = gson.fromJson(reader, type);

		reader.close();

		// Display the gyms (those that are visible)
		for (Gym gym : gyms) {
			if (gym.isVisible()) {
				System.out.println( gym.getName() + ": " + gym.getPrice() + "€");
			}
		}
	}
}
