/**
 * 
 */
package blogspot.gopal.nodes;

/**
 * @author Gopal
 *
 */
public class LLNode<T> {

	private T data;

	private LLNode<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LLNode<T> getNext() {
		return next;
	}

	public void setNext(LLNode<T> next) {
		this.next = next;
	}

}
