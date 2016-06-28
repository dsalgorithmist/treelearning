/**
 * 
 */
package blogspot.gopal.util;

import blogspot.gopal.nodes.TTNode;

/**
 * @author Gopal
 *
 */
public class TernaryTreeCreator {

	public static TTNode getInitializedTernaryTree() {
		TTNode root = new TTNode();
		root.setData(30);
	
		TTNode left = new TTNode();
		left.setData(5);
	
		TTNode middle = new TTNode();
		middle.setData(11);
	
		TTNode right = new TTNode();
		right.setData(63);
	
		root.setLeft(left);
		root.setMiddle(middle);
		root.setRight(right);
	
		TTNode left1 = new TTNode();
		left1.setData(1);
	
		TTNode middle1 = new TTNode();
		middle1.setData(4);
	
		TTNode right1 = new TTNode();
		right1.setData(8);
	
		left.setLeft(left1);
		left.setMiddle(middle1);
		left.setRight(right1);
	
		TTNode left2 = new TTNode();
		left2.setData(6);
	
		TTNode middle2 = new TTNode();
		middle2.setData(7);
	
		TTNode right2 = new TTNode();
		right2.setData(15);
	
		middle.setLeft(left2);
		middle.setMiddle(middle2);
		middle.setRight(right2);
	
		TTNode left3 = new TTNode();
		left3.setData(31);
	
		TTNode middle3 = new TTNode();
		middle3.setData(55);
	
		TTNode right3 = new TTNode();
		right3.setData(65);
	
		right.setLeft(left3);
		right.setMiddle(middle3);
		right.setRight(right3);
	
		return root;
	}

}
