
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
	 
		String line = scan.nextLine();
		String[] cmd = line.trim().split("\\s+");
		int inputLines = Integer.parseInt(cmd[0]);

		for (int i = 0; i < inputLines; i++){

			line = scan.nextLine();
			String[] data = line.trim().split("\\s+");
			
			char concept1, concept2 = ' ';
			char prefix1 = ' ', prefix2 = ' ';
			char unit1, unit2 = ' ';
			
			for (int j = 0; j < line.length(); j++){
				
				if (line.charAt(j) == '='){
					
					concept1 = line.charAt(j-1);
					j++;
					String value1 = "";
					while(!Character.isLetter(line.charAt(j))){
						value1 = value1 + line.charAt(j);
						j++;
					}
					
					if((line.charAt(j) == 'm') || (line.charAt(j) == 'k') || (line.charAt(j) == 'M') ){
						prefix1 = line.charAt(j);
						j++;
					}
					
					unit1 = line.charAt(j);
					
					while(line.charAt(j) != '=' ){
						j++;
					}
					concept2 = line.charAt(j-1);
					j++;
					String value2 = "";
					while(!Character.isLetter(line.charAt(j))){
						value2 = value2 + line.charAt(j);
						j++;
					}
					
					if((line.charAt(j) == 'm') || (line.charAt(j) == 'k') || (line.charAt(j) == 'M') ){
						prefix2 = line.charAt(j);
						j++;
					}
					
					unit2 = line.charAt(j);
					
					float x1, x2;
					
					x1 = Float.parseFloat(value1);
					x2 = Float.parseFloat(value2);
					System.out.println("Problem #" + (i+1));
					
					
					//System.out.println("float 1 " + x1 + " " + concept1 + " " + unit1 + " " + prefix1);
					//System.out.println("float 2 " + x2 + " " + concept2 + " " + unit2 + " " + prefix2);
					
					printResults(x1, concept1, unit1, prefix1, x2, concept2, unit2, prefix2);
					System.out.println( );
				}
				
			}

			

		}//end outer for loop
		scan.close();
	 
 }
 
 void printResults(float x1, char concept1, char unit1, char prefix1,  float x2, char concept2, char unit2, char prefix2){
	 
	 if(prefix1 == 'M'){
		 x1 = x1 * 1000000f;
		 //System.out.println("x1 " + x1+ " " + x2);
	 }
	 
	 if(prefix1 == 'm'){
		 x1 = x1 * .001f;
	 }
	 
	 if(prefix1 == 'k'){
		 x1 = x1 * 1000f;
	 }
	 
	 if(prefix2 == 'M'){
		 x2 = x2 * 1000000f;
		 //System.out.println("x2 " + x2 + " " + x1);
	 }
	 
	 if(prefix2 == 'm'){
		 x2 = x2 * .001f;
	 }
	 
	 if(prefix2 == 'k'){
		 x2 = x2 * 1000f;
	 }
	 
	 
	 if((concept1 == 'P')&&(concept2 == 'U')){
		// System.out.println("con1 " + concept1 + " con2 " + concept2);
		System.out.println("I=" +  String.format("%.2f", x1/x2) + "A");
		return;
	 }
	 
	 if((concept1 == 'U')&&(concept2 == 'P')){
		//System.out.println("con1 " + concept1 + " con2 " + concept2);
		System.out.println("I=" +  String.format("%.2f", x2/x1) +"A");
		return;
	 }
	 
	 
	 if((concept1 == 'P')&&(concept2 == 'I')){
		// System.out.println("con1 " + concept1 + " con2 " + concept2);
		System.out.println("U=" +  String.format("%.2f", x1/x2) +"V");
		return;
	 }
	 
	 if((concept1 == 'I')&&(concept2 == 'P')){
		 //System.out.println("con1 " + concept1 + " con2 " + concept2);
		System.out.println("U=" +  String.format("%.2f", x2/x1) + "V");
		return;
	 }
	 
	 if((concept1 == 'U')&&(concept2 == 'I')){
		 //System.out.println("con1 " + concept1 + " con2 " + concept2);
		 //double temp1 = x2, temp2 = x1;
		System.out.println("P=" + String.format("%.2f", x1*x2) +"W");
		return;
	 }
	 
	 if((concept1 == 'I')&&(concept2 == 'U')){
		 //System.out.println("con1 " + concept1 + " con2 " + concept2);

		 //double temp1 = x2, temp2 = x1;
		 //String strDouble = String.format("%.2f", 1.9999); System.out.println(strDouble);
		System.out.println("P=" + String.format("%.2f", x1*x2)+ "W");

		
		return;
	 }
	 
	 
	 
	 
	 
	 
	 
 }
 
 
}