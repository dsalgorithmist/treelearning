/**
 * 
 */
package blogspot.gopal.ds.impl;

import blogspot.gopal.ds.ILinkedList;
import blogspot.gopal.ds.IStack;

/**
 * @author Gopal
 *
 */
public class Stack<T> implements IStack<T> {

	private ILinkedList<T> linkedList;

	public Stack() {
		linkedList = new LinkedList<T>();
	}

	@Override
	public void push(T data) {
		linkedList.addNode(data);
	}

	@Override
	public T pop() {
		if (linkedList.isEmpty()) {
			return null;
		}
		T data = linkedList.removeNodeFromLast();
		return data;
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

}
