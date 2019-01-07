//*******************************************************************
// Nathan & Ryan (and Ishma!!)
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

		// TO DO LIST:
		// - FIX KNIGHT EATING + MOVING KNIGHT ON PLAYER 2 TURN
		//	Scanner scan = new Scanner(System.in);
		String continueGame = "y";
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("src/inputs.txt"));
		StringTokenizer tokenizer;
		Board board = new Board();

		System.out.println("==================== Welcome to Chess! ====================");

		board.printBoard();
		int counter = 1;

		//counter++;

		while(continueGame.equalsIgnoreCase("y")) //Will continue game until said otherwise
		{
			// Counter 
			int p1 = -1, p2 = -1, p3 = -1, p4 = -1;
			boolean isTeamOne;
			boolean lcv = true;

			while (lcv)
			{

				lcv = false;
				//Scanner scan = new Scanner(new File("src/inputs.txt"));

				//Asking for input

				if (counter % 2 == 1)
				{
					System.out.println(" -------=== It is currently Team 1's Turn! ===------- ");
					System.out.println("Enter the coordinates to the piece you would like to move and the coordinates you would like to move them to: (Format: row1 column1 row2 column2) ");
					counter++;

				} //end if
				else 
				{
					System.out.println(" -------=== It is currently Team 2's Turn! ===------- ");
					System.out.println("Enter the coordinates to the piece you would like to move and the coordinates you would like to move them to: (Format: row1 column1 row2 column2 ");
					counter++;
				}
				tokenizer = new StringTokenizer(scan.nextLine());
				
				//Exceptions
				try 
				{

					p1 = Integer.parseInt(tokenizer.nextToken());

					String play2 = tokenizer.nextToken();
					if (play2.equalsIgnoreCase("A"))
					{
						p2 = 0;
					}
					else if (play2.equalsIgnoreCase("B"))
					{
						p2 = 1;
					}
					else if (play2.equalsIgnoreCase("C"))
					{
						p2 = 2;
					}
					else if (play2.equalsIgnoreCase("D"))
					{
						p2 = 3;
					}
					else if (play2.equalsIgnoreCase("E"))
					{
						p2 = 4;
					}
					else if (play2.equalsIgnoreCase("F"))
					{
						p2 = 5;
					}
					else if (play2.equalsIgnoreCase("G"))
					{
						p2 = 6;
					}
					else if (play2.equalsIgnoreCase("H"))
					{
						p2 = 7;
					}

					p3 = Integer.parseInt(tokenizer.nextToken());

					String play4 = tokenizer.nextToken();

					if (play4.equalsIgnoreCase("A"))
					{
						p4 = 0;
					}
					else if (play4.equalsIgnoreCase("B"))
					{
						p4 = 1;
					}
					else if (play4.equalsIgnoreCase("C"))
					{
						p4 = 2;
					}
					else if (play4.equalsIgnoreCase("D"))
					{
						p4 = 3;
					}
					else if (play4.equalsIgnoreCase("E"))
					{
						p4 = 4;
					}
					else if (play4.equalsIgnoreCase("F"))
					{
						p4 = 5;
					}
					else if (play4.equalsIgnoreCase("G"))
					{
						p4 = 6;
					}
					else if (play4.equalsIgnoreCase("H"))
					{
						p4 = 7;
					}

					if (counter % 2 == 1)
					{
						board.prepMove(p1-1, p2, p3-1, p4, false);

					} //end if
					else 
					{
						board.prepMove(p1-1, p2, p3-1, p4, true);
					}
					System.out.println("You entered the following coordinates: "+ p1 + " " + play2 + " " + p3 + " " + play4);



				}
				catch (CheckmateException e)
				{
					System.out.println("You are checkmated");
					break;
				} 
				catch (InvalidMoveException e)
				{
					System.out.println("ERROR: Invalid Move!");
					e.printStackTrace();
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
			//counter++;
			lcv = true;
		} // end while loop








	}

}
