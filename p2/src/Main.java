

import java.io.*;
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
     String input;
     StringTokenizer idata;
     int numberofGames, boardSize;
     
     //read number of games to be solved
     input = Main.ReadLn (255);
	 idata = new StringTokenizer (input);
	 numberofGames = Integer.parseInt (idata.nextToken());     
	 //System.out.println("number of games " + numberofGames);


	 
	 while (numberofGames > 0) {
		 numberofGames--; 
		 input = Main.ReadLn (255); //read in the blank line separating games
		 
	     input = Main.ReadLn (255); //read in the size of the board
		 idata = new StringTokenizer (input);
		 boardSize = Integer.parseInt (idata.nextToken());     
		 char[][] boardMines = new char[boardSize][boardSize];
		 char[][] boardTouched = new char[boardSize][boardSize];
		 
		// System.out.println(" board size " +  boardSize);	 
		 
		 //read the board input for mine positions
		 for (int i = 0; i < boardSize; i++){
	
		     input = Main.ReadLn (255); //read a line of the board
			 idata = new StringTokenizer (input);
			 String temp = idata.nextToken();
			 
			 for (int j = 0; j < boardSize; j++){
				 //parse a line of the board
				 
				 
				 //System.out.println("token " + temp.charAt(j));
				 boardMines[i][j] = temp.charAt(j); 	 
			 }	 
		 }
		 
		 //read the touched positions
		 for (int i = 0; i < boardSize; i++){
				
		     input = Main.ReadLn (255); //read a line of the board
			 idata = new StringTokenizer (input);
			 String temp = idata.nextToken();
			 
			 for (int j = 0; j < boardSize; j++){
				 //parse a line of the board
				 			
				 boardTouched[i][j] = temp.charAt(j); 	 
			 }	 
		 }	 
		 
		int[][] board =  checkBoard(boardMines, boardTouched, boardSize);
		
		if(isWinner(boardMines, boardTouched, boardSize) == false){
		detonateBoard(board, boardMines, boardSize);
		}
		//detonateBoard(board, boardMines, boardSize);
		printBoard(board, boardSize);
		
		if(numberofGames > 0){
			System.out.println();
			
		}
	 }//end while
	 //System.out.println();
 }//end begin

 void detonateBoard(int board[][], char boardM[][],int n){
	 
	 
	 for (int i = 0; i < n; i++){
	
		 for (int j = 0; j < n; j++){	
			 
			 if(boardM[i][j] == '*'){
				 board[i][j] = 98;	
			 }
			 
		 }
	 }

	 
 }
 boolean isWinner(char boardM[][],char boardT[][], int n){
	 
	 for (int i = 0; i < n; i++){
			
		 for (int j = 0; j < n; j++){	
		
			 if ((boardM[i][j] == '*') && (boardT[i][j] == 'x')){
				 return false;
			 }
			 
		 }
	 }
	 return true;
 }
 void printBoard(int board[][], int n){
	 
	 
	 for (int i = 0; i < n; i++){
			
		 for (int j = 0; j < n; j++){	
			 
			 
			 if(board[i][j] == 99){
				 System.out.print('.');
			 }
			 else if(board[i][j] == 98){
				 System.out.print('*');
			 }
			 else{
				 System.out.print(board[i][j]);
			 }
			 		 
		 	}
			System.out.println();
	}
 }

int[][] checkBoard(char boardM[][], char boardT[][], int n){
	
	
	int[][] board = new int[n][n];
	
	//check board for surrounding mines 
	 for (int i = 0; i < n; i++){
	
		 for (int j = 0; j < n; j++){	 
		 
//--------CHECK ALL DIAGONAL POSITIONS----------------------		 
			 //check upper left diagonal for a mine
			 if ((i-1 >= 0) && (j-1 >= 0)){
				 if(boardM[i-1][j-1] == '*'){
					 board[i][j]++;
				 }
			 }

			 //check lower left diagonal for a mine
			 if ((i+1 < n) && (j-1 >= 0)){
				 if(boardM[i+1][j-1] == '*'){
					 board[i][j]++;
				 }
			 }			 
			 
			 
			 //check upper right diagonal for a mine
			 if ((i-1 >= 0) && (j+1 < n)){
				 if(boardM[i-1][j+1] == '*'){
					 board[i][j]++;
				 }
			 }

			 //check lower right diagonal for a mine
			 if ((i+1 < n) && (j+1 < n)){
				 if(boardM[i+1][j+1] == '*'){
					 board[i][j]++;
				 }
			 }			 
//---------CHECK ABOVE AND BELOW-------------------------
			 
			 //check above for a mine
			 if (i-1 >= 0) {
				 if(boardM[i-1][j] == '*'){
					 board[i][j]++;
				 }
			 }

			 //check below for a mine
			 if (i+1 < n) {
				 if(boardM[i+1][j] == '*'){
					 board[i][j]++;
				 }
			 }			 
//---------CHECK LEFT AND RIGHT-------------------------		
			 
			 //check left for a mine
			 if (j-1 >= 0) {
				 if(boardM[i][j-1] == '*'){
					 board[i][j]++;
				 }
			 }

			 //check right for a mine
			 if (j+1 < n) {
				 if(boardM[i][j+1] == '*'){
					 board[i][j]++;
				 }
			 }				 
		 }//end inner for loop

	 }
	 
	 for (int i = 0; i < n; i++){
			
		 for (int j = 0; j < n; j++){	 
		 
		if(boardT[i][j] != 'x'){
			
			board[i][j] = 99; //place a dot on the board to be printed
		}
		//		
		if((boardT[i][j] == 'x') && (boardM[i][j] == '*')){
			
			board[i][j] = 98; //place a mine on the board to be printed
		}
			 
		 }
		 
	 }
	 
	 return board;
}



}//end Main class



