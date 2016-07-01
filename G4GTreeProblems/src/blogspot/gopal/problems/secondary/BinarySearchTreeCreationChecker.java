/**
 * 
 */
package blogspot.gopal.problems.secondary;

import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.BinarySearchTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author I073456
 *
 */
public class BinarySearchTreeCreationChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinarySearchTreeCreator.getBinarySearchTree(new Integer[] { 10, 2, 12, 5, 14, 25 });
		BetterBTreePrinter.printNode(root);
	}

}
