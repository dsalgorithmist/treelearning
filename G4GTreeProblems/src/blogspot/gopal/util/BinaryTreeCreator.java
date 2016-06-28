/**
 * 
 */
package blogspot.gopal.util;

import blogspot.gopal.nodes.BTNode;

/**
 * @author Gopal
 *
 */
public class BinaryTreeCreator {

	public static BTNode<Integer> getBinaryTree() {
		return getBinaryTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
	}

	public static BTNode<Integer> getBinaryTree(Integer[] elements) {
		BTNode<Integer> root = new BTNode<Integer>();
		root.setData(elements[0]);

		createAndLinkChildren(root, elements[1], elements[2]);
		createAndLinkChildren(root.getLeft(), elements[3], elements[4]);
		createAndLinkChildren(root.getRight(), elements[5], elements[6]);

		return root;
	}

	private static void createAndLinkChildren(BTNode<Integer> parent,
			Integer leftData, Integer rightData) {
		BTNode<Integer> left = new BTNode<Integer>();
		left.setData(leftData);

		BTNode<Integer> right = new BTNode<Integer>();
		right.setData(rightData);

		parent.setLeft(left);
		parent.setRight(right);
	}

}
