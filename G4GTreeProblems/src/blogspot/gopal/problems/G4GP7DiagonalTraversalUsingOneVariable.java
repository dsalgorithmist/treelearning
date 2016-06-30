/**
 * 
 */
package blogspot.gopal.problems;

import java.util.ArrayList;
import java.util.Arrays;
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
public class G4GP7DiagonalTraversalUsingOneVariable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode<Integer> root1 = BinaryTreeCreator.createBinaryTree(
				new Integer[] { 8, 3, 10, 1, 6, 100, 14, -2, -3, 4, 7, -4, -5, 13 },
				new Integer[] { -2, -3, -4, -5 });
		executeOnDataSet(root1);

	}

	private static void executeOnDataSet(BTNode<Integer> root) {
		BetterBTreePrinter.printNode(root);
		BTreePrinter.printNode(root);
		Map<Integer, List<Integer>> result = new TreeMap<Integer, List<Integer>>();
		diagonalPrint(root, 0, result);
		printResult(result);
	}

	private static void printResult(Map<Integer, List<Integer>> result) {
		for (Entry<Integer, List<Integer>> entry : result.entrySet()) {
			System.out.println("For Diagonal Number : " + entry.getKey() + " , values are : "
					+ Arrays.toString(entry.getValue().toArray()));
		}
	}

	private static void diagonalPrint(BTNode<Integer> root, Integer diagonalNumber,
			Map<Integer, List<Integer>> result) {
		if (root == null) {
			return;
		}
		if (root.getLeft() != null) {
			diagonalPrint(root.getLeft(), (diagonalNumber + 1), result);
		}
		putDataToMap(root, diagonalNumber, result);
		if (root.getRight() != null) {
			diagonalPrint(root.getRight(), (diagonalNumber), result);
		}
	}

	private static void putDataToMap(BTNode<Integer> root, Integer diagonalNumber, Map<Integer, List<Integer>> result) {
		List<Integer> numberOnSameDiagonal = result.get(diagonalNumber);
		if (numberOnSameDiagonal == null) {
			numberOnSameDiagonal = new ArrayList<Integer>();
			result.put(diagonalNumber, numberOnSameDiagonal);
		}
		numberOnSameDiagonal.add(root.getData());
	}
}
