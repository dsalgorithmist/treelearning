/**
 * 
 */
package blogspot.gopal.util;

import blogspot.gopal.nodes.DLLNode;

/**
 * @author Gopal
 *
 */
public class DLLTraversalUtil {

	public static void traverseDoublyLinkedList(DLLNode node) {
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}

}
