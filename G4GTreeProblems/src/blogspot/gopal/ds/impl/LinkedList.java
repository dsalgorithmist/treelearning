/**
 * 
 */
package blogspot.gopal.ds.impl;

import blogspot.gopal.ds.ILinkedList;
import blogspot.gopal.nodes.LLNode;

/**
 * @author Gopal
 *
 */
public class LinkedList<T> implements ILinkedList<T> {

	private LLNode<T> head;

	private int size = 0;

	@Override
	public void addNode(T data) {
		LLNode<T> newNode = new LLNode<T>();
		newNode.setData(data);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		LLNode<T> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		size++;
	}

	@Override
	public void addNodeAtBeginning(T data) {
		LLNode<T> newNode = new LLNode<T>();
		newNode.setData(data);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		newNode.setNext(head);
		head = newNode;
		size++;
	}

	@Override
	public T removeNodeFromBeginning() {
		if (head == null) {
			return null;
		}
		T data = head.getData();
		head = head.getNext();
		size--;
		return data;
	}

	@Override
	public T removeNodeFromLast() {
		if (head == null) {
			return null;
		}
		LLNode<T> temp = head, prev = head;
		while (temp.getNext() != null) {
			prev = temp;
			temp = temp.getNext();
		}
		T data = temp.getData();
		if (prev == head) {
			head = null;
		} else {
			prev.setNext(null);
		}
		size--;
		return data;
	}

	@Override
	public LLNode<T> getHeader() {
		return head;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

}
