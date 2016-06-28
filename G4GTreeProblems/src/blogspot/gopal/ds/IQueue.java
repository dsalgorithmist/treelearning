/**
 * 
 */
package blogspot.gopal.ds;

/**
 * @author Gopal
 *
 */
public interface IQueue<T> {

	public void push(T data);

	public T pop();

	public int size();
	
	public boolean isEmpty();

}
