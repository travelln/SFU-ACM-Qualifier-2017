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
		//scan.nextLine();


		for(int i = 0; i < inputLines; i ++){

			String line1 = scan.nextLine();
			String[] data1 = line1.trim().split("\\s++");//trim().split("\\s+");
			//System.out.println(data1[0]);
			//System.out.println(data1[1]);
			//System.out.println(data1[2]);

			String line2 = scan.nextLine();
			String[] data2 = line2.trim().split("\\s+");

			String line3 = scan.nextLine();
			String[] data3 = line3.trim().split("\\s+");

			String safeTemp = "";

			if (data1[2].equals("even")){

				safeTemp = safeTemp + data1[0] + data1[1];	
			}

			if (data2[2].equals("even")){

				safeTemp = safeTemp + data2[0] + data2[1];	
			}
			if (data3[2].equals("even")){

				safeTemp = safeTemp + data3[0] + data3[1];
			}


			

			String upTemp = "";
			String downTemp = "";

			if (data1[2].equals("up")){

				upTemp = upTemp + data1[1];	
				downTemp = downTemp + data1[0];
			}

			if (data2[2].equals("up")){

				upTemp = upTemp + data2[1];	
				downTemp = downTemp + data2[0];
			}

			if (data3[2].equals("up")){

				upTemp = upTemp + data3[1];
				downTemp = downTemp + data3[0];			
			}
			
			if (data1[2].equals("down")){

				upTemp = upTemp + data1[0];	
				downTemp = downTemp + data1[1];
			}

			if (data2[2].equals("down")){

				upTemp = upTemp + data2[0];	
				downTemp = downTemp + data2[1];
			}

			if (data3[2].equals("down")){

				upTemp = upTemp + data3[0];
				downTemp = downTemp + data3[1];			
			}
			
			
			String[] safe = safeTemp.split("");
			String[] up = upTemp.split("");
			String[] down = downTemp.split("");

//			System.out.println(safeTemp);
//			System.out.println(upTemp);
//			System.out.println(downTemp);
//			
//			System.out.println(Arrays.toString(safe));
//			System.out.println(safe.length);
			
			for( int j = 0; j < up.length; j++){
				
				if (isContained(safe, up[j]) == true){
					up[j] = "/";
				}
			}
			
			for( int j = 0; j < down.length; j++){
				
				if (isContained(safe, down[j]) == true){
					down[j] = "/";
				}
			}
			//System.out.println("SAFE " + Arrays.toString(safe));
			//System.out.println("UP " + Arrays.toString(up));
		    //System.out.println("DOWN " + Arrays.toString(down));
		    //System.out.println("WINNER IS " );
			
			String win = null;
			if (checkWinner1(up, down) == true){
				continue;
			}
			win = checkWinner2(up);
			
			if (win != null){
				System.out.println(win + " is the counterfeit coin and it is light.");
				continue;
			}
			
			win = checkWinner2(down);
			
			if (win != null){
				System.out.println(win + " is the counterfeit coin and it is heavy.");
				continue;
			}
			
			}
		


		//String[]

	}
	
String checkWinner2(String[] x){
	
	String temp = "";
	
	for( int i = 0; i < x.length; i++){
		
		if(!x[i].equals("/")){
			
			temp = temp + x[i];
		}
	}
	
	if (temp.length() == 1){
		return temp;
	}
	
	return null;
	
}
boolean checkWinner1(String[] up, String[] down){
	
	String maxCharUp = "";
	int countUp = 0;
	
	for(int i = 0; i < up.length; i++){
	
		int tempCount = 1;
		for(int j = 0; j < up.length; j++){
			
			if((j != i) && (!up[i].equals("/")) && (up[i].equals(up[j]))){
				tempCount++;
			}
		}
		if(tempCount > countUp){
			countUp = tempCount;
			maxCharUp = up[i];
		}
	}
	
	String maxCharDown = "";
	int countDown = 0;
	
	for(int i = 0; i < down.length; i++){
	
		int tempCount = 1;
		for(int j = 0; j < down.length; j++){
			
			if((j != i) && (!down[i].equals("/")) && (down[i].equals(down[j]))){
				tempCount++;
			}
		}
		if(tempCount > countDown){
			countDown = tempCount;
			maxCharDown = down[i];
		}
	}
	//System.out.println("COUNT UP " + countUp + " COUNT DOWN " + countDown);
	if((countUp > countDown) && (countUp > 1)){
		
		System.out.println(maxCharUp + " is the counterfeit coin and it is light.");
		return true;
	}
	
	if((countDown > countUp) && (countDown > 1)){
		
		System.out.println(maxCharDown + " is the counterfeit coin and it is heavy.");
		return true;
	}
	
	return false;

}

void checkWinner(String[] up, String[] down){
	
for(int i = 0; i < up.length; i++){
	
	if( (!up[i].equals("/")) && (isContainedRepeat(up, up[i], i)) == true){
		System.out.println(up[i] + " is the counterfeit coin and it is light.");
		return;
	}
}
	
for(int i = 0; i < down.length; i++){
	
	if( (!down[i].equals("/")) && (isContainedRepeat(down, down[i],i)) == true){
		System.out.println(down[i] + " is the counterfeit coin and it is heavy.");
		return;
	}
}	
}

boolean isContainedRepeat(String[] x, String y, int k){

	//String temp = y;
	
	for (int i = 0; i < x.length; i++){
			
			if ((x[i].equals(y)) && (k != i)){
				
				return true;		
			
		}
	
	}
	return false;
}




boolean isContained(String[] x, String y){
		
		
		//String temp = y;
		
		for (int i = 0; i < x.length; i++){
				
				if (x[i].equals(y)){
					
					return true;
					
					
				
			}
		
		}
		return false;
	}
	

}