package samples.algorithms.skyscan;

import java.util.*;

public class Solution2 {

	/**
	 * Map of employees by name.
	 *
	 * This map represents a tree where we just store the relationship of
	 * each employee with its manager (each node has a pointer to its parent node).
	 */
	private final static Map<String, Employee> employees = new HashMap<>();


	public static void main(String args[] ) throws Exception {

		final Scanner sky = new Scanner(
			"6\nHilary\nJames\nSarah Fred\nSarah Paul\nFred Hilary\nFred Jenny\nJenny James");
		final int n = Integer.parseInt(sky.nextLine());

		final String employee1 = sky.nextLine();
		final String employee2 = sky.nextLine();

		fillEmployees(sky);

		sky.close();

		Employee manager = findLowestCommonManager(employee1, employee2);

		System.out.println(manager.name);
	}

	/**
	 * Reads relationships from input and
	 * builds a "tree" of relationships in employees map.
	 */
	private static void fillEmployees(Scanner sky) {

		while (sky.hasNextLine()) {

			final String[] relationship = sky.nextLine().split(" ");
			final String manager = relationship[0];
			final String subordinate = relationship[1];

			if (!employees.containsKey(manager)) {
				employees.put(manager, new Employee(manager, null));
			}

			if (!employees.containsKey(subordinate)) {
				employees.put(subordinate, new Employee(subordinate, employees.get(manager)));
			}
		}
	}

	private static Employee findLowestCommonManager(String employee1, String employee2) {

		if (employee1.equals(employee2)) {
			return employees.get(employee1);
		}

		final List<Employee> managers1 = managerLine(employee1);
		final List<Employee> managers2 = managerLine(employee2);

		final int minSize = Math.min(managers1.size(), managers2.size());

		int i = 0;
		while (i < minSize && managers1.get(i) == managers2.get(i)) {
	        i++;
		}

		return managers1.get(i-1);
	}

	/**
	 * Returns a list of managers for the given employee,
	 * sorted from the top manager to the employee.
	 */
	private static List<Employee> managerLine(String employee) {

		ArrayList<Employee> result = new ArrayList<>();

		Employee e = employees.get(employee);
		result.add(e);

		while (e.manager != null) {
			e = e.manager;
			result.add(e);
		}

		Collections.reverse(result);

		return result;
	}

	private static class Employee {

		Employee(String name, Employee manager) {
			this.name = name;
			this.manager = manager;
		}

		final String name;
		final Employee manager;

		@Override
		public String toString() {
			return name;
		}
	}
}