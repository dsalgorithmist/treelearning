/**
 * 
 */
package blogspot.gopal.util;

import blogspot.gopal.nodes.TTNode;

/**
 * @author Gopal
 *
 */
public class TernaryTreeInOrderTraversalUtil {

	public static void traverseTernaryTreeInPreOrder(TTNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData());
		traverseTernaryTreeInPreOrder(root.getLeft());
		traverseTernaryTreeInPreOrder(root.getMiddle());
		traverseTernaryTreeInPreOrder(root.getRight());
	}

}
