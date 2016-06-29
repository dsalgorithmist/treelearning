/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.ds.IQueue;
import blogspot.gopal.ds.impl.Queue;
import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BTreePrinter;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class G4GP7DiagonalTraversalUsingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root1 = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 8, 3, 10, 1, 6, -1, 14, -2, -3, 4, 7, -4, -5,
						13 }, new Integer[] { -2, -3, -4, -5, -1 });
		executeOnDataSet(root1);

	}

	private static void executeOnDataSet(BTNode<Integer> root) {
		BetterBTreePrinter.printNode(root);
		BTreePrinter.printNode(root);
		diagonalPrint(root);
	}

	private static void diagonalPrint(BTNode<Integer> root) {
		if (root == null) {
			return;
		}
		IQueue<BTNode<Integer>> queue = new Queue<BTNode<Integer>>();
		queue.push(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				BTNode<Integer> temp = queue.pop();
				while (temp != null) {
					System.out.println(temp.getData());
					if (temp.getLeft() != null)
						queue.push(temp.getLeft());
					temp = temp.getRight();
				}
				size--;
			}
		}
	}
}
