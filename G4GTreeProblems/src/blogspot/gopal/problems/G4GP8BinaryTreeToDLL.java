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
	
	// 'head' - reference to head node of created
	// double linked list
	private static BTNode<Integer> head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 8, 3, 10, 1, 6, 100, 14, -2, -3, 4, 7, -4, -5,
						13 }, new Integer[] { -2, -3, -4, -5 });
		BetterBTreePrinter.printNode(root);
		BTreePrinter.printNode(root);
		
		BToDLL(root);
		printList(head);
	}


	static void BToDLL(BTNode<Integer> root) {
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.getRight());

		// insert root into DLL
		root.setRight(head);

		// Change left pointer of previous head
		if (head != null)
			head.setLeft(root);

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.getLeft());
	}

	static void printList(BTNode<Integer> head) {
		System.out.println("Extracted Double Linked List is : ");
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.getRight();
		}
	}

}
