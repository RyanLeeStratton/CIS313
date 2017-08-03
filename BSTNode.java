/**
 * Ryan Stratton
 * 
 * CIS313 lab 2 
 *
 * BSTNode for Library driver program.
 *
 */

//this class provides a link list node for use with 
//the library driver and BST classes.
public class BSTNode{

private String Top;
private BSTNode left = null;
private BSTNode right = null;
	
	//constructor setting up the string for the top.
	public BSTNode(String book_name){
			
		Top = book_name;
	}
	
	//sets the value of the left node.
	public void set_left(BSTNode book_name_left){
		left = book_name_left;	
	}
	
	//sets the value of the right node.
	public void set_right(BSTNode book_name_right){
		right = book_name_right;
	}

	//gets the string stored in top.
	public String get_top(){
		return Top;
	}

	//returns the node stored in the left.
	public BSTNode get_left(){
		return left;
	}
	
	//returns the node stored in right.
	public BSTNode get_right(){
		return right;
	}

	//returns the length of the string stored in top.
	public int length(){
		return Top.length();
	}

}
