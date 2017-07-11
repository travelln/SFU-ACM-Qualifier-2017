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
		
		for(int i = 0; i < inputLines; i ++){
			line = scan.nextLine();
			String[] data = line.trim().split("\\s+");
			
			double length = Integer.parseInt(data[0]);
			
			double width = (length/10)*6f;
			
			double areaRectangle = length* width;
			
			double radius = (length/5f);
			
			double areaCircle = radius * radius;
			areaCircle = areaCircle * java.lang.Math.acos(-1); 
			
			areaRectangle = areaRectangle - areaCircle;
			
			System.out.println(String.format("%.2f", areaCircle) + " " + String.format("%.2f", areaRectangle));
		}
		
		
		
		scan.close();
 }
 
 
}