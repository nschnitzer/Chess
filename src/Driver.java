//*******************************************************************
// Nathan & Ryan
// Driver.java
// 10/15/18
// Driver
//*******************************************************************

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Driver {

	public static void main(String[] args) throws IOException, CheckmateException, WrongTeamException, InvalidMoveException, RetreivePieceException, NoSuchElementException
	{
		//	Scanner scan = new Scanner(System.in);
		String continueGame = "y";
		Board board = new Board();
		int counter = 1;
		boolean isTeamOne = true;



		while(continueGame.equalsIgnoreCase("y")) //Will continue game until said otherwise
		{
			// Counter 
			if (counter % 2 == 0)
			{
				isTeamOne = true;					
				System.out.println("It is currently Team 2's Turn! || Round " + counter);
				counter++;

			}
			else
			{
				isTeamOne = false;
				System.out.println("It is currently Team 1's Turn! || Round " + counter);
				counter++;
			}



			//Scanner scan = new Scanner(new File("src/inputs.txt"));
			Scanner scan = new Scanner(System.in);

			StringTokenizer tokenizer;

			//Asking for input
			board.printBoard();
			System.out.println("Enter the coordinates to the piece you would like to move and the coordinates you would like to move them to: (Format: row1 column1 row2 column2 ");
			tokenizer = new StringTokenizer(scan.nextLine());

			int p1, p2, p3, p4;

			p1 = Integer.parseInt(tokenizer.nextToken());
			p2 = Integer.parseInt(tokenizer.nextToken());
			p3 = Integer.parseInt(tokenizer.nextToken());
			p4 = Integer.parseInt(tokenizer.nextToken());



			//	System.out.println(isTeamOne); //Testing


			//Exceptions
			try 
			{
				board.prepMove(p1, p2, p3, p4, true);

			}
			catch (CheckmateException e)
			{
				System.out.println("You are in checkmate! Go again!");
				counter--;
				continue;
			} 
			catch (InvalidMoveException e)
			{
				System.out.println("ERROR: Invalid Move!");
				counter--;
				continue;
			}
			catch (WrongTeamException e)
			{
				System.out.println("ERROR: It's not your turn!");
				counter--;
				continue;
			}
			catch (NoSuchElementException e)
			{
				System.out.println("ERROR: Invalid input!");
				counter--;
				continue;
			}




		}

		board.printBoard();
	}

}
