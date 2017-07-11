
import java.io.*;
import java.util.*;

class Main
{

 public static void main (String args[])  // entry point from OS
 {
     Main myWork = new Main();  // create a dynamic instance
     myWork.Begin();            // the true entry point
     System.exit(0);
 }

 void Begin()
 {

	 Scanner scan = new Scanner(System.in);
	 // storing the line as a String
	 
		while (scan.hasNextLine()) {
			
			int cmdLines = scan.nextInt();
			scan.nextLine();
			 
			 if (cmdLines == 0){
				 break;
			 }
			 int top = 1;
			 int bottom = 6;
			 int north = 2;
			 int east = 4;
			 int south = 5;
			 int west = 3;
			 
			 for (int i = 0; i < cmdLines; i++) {
				 
				 String input = scan.nextLine();
	
				 if (input.equals("north")){

					 int temp = north;
					 north = top;
					 top = south;
					 south = bottom;
					 bottom = temp;
				 }
				 
				 if (input.equals("east")){
					 int temp = east;
					 east = top;
					 top = west;
					 west = bottom;
					 bottom = temp;
				 }
				 
				 if (input.equals("south")){
					 int temp = south;
					 south = top;
					 top = north;
					 north = bottom;
					 bottom = temp;
					 
				 }
				 if (input.equals("west")){
					 int temp = west;
					 west = top;
					 top = east;
					 east = bottom;
					 bottom = temp;
				 }
				
			 }
			 
			 System.out.println(top);
			 
			 
			 
		}
		
		
		
 }
 
 
}