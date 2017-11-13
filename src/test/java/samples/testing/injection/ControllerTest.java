package samples.testing.injection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ControllerTest {

	private UserService userServiceMock;
	private Controller controller;

	@Before
	public void prepareMocks() {
		userServiceMock = Mockito.mock(UserService.class);
		controller = new Controller(userServiceMock);
	}

	@Test
	public void testAgeOfUserFound() {

		// I need this service to behave in a certain way...
		Mockito.when(userServiceMock.findByName("mary")).thenReturn(new User("mary", 15));

		// ...so we can test the class we're testing in this unit test
		assertEquals(15, controller.findUserAge("mary"));
	}

	@Test
	public void testAgeOfUserNotFound() {

		Mockito.when(userServiceMock.findByName(Mockito.anyString())).thenReturn(null);

		assertEquals(-1, controller.findUserAge("peter"));
	}
}