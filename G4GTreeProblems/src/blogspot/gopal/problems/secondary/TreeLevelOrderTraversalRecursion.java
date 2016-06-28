/**
 * 
 */
package blogspot.gopal.problems.secondary;

import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class TreeLevelOrderTraversalRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
						15, 16, 17, 18, 19 }, new Integer[] { 8, 10, 13, 14 });
		BetterBTreePrinter.printNode(root);
		traverseLevelOrder(root);
	}

	private static void traverseLevelOrder(BTNode<Integer> root) {
		int height = findHeight(root);
		System.out.println("Height : " + height);
		for (int i = 0; i < height; i++) {
			printNodesAtHeight(root, i);
		}
	}

	private static void printNodesAtHeight(BTNode<Integer> root, int height) {
		if (root == null) {
			return;
		}
		printNodesAtHeightInternal(root, 0, height);
	}

	private static void printNodesAtHeightInternal(BTNode<Integer> root,
			int currentHeight, int height) {
		if (root == null) {
			return;
		}
		if (currentHeight == height) {
			System.out.println(root.getData());
		}
		printNodesAtHeightInternal(root.getLeft(), (currentHeight + 1), height);
		printNodesAtHeightInternal(root.getRight(), (currentHeight + 1), height);
	}

	private static int findHeight(BTNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		BTNode<Integer> left = root.getLeft();
		BTNode<Integer> right = root.getRight();
		return (1 + Math.max(findHeight(left), findHeight(right)));
	}
}
