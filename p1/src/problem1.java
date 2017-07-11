

import java.io.*;
import java.util.*;

class problem1
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
     problem1 myWork = new problem1();  // create a dynamic instance
     myWork.Begin();            // the true entry point
     System.exit(0);
 }

 void Begin()
 {
     String input;
     StringTokenizer idata;
     int firstCard, secondCard;

     while ((input = problem1.ReadLn (255)) != null)
     {
    	 if (input.charAt(0) == '\n'){
    		 System.exit(0);
    	 }
       
       
       try  
       {  
    	   idata = new StringTokenizer (input);
           firstCard = Integer.parseInt (idata.nextToken());
           secondCard = Integer.parseInt (idata.nextToken()); 
       }  
       catch( Exception e )  
       {  
    	   System.exit(0);  
       } 
       idata = new StringTokenizer (input);
       firstCard = Integer.parseInt (idata.nextToken());
       secondCard = Integer.parseInt (idata.nextToken());

		
		//if both cards are the same then the output
		//will form a three of a kind
		if (firstCard == secondCard) {
			System.out.println(secondCard);
		}
		//if the first card is greater then output 
		// the value of the first card creating a pair
		else if (firstCard > secondCard) {
			System.out.println(firstCard);
		}
		//output the value of the second card
		//creating a pair
		else {	
			System.out.println(secondCard);	
		}	
     }
     System.exit(0);
 }
}