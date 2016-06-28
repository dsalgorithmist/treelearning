/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.BinaryTreeCreator;
import blogspot.gopal.util.BinaryTreeTraversalUtil;

/**
 * @author Gopal
 *
 */
public class G4GP2TwoDTreePrinting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinaryTreeCreator.getBinaryTree();
		BinaryTreeTraversalUtil.preOrderTraversal(root);

		twoDimentionalPrinting(root);
	}

	private static void twoDimentionalPrinting(BTNode<Integer> root) {
		if (root == null) {
			return;
		}
		twoDimentionalPrinting(root.getRight());
		System.out.println(root.getData());
		twoDimentionalPrinting(root.getLeft());
	}

}
