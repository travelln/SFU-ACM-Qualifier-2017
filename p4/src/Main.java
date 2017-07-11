

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main
{
 static String ReadLn (int maxLg)  // utility function to read from stdin
 {
     byte lin[] = new byte [maxLg];
     int lg = 0, car = -1;
     String line = "";

     try
     {
         while (lg < maxLg)
         {
             car = System.in.read();
             if ((car < 0) || (car == '\n')) break;
             lin [lg++] += car;
             //System.out.println("good");
         }
     }
     catch (IOException e)
     {
    	// System.out.println("not good");
         return (null);
     }

     if ((car < 0) && (lg == 0)){ 
     return (null);  // eof
     
     }
    

     return (new String (lin, 0, lg));
 }

 public static void main (String args[])  // entry point from OS
 {
     Main myWork = new Main();  // create a dynamic instance
     myWork.Begin();            // the true entry point
     System.exit(0);
 }

 void Begin()
 {
     //String input;
     //StringTokenizer idata;
     BigInteger inputNumber;
     BigInteger zeroNumber = new BigInteger("0");
     BigInteger elevenNumber = new BigInteger("11");
     
     Scanner scan = new Scanner(System.in);
  // storing the line as a String
     String input = scan.next();
     //System.out.println("output " + input);
     //System.out.println("END");
     inputNumber= new BigInteger(input);
  
     //read number of games to be solved
    // input = Main.ReadLn (255);
	 //idata = new StringTokenizer (input);
	 //inputNumber = new BigInteger(idata.nextToken());     
	 //System.out.println("number of games " + numberofGames);


	 
	 while (!inputNumber.equals(zeroNumber)) {
		 BigInteger divideNumber = inputNumber.remainder(elevenNumber);
		 if ( divideNumber.equals(zeroNumber)){
			 System.out.println(input + " is a multiple of 11.");
			 
		 }
		 else {

			 System.out.println(input + " is not a multiple of 11.");
			 
		 }
		 
		 
	     input = scan.next();
	     inputNumber= new BigInteger(input);
	 }
	 
	 
	 
 }
 
}


