/**
 * 
 */
package blogspot.gopal.ds;

import blogspot.gopal.nodes.LLNode;

/**
 * @author Gopal
 *
 */
public interface ILinkedList<T> {

	public void addNode(T data);
	
	public void addNodeAtBeginning(T data);

	public T removeNodeFromBeginning();

	public T removeNodeFromLast();
	
	public LLNode<T> getHeader();
	
	public int size();
	
	public boolean isEmpty();
}
