/**
 * 
 */
package blogspot.gopal.ds;

/**
 * @author Gopal
 *
 */
public interface IStack<T> {

	public void push(T data);

	public T pop();

	public boolean isEmpty();

}
