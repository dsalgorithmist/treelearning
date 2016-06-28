/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.BinaryTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class G4GP3SinkOddNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinaryTreeCreator.getBinaryTree(new Integer[] { 1, 5, 8,
				2, 4, 9, 10 });
		BetterBTreePrinter.printNode(root);
		sinkOddNode(root);
		BetterBTreePrinter.printNode(root);
	}

	private static void sinkOddNode(BTNode<Integer> root) {
		if (root == null) {
			return;
		}
		if (!isEvenNode(root)) {
			BTNode<Integer> left = root.getLeft();
			if (left != null && isEvenNode(left)) {
				swapDataOfNodes(root, left);
			} else {
				BTNode<Integer> right = root.getRight();
				if (right != null) {
					if (isEvenNode(right)) {
						swapDataOfNodes(root, right);
					}
				}
			}
		}
		sinkOddNode(root.getLeft());
		sinkOddNode(root.getRight());
	}
	
	private static void swapDataOfNodes(BTNode<Integer> nodeOne, BTNode<Integer> nodeTwo) {
		int temp = nodeOne.getData();
		nodeOne.setData(nodeTwo.getData());
		nodeTwo.setData(temp);
	}

	private static boolean isEvenNode(BTNode<Integer> node) {
		return (node.getData() % 2 == 0);
	}
}
