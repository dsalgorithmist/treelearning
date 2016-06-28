/**
 * 
 */
package blogspot.gopal.ds;

import blogspot.gopal.nodes.BTNode;

/**
 * @author Gopal
 *
 */
public interface IBinaryTree<T> {

	public BTNode<T> getRootNode();

	public void addNode(T data);

	public void deleteNode(T data);

}
