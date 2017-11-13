package samples.testing.injection;

public class RealApplication {

	public static void main(String[] args) {

		// In the real project we inject the real UserServiceImpl.
		// In tests, we will inject a "mock" UserService (see ControllerTest).
		UserService userService = new UserServiceImpl();
		Controller controller = new Controller(userService);
	}
}
