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


		// storing the line as a String


		String[] myList = new String[1200];

		int count = readInput(myList); //read the input
		//System.out.println("count is " + count);
		
		//System.out.println("str is " + myList[3]);
		
		//check the input for anagrams
		
		String[] results = new String[count];
		
		int resultsCount = checkAnagrams(myList, results, count);
		
		String[] finalResults = new String[resultsCount];
		
		for (int i = 0; i < resultsCount; i ++){
			
			finalResults[i] = results[i];
		}
		Arrays.sort(finalResults);
		printArray(finalResults, resultsCount);
		
		
	}

	
	void printArray(String[] toPrint, int count){
		
		for (int i =0; i < count; i++){
			
			System.out.println(toPrint[i]);
		}
		
		
		
		
	}
	int checkAnagrams(String[] input, String[] results, int count){
		
		int resultsCount = 0;
		
		for (int i = 0; i < count; i ++){
			//System.out.println("Checking " + input[i] + "...");
			
			for (int j = 1; j < count; j ++){
				
				char[] word1 = input[i].toLowerCase().toCharArray();
				Arrays.sort(word1);
				
				//if((input[i].length() == input[j].length()) ){
					
				if ((i == j ) && (i == count-1)) {
					results[resultsCount] = input[i];
					resultsCount++;
					continue;
				}
					if (i == j )  {
						continue;
					}
					char[] word2 = input[j].toLowerCase().toCharArray();
					Arrays.sort(word2);
					
					if (Arrays.equals(word1, word2)){
						//System.out.println("Result negative");
						break;
					}
					else if(j == count-1){
						//System.out.println("Adding!");
						results[resultsCount] = input[i];
						resultsCount++;
						
					//}
				}
				
				
				
				
			}//end inner for loop
			
		}//end outer for loop
		
		
		return resultsCount;
	}

	int readInput(String[] input){

		int count = 0;

		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()){


			String stringInput = scan.next();

			if(stringInput.charAt(0) == '#'){
				break;
			}
			input[count] = stringInput;
			
			//System.out.println(stringInput + " Length is : " + stringInput.length());
			count++;
		}

		return count;



	}


}

