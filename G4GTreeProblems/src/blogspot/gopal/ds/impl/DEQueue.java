/**
 * 
 */
package blogspot.gopal.ds.impl;

import blogspot.gopal.ds.IDEQueue;
import blogspot.gopal.ds.ILinkedList;

/**
 * @author Gopal
 *
 */
public class DEQueue<T> implements IDEQueue<T> {

	private ILinkedList<T> linkedList;

	public DEQueue() {
		this.linkedList = new LinkedList<T>();
	}

	@Override
	public void pushAtBeginning(T data) {
		linkedList.addNodeAtBeginning(data);
	}

	@Override
	public void pushAtEnd(T data) {
		linkedList.addNode(data);
	}

	@Override
	public T pop() {
		T data = null;
		if (!linkedList.isEmpty()) {
			data = linkedList.removeNodeFromBeginning();
		}
		return data;
	}

	@Override
	public Integer size() {
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

}
