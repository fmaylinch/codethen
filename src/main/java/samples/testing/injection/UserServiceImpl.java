package samples.testing.injection;

import java.util.Random;

public class UserServiceImpl implements UserService {

	@Override
	public User findByName(String name) {

		// Simulate (randomly) that users may exist or not in the database
		Random rnd = new Random();
		boolean exists = rnd.nextBoolean();

		if (exists) {
			return new User(name, rnd.nextInt(100));
		} else {
			return null;
		}
	}
}
