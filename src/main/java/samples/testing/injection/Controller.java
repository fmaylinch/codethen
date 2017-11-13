package samples.testing.injection;

public class Controller {

	private UserService userService;

	public Controller(UserService userService) {
		this.userService = userService;
	}

	/** Returns age of user or -1 if not found */
	public int findUserAge(String name) {

		User user = userService.findByName(name);
		if (user != null) {
			return user.getAge();
		} else {
			return -1;
		}
	}
}
