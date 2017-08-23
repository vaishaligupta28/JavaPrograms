/*
Functional Programs: Program 14

@Created by : Vaishali Gupta(QT8)
*/

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame
{
     private static char player1 = 'O';
     private static char player2 = 'X';
	public static void main(String args[])
	{
		createBoard myGame = new createBoard();
		myGame.display();

          int counter = 1;
          while(myGame.isActive())
          {
               if(counter % 2 == 0)
                    myGame.askPlayer(player1);
               else
                    myGame.askPlayer(player2);
               counter++;
               myGame.display();
               if(myGame.checkForWinner())
                    System.exit(0);
               if(counter == 10)
               {
                    System.out.println("Tie Situation!!Stalemate");
                    System.exit(0);
               }
          }
	}
}


class createBoard
{
	private char gameBoard[][];
     private boolean gameActive = true;
     public createBoard()	
     {
     	 gameBoard = new char[3][3];

     	 //filling the board with spaces
     	for(int row=0;row<gameBoard.length;row++)
     		Arrays.fill(gameBoard[row], ' ');
     }

     /**
     *Method to display the Board 
     */
     public void display()
     {
          System.out.println("\n");
     	for(int row=0;row<gameBoard.length;row++){
     		for(int col=0;col<gameBoard[0].length;col++){
     			System.out.print("     "+gameBoard[row][col] + " ");
     			if(col == 0 || col == 1)
     				System.out.print(" |");
     		}
               if(row == 0 || row == 1)
     		System.out.print("\n   ~~~~~~~~~~~~~~~~~~~~~~~\n");
               else
                    System.out.println("\n\n");   
     	}	
     }

     /**
     * Validates whether the player is allowed to add in a position
     **/
     public boolean makeMove(char player, int row, int col)
     {
          if(row >= 0 && row <= 2 && col >= 0 && col <= 2)
          {
             if(gameBoard[row][col] != ' ')
                 return false;
             else
             {
               gameBoard[row][col] = player;
               return true;
             }
          }
          else
             return false;
     }

     /**
     * This method checks if the game is still active
     **/
     public boolean isActive()
     {
          return gameActive;
     }

     public void askPlayer(char player)
     {
          Scanner sc = new Scanner(System.in);
          int row, col;
          do{
               System.out.print("Player "+ player + ", Enter a row[1-3]:  ");
               row = sc.nextInt();
               System.out.print("Player "+ player + ", Enter a col[1-3]:  ");
               col = sc.nextInt();
          }
          while(notValid(row, col));
          makeMove(player, row-1, col-1);   
     }

     public boolean notValid(int row, int col)
     {
          if(row > 3 || row < 1 || col > 3 || col < 1)
               {System.out.println("Invalid input!!Try again");return true;}

          else if(!isEmpty(row, col))
               return true;
          else
               return false;
     }

     public boolean isEmpty(int row, int col)
     {
          if(gameBoard[row-1][col-1] == ' ')
               return true;
          else
               System.out.println("Position already taken!");
               return false;
     }

     /**
     *  Methods for the conditions for winner
     **/
     public boolean checkForWinner()
     {
          //loop over each row and check for the winner - for row and column winner
          for(int row=0;row<3;row++)
          {
               if((gameBoard[row][0] == gameBoard[row][1]) && (gameBoard[row][1] == gameBoard[row][2]) && (gameBoard[row][0] != ' '))
               {
                    System.out.println("Winner is "+ player(gameBoard[row][0]));
                    return true;
               }
          }
          for(int col=0;col<gameBoard[0].length;col++)
          {
               if(gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] != ' ')
               {
                   System.out.println("Winner is "+ player(gameBoard[col][0]));
                   return true;
               }
          }

          //loop for the diagonals
          if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ')
          {
               System.out.println("Winner is "+ player(gameBoard[0][0]));
               return true;
          }

          if(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != ' ')
          { 
               System.out.println("Winner is "+ player(gameBoard[2][0]));
               return true;
          }

          return false;
     }
     
     public String player(char c){

         if(c=='O')
               return "Player 1 ";
         else 
               return "Player 2" ;
     }


}
