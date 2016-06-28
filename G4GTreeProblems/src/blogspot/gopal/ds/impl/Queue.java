/**
 * 
 */
package blogspot.gopal.ds.impl;

import blogspot.gopal.ds.ILinkedList;
import blogspot.gopal.ds.IQueue;

/**
 * @author Gopal
 *
 */
public class Queue<T> implements IQueue<T> {

	private ILinkedList<T> linkedList;

	public Queue() {
		linkedList = new LinkedList<T>();
	}

	@Override
	public void push(T data) {
		linkedList.addNode(data);
	}

	@Override
	public T pop() {
		if (linkedList.size() <= 0) {
			return null;
		}
		return linkedList.removeNodeFromBeginning();
	}

	@Override
	public int size() {
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.size() == 0;
	}

}
