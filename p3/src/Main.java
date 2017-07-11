

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

	 int testCases;

	 Scanner scan = new Scanner(System.in);
	 // storing the line as a String
	 String input = scan.next();
;
	 testCases = Integer.parseInt(input);


	 while (testCases != 0) {

		 //get next integer case
		 input = scan.next();
		 int inputValue = Integer.parseInt(input);

		 //smallest wrap as one rectangle with top and bottem covered
		 int smallestWrap = (4*inputValue) + 2;

		 
		 for (int i = 1; i*i*i <= inputValue; i++) {
			 
			 if(inputValue%i == 0){
				 
				 for (int j = i; j*j <= inputValue; j++){
					 
					 if ((inputValue/i)%j == 0) {
						 
						 
						 int k = inputValue/(i*j);
						 
						 int possibleSmallest = (2*i*j)+ (2*i*k) + (2*j*k);
						 
						 if (possibleSmallest < smallestWrap){
							 smallestWrap = possibleSmallest;
						 }
					 }
					 
				 }
				 
			 }
			 
			 
		 }
		 
		 System.out.println(smallestWrap);
		 testCases--;
	 }//end while

	 	scan.close();

 }


}

