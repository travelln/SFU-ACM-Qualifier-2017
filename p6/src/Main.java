
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
			 
			 int strLength = input.length();
			 int[] asciiArray = new int[strLength];
			 int[] freqArray = new int[strLength];
			 int sizeOfArray = 0;
			 
			 for (int i = 0; i < strLength; i++){
				 
				 sizeOfArray = addToArray(asciiArray, freqArray, input.charAt(i), sizeOfArray);
			 }		 
			 printArray(asciiArray, freqArray, sizeOfArray);
			 
			 if(scan.hasNextLine()){
				 System.out.println();
			 }
		}
		
		scan.close();
 }
 
 int getAscii(char n){
	 int asciiValue = (int)n;
	 return asciiValue;
 }
 
 int addToArray(int[] ascii, int[] freq, char toAdd, int size){
	 
	// System.out.println("ascii value " + getAscii(toAdd));
	 
	 if(size == 0){
		 
		 ascii[0] = getAscii(toAdd);
		 freq[0]++;
		 return 1;
	 }
	 else{
		 for(int i = 0; i < size; i ++){
			 
			 if(getAscii(toAdd) == ascii[i]){
				 freq[i]++;
				 return size;
			 }
		 }
		 ascii[size] = getAscii(toAdd);
		 freq[size]++;
		 return size+1;
	 }
	 
 }
 
 void printArray(int[] ascii, int[] freq,int size){
	 
	 
	 for(int i = 0; i < size; i++ ){
		 
		 int smallest = findSmallest(ascii, freq, size);
		 System.out.println(ascii[smallest] + " " + freq[smallest]);
		 ascii[smallest] = -1;
		 freq[smallest] = 0;
		 //size--;
	 }
	 
	 
 }
 
 int findSmallest(int[] ascii, int[] freq, int size){
	 
	 int smallest = 0;
	 
	 for (int i = 0; i < size; i++){
		 
		 if(freq[i] != 0){
			 smallest = i;
			// System.out.println("first smallest " + smallest);
			 break;
		 }
	 }
	
	 for (int i = smallest; i < size; i++){
		 
		 if((freq[i] < freq[smallest]) && (freq[i] != 0)){
			// System.out.println("second smallest " + freq[i]);
			 smallest = i;
		 }
	 }
	 for (int i = smallest; i < size; i++){
		 
		 if((ascii[i] > ascii[smallest]) && (freq[i] == freq[smallest]) ){
			// System.out.println("second smallest " + freq[i]);
			 smallest = i;
		 }
	 }
	 return smallest;
 }
 
}
