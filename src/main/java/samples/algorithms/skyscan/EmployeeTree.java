package samples.algorithms.skyscan;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class EmployeeTree {

	public static void main(String[] args) {

		String input =
			"sarah roger" + "\n" +
			"sarah susan" + "\n" +
			"roger mark" + "\n" +
			"roger tom" + "\n" +
			"tom larry" + "\n" +
			"susan john" + "\n" +
			"susan warren";

		Scanner sky = new Scanner(input);

		TreeManager treeManager = new TreeManager("sarah");

		while (sky.hasNextLine()) {

			String line = sky.nextLine().trim();

			if (!Objects.equals(line, "")) {
				String[] names = line.split(" ");
				treeManager.addRelationship(names[0], names[1]);
			}
		}

		System.out.println( treeManager.rootNode.toString(0) );

		System.out.println();

		System.out.println( treeManager.ancestors("tom") );;
	}

	private static class TreeManager {

		Map<String, TreeNode> nodes = new HashMap<>();
		TreeNode rootNode;

		TreeManager(String root) {
			rootNode = new TreeNode(root, null, null, null);;
			nodes.put(root, rootNode);
		}

		void addRelationship(String parent, String child) {

			if (nodes.containsKey(child)) {
				throw new IllegalArgumentException("Child $child was already added");
			}
			TreeNode parentNode = nodes.get(parent);

			TreeNode childNode = new TreeNode(child, parentNode, null, null);
			nodes.put(child, childNode);

			if (parentNode.left == null) parentNode.left = childNode;
			else if (parentNode.right == null) parentNode.right = childNode;
			else throw new IllegalArgumentException("Parent $parent already has 2 children");
		}

		List<String> ancestors(String value) {

			List<String> result = new ArrayList<>();
			result.add(value);

			TreeNode node = nodes.get(value);

			while (node.parent != null) {
				node = node.parent;
				result.add(node.value);
			}

			return result;
		}
	}

	static class TreeNode {

		String value;
		TreeNode parent;
		TreeNode left;
		TreeNode right;

		public TreeNode(String value, TreeNode parent, TreeNode left, TreeNode right) {
			this.value = value;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		String toString(int indent) {

			String leftStr = left != null ? left.toString(indent+2) : "";
			String rightStr = right != null ? right.toString(indent+2) : "";

			return "\n" + StringUtils.repeat(" ", indent) + value + leftStr + rightStr;
		}
	}
}
