package samples.serialization.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import samples.serialization.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Writes a couple of gyms to a file in JSON format.
 */
public class WriteGyms {

	public static void main(String[] args) throws IOException {

		final List<Gym> gyms = new ArrayList<>();
		gyms.add(new Gym("Accura Bruc", 7.0));
		gyms.add(new Gym("Verneda", 5.0));
		gyms.add(new Gym("Maresme", 7.0)); // we can "inline" the object creation
		gyms.add(new Gym("Duet", 6.0));

		gyms.get(2).setVisible(false); // just set one gym to invisible

		GymList gymList = new GymList(gyms);

		//Gson gson = new Gson();
		// With pretty printing, the resulting JSON is more readable
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Convert gyms to a string in JSON format
		String json = gson.toJson(gymList);

		// Display json on screen (just to see how it looks)
		System.out.println(json);

		// Write JSON to file
		FileWriter writer = new FileWriter(Util.baseFolder + "/gyms.json");
		writer.write(json);
		writer.close();

		System.out.println("Gyms written to JSON file");
	}
}
