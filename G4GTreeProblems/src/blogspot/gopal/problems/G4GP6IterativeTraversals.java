/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.ds.IStack;
import blogspot.gopal.ds.impl.Stack;
import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class G4GP6IterativeTraversals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
						15, 16, 17, 18, 19 }, new Integer[] { 8, 10, 13, 14 });
		BetterBTreePrinter.printNode(root);

		iterativePreOrderTraversal(root);
		iterativeInOrderTraversal(root);
		iterativePostOrderTraversal(root);
	}

	private static void iterativePreOrderTraversal(BTNode<Integer> root) {
		System.out.println("Pre Order : ");
		if (root == null) {
			return;
		}
		IStack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BTNode<Integer> popped = stack.pop();
			System.out.println(popped.getData());
			BTNode<Integer> left = popped.getLeft();
			BTNode<Integer> right = popped.getRight();
			if (right != null) {
				stack.push(right);
			}
			if (left != null) {
				stack.push(left);
			}
		}
	}

	private static void iterativeInOrderTraversal(BTNode<Integer> root) {
		System.out.println("In Order : ");
		if (root == null) {
			return;
		}
		IStack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();
		BTNode<Integer> temp = root;
		stack.push(temp);
		while (!stack.isEmpty()) {
			BTNode<Integer> left = temp.getLeft();
			if (left != null) {
				stack.push(left);
				temp = left;
			} else {
				temp = stack.pop();
				System.out.println(temp.getData());
				BTNode<Integer> right = temp.getRight();
				if (right != null) {
					stack.push(right);
					temp = right;
				}
			}
		}
	}

	private static void iterativePostOrderTraversal(BTNode<Integer> root) {
		System.out.println("Post Order : ");
		if (root == null) {
			return;
		}
		IStack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();
		BTNode<Integer> temp = root;
		stack.push(temp);
		while (!stack.isEmpty()) {
			BTNode<Integer> left = temp.getLeft();
			BTNode<Integer> right = temp.getRight();
			if (right != null) {
				stack.push(right);
				temp = temp.getRight();
			}
			if (left != null) {
				stack.push(right);
				temp = temp.getLeft();
			}
		}
	}

}
