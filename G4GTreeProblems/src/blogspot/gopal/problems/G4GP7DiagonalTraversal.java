/**
 * 
 */
package blogspot.gopal.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import blogspot.gopal.nodes.BTNode;
import blogspot.gopal.util.dynamic.BinaryTreeCreator;
import blogspot.gopal.util.visual.BTreePrinter;
import blogspot.gopal.util.visual.BetterBTreePrinter;

/**
 * @author Gopal
 *
 */
public class G4GP7DiagonalTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root1 = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 8, 3, 10, 1, 6, -1, 14, -2, -3, 4, 7, -4,-5 ,13},
				new Integer[] {-2, -3 , -4, -5, -1});
		executeOnDataSet(root1);

		BTNode<Integer> root2 = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
						15, 16, 17, 18, 19 }, new Integer[] {});
		executeOnDataSet(root2);
	}

	private static void executeOnDataSet(BTNode<Integer> root) {
		BetterBTreePrinter.printNode(root);
		BTreePrinter.printNode(root);
		printTreeDiagonally(root);
	}

	private static void printTreeDiagonally(BTNode<Integer> root) {
		if (root == null) {
			return;
		}

		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
		Map<Integer, List<BTNode<Integer>>> resultMap = new TreeMap<Integer, List<BTNode<Integer>>>(
				comparator);
		printTreeDiagonallyRec(root, 0, 0, resultMap);

		for (Entry<Integer, List<BTNode<Integer>>> entry : resultMap.entrySet()) {
			Integer integerValue = entry.getKey();
			List<BTNode<Integer>> nodeList = entry.getValue();
			System.out.println("Connected node to integer value : "
					+ integerValue + " are : ");
			for (BTNode<Integer> node : nodeList) {
				System.out.println(node.getData());
			}
		}
	}

	private static void printTreeDiagonallyRec(BTNode<Integer> node,
			int xValue, int yValue,
			Map<Integer, List<BTNode<Integer>>> resultMap) {
		if (node == null) {
			return;
		}

		int diff = xValue + yValue;
		putIntoResultMap(diff, node, resultMap);

		if (node.getRight() != null) {
			printTreeDiagonallyRec(node.getRight(), xValue + 1, yValue - 1,
					resultMap);
		}
		if (node.getLeft() != null) {
			printTreeDiagonallyRec(node.getLeft(), xValue - 1, yValue - 1,
					resultMap);
		}
	}

	private static void putIntoResultMap(int diff, BTNode<Integer> node,
			Map<Integer, List<BTNode<Integer>>> resultMap) {
		List<BTNode<Integer>> nodeList = resultMap.get(diff);
		if (nodeList == null) {
			nodeList = new ArrayList<BTNode<Integer>>();
			resultMap.put(diff, nodeList);
		}
		nodeList.add(node);
	}

}
