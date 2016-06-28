/**
 * 
 */
package blogspot.gopal.util.dynamic;

import blogspot.gopal.ds.IBinaryTree;
import blogspot.gopal.ds.impl.BinaryTree;
import blogspot.gopal.nodes.BTNode;

/**
 * @author Gopal
 *
 */
public class BinaryTreeCreator {

	public static BTNode<Integer> createBinaryTree(Integer[] allNodes,
			Integer[] nodesToBeDeleted) {
		IBinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		for (Integer nodeData : allNodes) {
			binaryTree.addNode(nodeData);
		}
		for (Integer nodeData : nodesToBeDeleted) {
			binaryTree.deleteNode(nodeData);
		}
		BTNode<Integer> rootNode = binaryTree.getRootNode();
		return rootNode;
	}

}
