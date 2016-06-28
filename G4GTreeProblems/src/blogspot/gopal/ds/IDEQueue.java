/**
 * 
 */
package blogspot.gopal.ds;

/**
 * @author Gopal
 *
 */
public interface IDEQueue<T> {

	public void pushAtBeginning(T data);

	public void pushAtEnd(T data);

	public T pop();

	public Integer size();

	public boolean isEmpty();

}
