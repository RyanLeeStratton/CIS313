/**
 * Ryan Stratton
 * CIS313 lab 2 
 *
 * BST function for library driver program.
 *
 */

//controls the insert, find and removal methods.
//uses a string length comparison for sorting the books
//into a binary array, I understand that string length isn't the 
//best system to use for sorting but it was good enough for a 
//small data set.
public class BST{

	private BSTNode top = null;

	public BST(){
	
	}

	public BST(BSTNode top_entry){
		this.top = top_entry;
	}
	
	//controls inserting the book into the library.
	public int insert(String book){
		BSTNode temp_top;
		String nameOfBook = book;

		BSTNode temp_node = new BSTNode(nameOfBook);

		//if the root contains a book.
		if(!(top == null)){

			//if the root is longer than the book
			//store in the left node.
			if((top.length() <= temp_node.length()) &&                      		(top.get_left() == null)){

				top.set_left(temp_node);
				return 0;
			}
	
			//if the root is bigger than the book
			//check if the left node is bigger
			//or smaller.
			if((top.length() <= temp_node.length()) &&  					(!(top.get_left() == null))){
			
				temp_top = top;
				top = top.get_left();
				BST library_node = new BST(top);
				library_node.insert(nameOfBook);
				top = temp_top;
				return 0;

			}	
			
			//if the root is smaller than the book
			//store in the right node.
			if((top.length() > temp_node.length()) &&      					(top.get_right() == null)){

				top.set_right(temp_node);
				return 0;
			}
			
			//if the root is smaller than the book
			//check if the right node is bigger 
			//or smaller.
			if((top.length() > temp_node.length()) &&                 			!(top.get_right() == null)){

				temp_top = top;
				top = top.get_right();
				BST library_node = new BST(top);
				library_node.insert(nameOfBook);
				top = temp_top;
				return 0;
			}
		}

		//if root is empty set the book as the root(top).
		if(top == null){
			top = temp_node;
		}
		return 0;
	}
	
	//finds the book if it exists.
	public boolean find(String book){
		boolean Return = true;
		BSTNode temp_top;
		String nameOfBook = book;

		BSTNode temp_node = new BSTNode(nameOfBook);
		
		//if the library contains books.
		if(!(top == null)){
			
			//the top book is the desired book.
			if(top.length() == temp_node.length()){
				return true;
			}
			
			//the top book is smaller(shorter name) than
			//the desired book.
			if(top.length() <= temp_node.length()){
			
				//the left node is empty.
				if(top.get_left() == null){
					return false;
				}
				
				//left node isn't empty.
				if(!(top.get_left() == null)){
				
					temp_top = top;
					top = top.get_left();
					BST library_node = new BST(top);
					library_node.find(nameOfBook);
					top = temp_top;
					return Return;
				}
			}
			
			//the top book is bigger than the desired book.
			if(top.length() > temp_node.length()){
			
				//right node is empty.
				if(top.get_right() == null){
					return false;
				}
				//right node isn't empty.			
				if(!(top.get_right() == null)){				
					temp_top = top;
					top = top.get_right();
					BST library_node = new BST(top);
					Return = library_node.find(nameOfBook);
					top = temp_top;
					return Return;
				}
			}

		}
			//no books in the library(or the desired book
			//doesn't exist).
			return false;
	}
	
	//removes the book if it exists.	
	public boolean remove(String book){
		boolean Return = true;
		BSTNode temp_top;
		BSTNode temp_child;
		String nameOfBook = book;

		BSTNode temp_node = new BSTNode(nameOfBook);
		
		//books in the library.
		if(!(top == null)){
			
			//book to be removed is the top book.
			if(top.length() == temp_node.length()){
				Return = true;
				
				//if the left node isn't empty, set the
				//left node as the top node.
				if(!(top.get_left() == null)){

					temp_top = top;
					temp_child = top.get_right();
					BST library_node = new BST(top);
					top = top.get_left();
					library_node.Sort(top, temp_child);
					top = temp_top;
					return Return;
				}
				
				//otherwise set the right node as the 
				//top node.
				else{
					temp_top = top;
					temp_child = top.get_left();
					BST library_node = new BST(top);
					top = top.get_right();
					library_node.Sort(top, temp_child);
					top = temp_top;
					return Return;
				}

			}	
			
			//if the top book is smaller than the desired
			//book for removal.
			if(top.length() <= temp_node.length()){
				temp_top = top;
				top = top.get_left();	
				BST library_node = new BST(top);
				Return = library_node.remove(nameOfBook);
				top = temp_top;
				return Return;		
			}
			
			//if the top book is bigger than the desired 
			//book for removal.
			if(top.length() >= temp_node.length()){
				temp_top = top;
				top = top.get_right();
				BST library_node = new BST(top);
				Return = library_node.remove(nameOfBook);
				top = temp_top;
				return Return;	
			}
		}
		
		//no books in the library(or the book isn't in the library).
		return false;
	}
	
	public void Sort(BSTNode topNode, BSTNode childNode){
		boolean Return;
		BSTNode temp_top;
		BSTNode temp_child;

		BSTNode top_node = topNode;
		BSTNode child_node = childNode;

		BSTNode temp_node = new BSTNode(top.get_top());


		//I was in the process of building a sort method for my 
		//library removal, however after testing the example
		//inputs it appears that I don't need to sort/bubble up
		//my data. I thought data was being lost from when I reasigned 
		//the nodes, however that does not appear to be the case from
		//my testing.
	
		/*	
		if(child_node.length() <= top.get_right().length()){	

			temp_child = top.get_right();
			temp_top = top;
			top.set_right(child_node);
			BST library_node = new BST(top);	
			top = top.get_left();
			library_node.Sort(top, temp_child);
			top = temp_top;
			return 0;
		}

		return 0;
		*/
	}

	}

