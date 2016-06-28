/**
 * 
 */
package blogspot.gopal.ds.impl;

import blogspot.gopal.ds.IBinaryTree;
import blogspot.gopal.ds.IQueue;
import blogspot.gopal.nodes.BTNode;

/**
 * @author Gopal
 *
 */
public class BinaryTree<T> implements IBinaryTree<T> {

	private BTNode<T> root;

	@Override
	public BTNode<T> getRootNode() {
		return root;
	}

	@Override
	public void addNode(T data) {
		BTNode<T> newNode = new BTNode<T>();
		newNode.setData(data);
		if (root == null) {
			root = newNode;
			return;
		}
		insertNodeAtLastLocation(newNode);
	}

	private void insertNodeAtLastLocation(BTNode<T> newNode) {
		if (root == null) {
			root = newNode;
			return;
		}
		IQueue<BTNode<T>> queue = new Queue<BTNode<T>>();
		queue.push(root);
		while (!queue.isEmpty()) {
			BTNode<T> popped = queue.pop();
			BTNode<T> left = popped.getLeft();
			BTNode<T> right = popped.getRight();

			if (left == null) {
				popped.setLeft(newNode);
				break;
			}

			if (right == null) {
				popped.setRight(newNode);
				break;
			}

			queue.push(left);
			queue.push(right);
		}
	}

	@Override
	public void deleteNode(T data) {
		if (root == null) {
			return;
		}
		deleteNodeInternal(null, root, data);
	}

	private void deleteNodeInternal(BTNode<T> parentNode, BTNode<T> node, T data) {
		if (node == null) {
			return;
		}
		if (node.getData() == data) {
			deleteCurrentNode(parentNode, node);
			return;
		}
		deleteNodeInternal(node, node.getLeft(), data);
		deleteNodeInternal(node, node.getRight(), data);
	}

	private void deleteCurrentNode(BTNode<T> parentNode, BTNode<T> node) {
		if (node == null) {
			return;
		}
		BTNode<T> left = node.getLeft();
		BTNode<T> right = node.getRight();
		if (left == null && right == null) {
			if (parentNode == null) {
				root = null;
			} else {
				if (parentNode.getLeft() == node) {
					parentNode.setLeft(null);
				} else {
					parentNode.setRight(null);
				}
			}
			return;
		} else {
			if (left != null) {
				node.setData(left.getData());
				deleteCurrentNode(node, left);
			} else {
				node.setData(right.getData());
				deleteCurrentNode(node, right);
			}
		}
	}
}
