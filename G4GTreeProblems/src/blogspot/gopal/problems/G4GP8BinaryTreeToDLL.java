/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BTreePrinter;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author I073456
 *
 */
public class G4GP8BinaryTreeToDLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 8, 3, 10, 1, 6, 100, 14, -2, -3, 4, 7, -4, -5, 13 }, new Integer[] { -2, -3, -4, -5 });
		BetterBTreePrinter.printNode(root);
		BTreePrinter.printNode(root);
		convertToDLL(root);
	}

	private static void convertToDLL(BTNode<Integer> root) {
		convertToDLLInternal(root, null);
	}

	private static void convertToDLLInternal(BTNode<Integer> node, BTNode<Integer> parentNode) {
		if (node == null) {
			return;
		}
		if (node.getLeft() != null) {
			convertToDLLInternal(node.getLeft(), node);
		}
		if (parentNode != null) {
			System.out.println("Visiting : " + node.getData());
			boolean isLeftNode = parentNode.getLeft() == node;
			if (isLeftNode) {
				node.setLeft(parentNode);
				parentNode.setRight(node);
			} else {
				node.setRight(parentNode);
			}
		} else {
			BTNode<Integer> tempLeft = node.getLeft();
			BTNode<Integer> tempRight = node.getRight();
			if (tempLeft != null) {
				tempLeft.setLeft(node);
				node.setRight(tempLeft);
			}
			if (tempRight != null) {
				tempRight.setRight(node);
			}
		}
		if (node.getRight() != null) {
			convertToDLLInternal(node.getRight(), node);
		}
	}

}
