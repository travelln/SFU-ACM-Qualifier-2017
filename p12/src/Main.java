
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
			
			String line1 = scan.nextLine();
			
			if(line1.equals("")){
				break;
			}
			String[] temp1 = line1.trim().split("\\s+");
			//if(temp1[0] == "\n"){
			//	break;
			//}
			int[] data1 = new int[temp1.length];
			
			//System.out.println("length " + temp1.length  + "value: " + line1);
			for(int i = 0;i < temp1.length;i++)
			{

			   data1[i] = Integer.parseInt(temp1[i]);
			}
			//System.out.println(Arrays.toString(data1));
			
			String line2 = scan.nextLine();
			String[] temp2 = line2.trim().split("\\s+");
			
			
			
			int[] data2 = new int[temp2.length];
			
			for(int i = 0;i < temp2.length;i++)
			{

			   data2[i] = Integer.parseInt(temp2[i]);
			}
			//System.out.println(Arrays.toString(data2));
			
			if(isEqual(data1, data2)){
				
				System.out.println("A equals B");
			}
			else if(AisSubsetOfB(data1, data2)){
				
				System.out.println("A is a proper subset of B");
			}
			
			else if(AisSubsetOfB(data2, data1)){
				
				System.out.println("B is a proper subset of A");
			}
			
			else if(AdoesNotContainAnyB(data2, data1) == true) {
				
				System.out.println("A and B are disjoint");
			}
			else {
				System.out.println("I'm confused!");
			}
			
		}
		
		scan.close();
 }
 
 boolean AdoesNotContainAnyB(int[] x1, int[] x2){

	 Arrays.sort(x1);
	 Arrays.sort(x2);
	 for(int i = 0; i < x1.length; i++){

		 for(int j = 0; j < x2.length; j++){
			 if ( x1[i] == x2[j]){
				 //System.out.println("Result negative");
				 return false;
			 }
			// else if (i == (x1.length-1)) {
			//	 return true;
			// }
		 }
	 }

	 return true;		

 }


 boolean AisSubsetOfB(int[] x1, int[] x2){

	 Arrays.sort(x1);
	 Arrays.sort(x2);
	 for(int i = 0; i < x1.length; i++){

		 for(int j = 0; j < x2.length; j++){
			 if ( x1[i] == x2[j]){
				 //System.out.println("Result negative");
				 break;
			 }
			 else if (j == (x2.length-1)) {
				 return false;
			 }
		 }
	 }

	 return true;		

 }


 
boolean isEqual(int[] x1, int[] x2){
	
	Arrays.sort(x1);
	Arrays.sort(x2);
	if (Arrays.equals(x1, x2)){
		//System.out.println("Result negative");
		return true;
	}
	
	return false;
}
 
 
 
}