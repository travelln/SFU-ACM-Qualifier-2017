

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
	 //Scanner scan = new Scanner(new FileInputStream("input1.txt"));
	 // storing the line as a String
	 float[][] circleArray = new float[50][3];
	 float[][] rectArray = new float[50][4];
	 int circleCount = 0;
	 int rectCount = 0;
	 char[] figNumber = new char[20];
	 int figCount = 0;
	 
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] data = line.trim().split("\\s+");
			
			char shapeType = data[0].charAt(0);//scan.next().charAt(0);

			if (shapeType == '*'){
				//System.out.println("END SCAN");
				break;
			}
			//System.out.println("TEST " + data[1]);	
			if (shapeType == 'r'){
				//System.out.println("scanning rectangle...");
				rectArray[rectCount][0] = Float.parseFloat(data[1]);
				//System.out.println(rectArray[rectCount][0]);
				//scan.nextLine();
				rectArray[rectCount][1] = Float.parseFloat(data[2]);
				//System.out.println(rectArray[rectCount][1]);
				//scan.nextLine();
				rectArray[rectCount][2] = Float.parseFloat(data[3]);
				//System.out.println(rectArray[rectCount][2]);
				//scan.nextLine();
				rectArray[rectCount][3] = Float.parseFloat(data[4]);
				//System.out.println(rectArray[rectCount][3]);
				//scan.nextLine();

				figNumber[figCount] = 'r'; 
				figCount++;
				rectCount++;
			}
			else if (shapeType == 'c'){
				
				//System.out.println("scanning circle...");
				circleArray[circleCount][0] = Float.parseFloat(data[1]);
				circleArray[circleCount][1] = Float.parseFloat(data[2]);
				circleArray[circleCount][2] = Float.parseFloat(data[3]);
				
				figNumber[figCount] = 'c';
				figCount++;
				circleCount++;
			}
			//scan.nextLine();
		}
//		System.out.println("circle count " + circleCount);
//		System.out.println(Arrays.deepToString(circleArray));
//		System.out.println("rect count " + rectCount);
//		System.out.println(Arrays.deepToString(rectArray));
//		System.out.println("one circle " + circleArray[0][0] + " " + circleArray[0][1] + " " + circleArray[0][2]);
//	System.out.println("one circle " + circleArray[1][0] + " " + circleArray[1][1] + " " + circleArray[1][2]);
//	System.out.println("one circle " + circleArray[2][0] + " " + circleArray[2][1] + " " + circleArray[2][2]);
//	
	//scan.nextLine();
	
	float[][] pointArray = new float[10000][2];
	int pointArrayCount = 0;
	
	while (scan.hasNextLine()) {
		String line = scan.nextLine();
		String[] data = line.trim().split("\\s+");
		
		//char shapeType = data[0].charAt(0);//scan.next().charAt(0);
		
		float x1 = Float.parseFloat(data[0]);
		float y1 = Float.parseFloat(data[1]);
		
		//System.out.println("SCANNING FLOAT... " + x1 + " " + y1);

		
		if((x1 != 9999.9f) && (y1 != 9999.9f)){
			
			pointArray[pointArrayCount][0] = x1;
			pointArray[pointArrayCount][1] = y1;
			pointArrayCount++;
		}
		else {
			//System.out.println("hello");
			break;
		}
		//scan.nextLine();
		
	
		
	}
	//System.out.println("one point " + pointArray[0][0] + " " + pointArray[0][1]);
 
	//System.out.println("one point " + pointArray[5][0] + " " + pointArray[5][1]);


	//System.out.println("fig count " + figCount + " pointArray count " + pointArrayCount);

	for (int i = 0; i < pointArrayCount; i ++){
		int r_pos = 0;
		int cir_pos = 0;
		int found = 0;

		for(int j = 0; j < figCount; j++){
			//System.out.println("point " + (i+1) + " FIGURE " + (j+1));
			if (figNumber[j] == 'c'){
				
				int temp = r_pos+cir_pos+1;
				if(checkCircle(pointArray[i][0], pointArray[i][1], circleArray[cir_pos][0], circleArray[cir_pos][1], circleArray[cir_pos][2]) == true){
					System.out.println("Point " + (i+1) + " is contained in figure " +  temp);
					found++;
				}
				else{
					//System.out.println("NO CIRCLE");
				}
				cir_pos++;
			}
			if (figNumber[j] == 'r'){
				int temp = r_pos+cir_pos+1;
				
				if (checkRectangle(rectArray[r_pos][0], rectArray[r_pos][1], rectArray[r_pos][2], rectArray[r_pos][3], pointArray[i][0], pointArray[i][1]) == true){
					System.out.println("Point " + (i+1) + " is contained in figure " +  temp);
					found++;
				}

				else{
					//System.out.println("NO RECTANGLE");
				}
				r_pos++;
			}


		}


		if (found == 0){
			System.out.println("Point " + (i+1) + " is not contained in any figure");
		}
	}
	scan.close();
	//System.out.println();
	System.exit(0);
 }

 
 boolean checkRectangle(float x1, float y1, float x2, float y2, float pointx1, float pointy1){
	 
	 if ((pointx1 > x1) && (pointx1 < x2) && (pointy1 < y1) && (pointy1 > y2)){
		 //System.out.println("YES- TRUE " + "points: " + pointx1 + " > " + x1 + " " + pointx1 + " < " + x2 + " " + pointy1 + " < " + y1 + " " + pointy1 + " > " + y2);
		 return true;
	 }
	 //System.out.println("NO- FALSE " + "points: " + pointx1 + " > " + x1 + " " + pointx1 + " < " + x2 + " " + pointy1 + " < " + y1 + " " + pointy1 + " > " + y2);
	 return false;
 }
 
 boolean checkCircle(float x1, float y1, float center_x, float center_y, float radius){
	 
	 float check = ((x1 - center_x)*(x1 - center_x)) + ((y1 - center_y)*(y1 - center_y));
	 float radiusSqr = radius * radius;
	 
	 if (check < radiusSqr){
		 return true;
	 }
	 return false;
 }
 
 
}