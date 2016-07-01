/**
 * 
 */
package blogspot.gopal.problems;

import java.util.ArrayList;
import java.util.List;

import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.BinarySearchTreeCreator;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author I073456
 *
 */
public class G4GP9BSTToBalancedBST {

	private static BTNode<Integer> head = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root = BinarySearchTreeCreator
				.getBinarySearchTree(new Integer[] { 20, 15, 12, 25, 3, 4, 6, 7, 22, 27, 30, 35, 40, 5 });
		BetterBTreePrinter.printNode(root);

		convertToBalancedBST(root);
	}

	private static BTNode<Integer> convertToBalancedBST(BTNode<Integer> root) {
		if (root == null) {
			return null;
		}
		getSortedNodes(root);
		traverseSortedLinkedList();

		BTNode<Integer> newRoot = createBalancedBSTFromList();
		return newRoot;
	}

	private static BTNode<Integer> createBalancedBSTFromList() {
		BTNode<Integer> mid = findMid(head);
		System.out.println("Mid node is : ");
		printNodeDetails(mid);

		List<BTNode<Integer>> nodesFromTree = populateNodeList();
		nodesFromTree.remove(mid);
		createBST(mid, nodesFromTree);
		return mid;
	}

	private static List<BTNode<Integer>> populateNodeList() {
		List<BTNode<Integer>> nodesFromTree = new ArrayList<BTNode<Integer>>();
		if (head == null) {
			return nodesFromTree;
		}
		BTNode<Integer> temp = head;
		while (temp.getRight() != null) {
			BTNode<Integer> currentNode = temp;
			temp = temp.getRight();
			currentNode.setLeft(null);
			currentNode.setRight(null);
			nodesFromTree.add(currentNode);
		}
		return nodesFromTree;
	}

	private static void createBST(BTNode<Integer> rootNode, List<BTNode<Integer>> nodesFromTree) {
		// TODO : Fill this one.
	}

	private static BTNode<Integer> findMid(BTNode<Integer> root) {
		BTNode<Integer> slow = root, fast = root;
		while (fast != null) {
			fast = fast.getRight();
			if (fast != null) {
				fast = fast.getRight();
			}
			if (fast != null) {
				slow = slow.getRight();
			}
		}
		return slow;
	}

	private static void traverseSortedLinkedList() {
		if (head == null) {
			return;
		}
		BTNode<Integer> temp = head;
		while (temp.getRight() != null) {
			printNodeDetails(temp);
			temp = temp.getRight();
		}
	}

	private static void printNodeDetails(BTNode<Integer> node) {
		System.out.println("Data : " + node.getData());
		// System.out.println("Node : " + node);
		// System.out.println("Left : " + node.getLeft());
		// System.out.println("Right : " + node.getRight());
	}

	private static void getSortedNodes(BTNode<Integer> root) {
		traverseReverseInorder(root);
	}

	private static void traverseReverseInorder(BTNode<Integer> root) {
		if (root == null) {
			return;
		}
		traverseReverseInorder(root.getRight());
		if (head == null) {
			head = root;
		} else {
			root.setRight(head);
			head = root;
		}
		traverseReverseInorder(root.getLeft());
	}

}
