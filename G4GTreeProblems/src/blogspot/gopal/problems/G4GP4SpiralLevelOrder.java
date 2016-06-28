/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.ds.IDEQueue;
import blogspot.gopal.ds.impl.DEQueue;
import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class G4GP4SpiralLevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
						15, 16, 17, 18, 19 }, new Integer[] { 8, 10, 13, 14 });
		BetterBTreePrinter.printNode(root);

		spiralOrderTraversal(root);
	}

	private static void spiralOrderTraversal(BTNode<Integer> root) {
		if (root == null) {
			return;
		}
		IDEQueue<BTNode<Integer>> queue = new DEQueue<BTNode<Integer>>();
		int level = 1;
		addEntryToQueue(queue, root, level);
		while (!queue.isEmpty()) {
			BTNode<Integer> popped = queue.pop();
			System.out.println(popped.getData());
			level++;
			BTNode<Integer> left = popped.getLeft();
			BTNode<Integer> right = popped.getRight();
			if (left != null) {
				addEntryToQueue(queue, left, level);
			}
			if (right != null) {
				addEntryToQueue(queue, right, level);
			}
		}
	}

	private static void addEntryToQueue(IDEQueue<BTNode<Integer>> queue,
			BTNode<Integer> node, int level) {
		if ((level % 2) == 0) {
			queue.pushAtBeginning(node);
		} else {
			queue.pushAtEnd(node);
		}
	}

}
