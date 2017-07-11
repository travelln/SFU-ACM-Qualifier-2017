
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



	int cmdLines = scan.nextInt() ;
	scan.nextLine();

	 String s1, s2, s3, s4, s5;
	 



	for (int i = 0; i < cmdLines; i++){
		s1 = s2 = s3 = s4 = s5 = "";
		 String input = scan.nextLine();
		 int strLength = input.length();

		// for (int j = 0; j < strLength; j++){
			 int j = 0;

				 while((input.charAt(j) != '<') && (j < strLength)){	 
					 s1 = s1 + input.charAt(j);
					 j++;
				 }
				 
				 j++;
				 
				 while((input.charAt(j) != '>')&& (j < strLength)){	 
					 s2 = s2 + input.charAt(j);
					 j++;
				 }
				 j++;
				 
				 
				 while((input.charAt(j) != '<')&& (j < strLength)){	 
					 s3 = s3 + input.charAt(j);
					 j++;
				 }
				 
				 j++;
				 
				 while((input.charAt(j) != '>')&& (j < strLength)){	 
					 s4 = s4 + input.charAt(j);
					 j++;
				 }
				 j++;
				 
				 while(j < strLength) {
					 s5 = s5 + input.charAt(j);
					 j++;
				 }
				 
		// }
				 String output1 = s1 + s2 + s3 + s4 + s5; 

				 System.out.println(output1);
				 
				 input = scan.nextLine();
				 strLength = input.length();
				 String output2 = "";
				 j = 0;
				 
				 while((input.charAt(j) != '.')&& (j < strLength)){	 
					 output2 = output2 + input.charAt(j);
					 j++;
				 }
				 output2 = output2 + s4 + s3 + s2 + s5;
				 System.out.println(output2);
	 }
	System.exit(0);
 }
}