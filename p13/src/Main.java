
import java.io.*;
import java.util.*;

class Main
{

 public static void main (String args[]) throws FileNotFoundException  // entry point from OS
 {
     Main myWork = new Main();  // create a dynamic instance
     myWork.Begin();
     System.exit(0);
 }

 void Begin() throws FileNotFoundException
 {

	 Scanner scan = new Scanner(System.in);

	 while(scan.hasNextLine()){
		 String line = scan.nextLine();
		 String[] input = line.trim().split("/");

		 if((input[0].equals("e"))&& (input[1].equals("o")) && (input[2].equals("i"))){

			 break;

		 }
		 //int inputLines = Integer.parseInt(cmd[0]);
		 int test1 = testSyllables(input[0]);
		 
		 if (test1 != 5){
			 System.out.println("1");
			 continue;
		 }
		 
		 int test2 = testSyllables(input[1]);
		 
		 if (test2 != 7){
			 System.out.println("2");
			 continue;
		 }
		 
		 int test3 = testSyllables(input[2]);
		 
		 if (test3 != 5){
			 System.out.println("3");
			 continue;
		 }
		 
		 System.out.println("Y");
		// System.out.println("ONE : " + input[0] + " COUNT: " + testSyllables(input[0]));
		 //System.out.println("TWO : " + input[1] + " COUNT: " + testSyllables(input[1]));
		 //System.out.println("THREE : " + input[2] + " COUNT: " + testSyllables(input[2]));
	 }
	 scan.close();

 }

 boolean isVowel(char x){
	 
	 if((x ==  'a') ||(x ==  'e') ||((x ==  'i') ||(x) ==  'o')
			 || (x ==  'u') || (x ==  'y')){
	 return true;
	 }
	 return false;
 }
 
 int testSyllables(String x){
	 
	 int strLength = x.length();
	 int count = 0;
			 
			 for (int i = 0; i < strLength; i++){
				
				 if (isVowel(x.charAt(i)) == true){
					 
					 while(i < strLength){
						 i++;
						 if (( i == strLength) || isVowel(x.charAt(i)) == false){
							 count++;
							 break;
						 }
					 }
				 }
				 
			//	 if((x.charAt(i) ==  'a') ||(x.charAt(i) ==  'e') ||((x.charAt(i) ==  'i') ||(x.charAt(i) ==  'o')
			//			 || (x.charAt(i) ==  'u') || (x.charAt(i) ==  'y'))
				 
			 }
	 
	 
	 return count;
 }
 
}