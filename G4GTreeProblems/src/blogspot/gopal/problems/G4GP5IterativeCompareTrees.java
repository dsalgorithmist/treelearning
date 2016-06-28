/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.ds.IQueue;
import blogspot.gopal.ds.impl.Queue;
import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class G4GP5IterativeCompareTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root1 = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
						15, 16, 17, 18, 19 }, new Integer[] { 8, 10, 13, 14 });
		BetterBTreePrinter.printNode(root1);
		BTNode<Integer> root2 = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
						15, 16, 17, 18, 19 },
				new Integer[] { 8, 10, 13, 14, 19 });
		BetterBTreePrinter.printNode(root2);

		boolean result = areTreesIdentical(root1, root2);
		System.out.println("root1, root2 : " + result);
	}

	private static boolean areTreesIdentical(BTNode<Integer> root1,
			BTNode<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		IQueue<BTNode<Integer>> queue1 = new Queue<BTNode<Integer>>();
		IQueue<BTNode<Integer>> queue2 = new Queue<BTNode<Integer>>();

		queue1.push(root1);
		queue2.push(root2);

		while (!(queue1.isEmpty() && queue2.isEmpty())) {
			BTNode<Integer> popped1 = queue1.pop();
			BTNode<Integer> popped2 = queue2.pop();
			if (popped1 != popped2) {
				return false;
			}
		}
		return false;
	}

}
