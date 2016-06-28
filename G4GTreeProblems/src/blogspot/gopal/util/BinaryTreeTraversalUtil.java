/**
 * 
 */
package blogspot.gopal.util;

import blogspot.gopal.nodes.BTNode;

/**
 * @author Gopal
 *
 */
public class BinaryTreeTraversalUtil {

	public static <T> void preOrderTraversal(BTNode<T> root) {
		System.out.println("Traversing Binary Tree in Pre Order....");
		
		preOrderInternal(root);
		
		System.out.println("Traversal Completed....");
	}

	private static <T> void preOrderInternal(BTNode<T> root) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData());
		preOrderInternal(root.getLeft());
		preOrderInternal(root.getRight());
	}

	public static <T> void inOrderTraversal(BTNode<T> root) {
		System.out.println("Traversing Binary Tree in In Order....");
		inOrderInternal(root);
		System.out.println("Traversal Completed....");
	}

	private static <T> void inOrderInternal(BTNode<T> root) {
		if (root == null) {
			return;
		}
		inOrderInternal(root.getLeft());
		System.out.println(root.getData());
		inOrderInternal(root.getRight());
	}

	public static <T> void postOrderTraversal(BTNode<T> root) {
		System.out.println("Traversing Binary Tree in Post Order....");
		postOrderInternal(root);
		System.out.println("Traversal Completed....");
	}

	private static <T> void postOrderInternal(BTNode<T> root) {
		if (root == null) {
			return;
		}
		postOrderInternal(root.getLeft());
		postOrderInternal(root.getRight());
		System.out.println(root.getData());
	}

}
