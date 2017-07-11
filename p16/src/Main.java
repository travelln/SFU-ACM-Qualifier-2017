
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

		//String line = scan.nextLine();
		
		String input = "ertyuiop[]dfghjkl;'cvbnm,.";
		String output = "qwertyuiopasdfghjklzxcvbnm";
		
		//System.out.println("LENGTH " + line.length());
		//String[] cmd = line.trim().split("\\s+");
		//int inputLines = Integer.parseInt(cmd[0]);
		 while(scan.hasNextLine()){
			 String line1 = scan.nextLine();
			 line1 = line1.toLowerCase();
		 //line1 = scan.nextLine();
			
			//System.out.println("LENGTH2 " + line1.length());
			
			
			for(int i =0; i < line1.length(); i ++){
				
				for(int j =0; j < input.length(); j ++){
					
					if(line1.charAt(i) == input.charAt(j)){
						
						line1 = replaceCharAt(line1, i, output.charAt(j));
					}
				}
			}
			System.out.println(line1);
		 }
	}
	
	
	public static String replaceCharAt(String s, int pos, char c) {
		   return s.substring(0,pos) + c + s.substring(pos+1);
		}
	
}