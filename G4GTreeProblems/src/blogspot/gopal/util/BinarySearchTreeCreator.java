package blogspot.gopal.util;

import blogspot.gopal.nodes.BTNode;

public class BinarySearchTreeCreator {

	public static <T> BTNode<T> getBinarySearchTree(T[] elements) {
		if (elements == null || elements.length == 0) {
			return null;
		}
		BTNode<T> root = new BTNode<T>();
		root.setData(elements[0]);
		if (elements.length == 1) {
			return root;
		}
		for (int i = 1; i < elements.length; i++) {
			BTNode<T> newNode = new BTNode<T>();
			newNode.setData(elements[i]);
			insertNodeToBST(root, newNode);
		}
		return root;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> void insertNodeToBST(BTNode<T> root, BTNode<T> newNode) {
		if (root == null) {
			return;
		}
		T currentData = root.getData();
		Comparable<Comparable> currentDataValue = (Comparable<Comparable>) currentData;
		Comparable dataToBeInsertedValue = (Comparable) newNode.getData();
		if (currentDataValue.compareTo(dataToBeInsertedValue) <= 0) {
			if (root.getRight() == null) {
				root.setRight(newNode);
			} else {
				insertNodeToBST(root.getRight(), newNode);
			}
		} else {
			if (root.getLeft() == null) {
				root.setLeft(newNode);
			} else {
				insertNodeToBST(root.getLeft(), newNode);
			}
		}
	}

}
