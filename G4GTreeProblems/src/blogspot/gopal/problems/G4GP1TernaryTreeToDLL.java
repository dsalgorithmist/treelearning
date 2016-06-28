/**
 * 
 */
package blogspot.gopal.problems;

import blogspot.gopal.nodes.DLLNode;
import blogspot.gopal.nodes.TTNode;
import blogspot.gopal.util.DLLTraversalUtil;
import blogspot.gopal.util.TernaryTreeCreator;
import blogspot.gopal.util.TernaryTreeInOrderTraversalUtil;

/**
 * @author Gopal
 *
 */
public class G4GP1TernaryTreeToDLL {

	private static DLLNode dNode = null;

	private static DLLNode lastModifiedDNode = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TTNode root = TernaryTreeCreator.getInitializedTernaryTree();
		TernaryTreeInOrderTraversalUtil.traverseTernaryTreeInPreOrder(root);

		convertTTToDLL(root);

		System.out.println(dNode);
		DLLTraversalUtil.traverseDoublyLinkedList(dNode);
	}

	private static void convertTTToDLL(TTNode root) {
		if (root == null) {
			return;
		}

		DLLNode newDLLNode = new DLLNode();
		newDLLNode.setData(root.getData());

		if (dNode == null) {
			dNode = newDLLNode;
		} else {
			lastModifiedDNode.setNext(newDLLNode);
			newDLLNode.setPrev(lastModifiedDNode);
		}
		lastModifiedDNode = newDLLNode;

		convertTTToDLL(root.getLeft());
		convertTTToDLL(root.getMiddle());
		convertTTToDLL(root.getRight());

	}

}
