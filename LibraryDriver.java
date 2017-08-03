/**
 * Ryan Stratton
 * CIS313 lab2
 * 
 * Library driver for Library program.
 *
 */

import java.io.IOException;
import java.util.Scanner;

//the driver program for lab2, it proccesses the data into BST and
//prints out the results.
public class LibraryDriver {

	public static void main(String[] args) throws IOException
	{

	String[] library_scan;
	int num_strings;
	int i = 0;
	boolean Return = true;
	
	String line = null;

	BST library = new BST();
	
	Scanner stdin = new Scanner(System.in);

	num_strings = Integer.parseInt(stdin.nextLine());
	library_scan = new String[num_strings*2];

	for( i = 0; i < (num_strings); i++){
		
		line = stdin.nextLine();
		
		//insert is the command.
		//inserts the next book into the library.
		if(line.equals("insert")){
			line = stdin.nextLine();
			library.insert(line);
				
			System.out.print("Inserted " + line + " into the catalog.\n");			
		}
		
		//find is the command.
		if(line.equals("find")){
			line = stdin.nextLine();
			Return = library.find(line);
		
			//book was found.	
			if(Return == true){
				System.out.print(line + " is in the catalog.\n");
			}
			
			//book wasn't found.
			else{
				System.out.print(line + " is not in the catalog.\n");
			}

		}
		
		//remove is the command.
		if(line.equals("remove")){
			line = stdin.nextLine();
			Return = library.remove(line);

			//book was removed.
			if(Return == true){
				System.out.print(line + " was removed from the catalog.\n");
			}

			//book wasn't found.
			else{
				System.out.print(line + " is not in the catalog.\n");
			}

		}
	}	

	}

}	
