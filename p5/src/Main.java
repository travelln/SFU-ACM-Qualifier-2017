

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
			 String input = scan.nextLine();

			// System.out.println(input);
			 //System.out.println("length" + input.length());

			int strLength = input.length();

			StringBuilder sb = new StringBuilder(input);
			//System.out.println("sblength" + sb.length());
			for (int i = 0; i < strLength; i++) {
				//System.out.println("sb " + sb);
				//System.out.println("char at now " + sb.charAt(i));
				if (sb.charAt(i) == 'A' || sb.charAt(i) == 'a'
						|| sb.charAt(i) == 'E' || sb.charAt(i) == 'e'
						|| sb.charAt(i) == 'I' || sb.charAt(i) == 'i'
						|| sb.charAt(i) == 'O' || sb.charAt(i) == 'o'
						|| sb.charAt(i) == 'U' || sb.charAt(i) == 'u') {
					for (int j = i; j < strLength; j++) {
						
						if (!Character.isLetter(sb.charAt(j))){
							//System.out.println("1 " + sb);
							//sb.append("ay");
							sb.insert(j, "ay");
							i = j+2;
							break;
						}


						else if (sb.charAt(j) == ' ') { //search for the first blank space, denoting the end of a word
							sb.insert(j, "ay");
							//System.out.println("2 " +  sb);
							//System.out.println("ins");
							i = j+2; //we don't need to read the rest of the word
							break;
						}
						else if (j == (strLength-1)){ //we need to append since there are no blank spaces in the line
							//sb.append("ay");
							sb.insert(j+1, "ay");
							//System.out.println("3 " + sb);
							//System.out.println("app" + j);
							i = j+2;
							
							break;
						}
						//else{
							//System.out.println("4 " + sb);
						//	i=j;;
						//}
						//else { //ignore the rest of the word and any other nonsensical characters
						//	for(int )

					}
				}
				else if (Character.isLetter(sb.charAt(i))){
					//System.out.println("5 " + sb);
					char toAppend = sb.charAt(i);
					sb.deleteCharAt(i);
					strLength = sb.length();
					for (int j = i; j < strLength; j++) {

						
						if (!Character.isLetter(sb.charAt(j))){
							//System.out.println("pop");
							//sb.append("ay");
							sb.insert(j, toAppend + "ay");
							i = j+2;
							break;
						}
						else if (j == (strLength-1)){ //we need to append since there are no blank spaces in the line
							//sb.append(toAppend + "ay");
							sb.insert(j+1,toAppend + "ay");
							//System.out.println("app2");
							//System.out.println("sb is " + sb);
							i = j+3;
							break;
						}
						else if (sb.charAt(j) == ' ') { //search for the first blank space, denoting the end of a word
							sb.insert(j, toAppend + "ay");
								//System.out.println("ins2");
							i = j+2; //we don't need to read the rest of the word
							break;
						}
						//else { //ignore the rest of the word and any other nonsensical characters
						//	for(int )

					}
				}
				else {
					for (int j = i; j < strLength; j++) {
						//if (sb.charAt(j) == ' '){
						//System.out.println("2char at now " + sb.charAt(j));
						if (Character.isLetter(sb.charAt(j))){
							i = j-1;
							break;
						}
						i=j;

					}
					
					
				}
				strLength = sb.length();
			}// end for loop outer
			String temp = sb.toString();
			//if(!scan.hasNextLine()){
			//	System.out.print(temp);
			//}
			//else{
			System.out.print(temp);
			//}
		}
		System.out.println();
		scan.close();

 }
}
