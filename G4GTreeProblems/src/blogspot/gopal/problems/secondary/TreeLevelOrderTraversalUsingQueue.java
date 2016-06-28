/**
 * 
 */
package blogspot.gopal.problems.secondary;

import blogspot.gopal.ds.IQueue;
import blogspot.gopal.ds.impl.Queue;
import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class TreeLevelOrderTraversalUsingQueue {

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
		if (root == null) {
			return;
		}
		IQueue<BTNode<Integer>> queue = new Queue<BTNode<Integer>>();
		queue.push(root);
		queue.push(null);
		while (!queue.isEmpty()) {
			BTNode<Integer> popped = queue.pop();
			if (popped == null) {
				if (queue.isEmpty()) {
					break;
				} else {
					System.out.println("Level Changed...");
					queue.push(null);
				}
			} else {
				System.out.println(popped.getData());
				BTNode<Integer> left = popped.getLeft();
				if (left != null) {
					queue.push(left);
				}
				BTNode<Integer> right = popped.getRight();
				if (right != null) {
					queue.push(right);
				}
			}
		}
	}
}
