//***********************************************************
// Nathan Schnitzer
// Board.java
// 10/11/18
// Represents the chess board
//***********************************************************

import java.util.*;

public class Board 
{
	//Board
	private Piece[][] board = new Piece[8][8];
	private final int SIZE = 7;
	public int counter = 0;
	ArrayList<Piece> p1Eliminated = new ArrayList<Piece>();
	ArrayList<Piece> p2Eliminated = new ArrayList<Piece>();

	//Constructor - Initialize the board
	//Similar to Checkers Initialization
	public Board()
	{
		//Top will be team 1
		for (int i = 0; i < 3; i++)
		{
			for (int k = 0; k < 4; k++)
			{
				//Pawns
				if (i == 1)
				{
					board[i][k] = new Pawn(true); //Top Right
					board[i][SIZE-k] = new Pawn(true); //Top Left
					board[SIZE-i][SIZE-k] = new Pawn(false); //Bottom Left
					board[SIZE-i][k] = new Pawn(false); //Bottom Right
					continue;
				}

				//Null spaces
				if (i == 2)
				{
					board[i][k] = null; //Top Right
					board[i][SIZE-k] = null; //Top Left
					board[SIZE-i][SIZE-k] = null; //Bottom Left
					board[SIZE-i][k] = null; //Bottom Right

					board[i+1][k] = null; //Top Right
					board[i+1][SIZE-k] = null; //Top Left
					board[SIZE-i-1][SIZE-k] = null; //Bottom Left
					board[SIZE-i-1][k] = null; //Bottom Right
				}
				//Rooks
				if (i == 0 && k == 0)
				{
					board[i][k] = new Rook(true); //Top Left
					board[SIZE - i][k] = new Rook(false); //Bottom Left
					board[i][SIZE] = new Rook(true); //Top Right
					board[SIZE][SIZE] = new Rook(false); //Bottom Right
					continue;
				}

				//Knights
				if (i == 0 && k == 1)
				{
					board[i][k] = new Knight(true); //Top Left
					board[SIZE - i][k] = new Knight(false); //Bottom Left
					board[i][SIZE-k] = new Knight(true); // Top Right
					board[SIZE][SIZE-k] = new Knight(false); //Bottom Right
					continue;
				}

				//Bishops
				if (i == 0 && k == 2)
				{
					board[i][k] = new Bishop(true); //Top Left
					board[SIZE][k] = new Bishop(false); //Bottom Left
					board[i][SIZE-k] = new Bishop(true); //Top Right
					board[SIZE][SIZE-k] = new Bishop(true); //Bottom Right
					continue;
				}

				//King/Queen
				if (i == 0 && k == 3)
				{
					board[i][k] = new Queen(true); //Top Left
					board[SIZE][k] = new Queen(false); //Bottom Left
					board[i][SIZE-k] = new King(true); //Top Right
					board[SIZE][SIZE-k] = new King(false); //Bottom Right
				}

			}
		}
	}

	//Prints out the board
	public void printBoard()
	{
		//Top Legend
		System.out.print("\t");
		for (int i = 0; i <= SIZE; i++) //Top legend
		{
			System.out.print(i + "\t");
		}


		System.out.println();
		for (int i = 0; i <= SIZE; i++)
		{
			System.out.print(i + "\t");
			for (int k = 0; k <= SIZE; k++)
			{
				if (board[i][k] == null)
				{
					System.out.print("--\t");
				}
				else
					System.out.print(board[i][k].toString() + "\t");
			}
			System.out.println();
		}
	}

	//Finds piece
	public Piece findPiece(int x, int y) throws InvalidMoveException
	{
		if (x < 0 || x > SIZE || y < 0 || y > SIZE)
		{
			throw new InvalidMoveException("Piece Out of Bounds");
		}
		return board[x][y];
	}

	//Calls move method of associated piece
	//Check if starting loc piece exists
	//Wrong Team Exception and Out of Bounds check
	public void prepMove(int x1, int y1, int x2, int y2) throws WrongTeamException, InvalidMoveException, CheckmateException
	{
		Piece p1, p2;
		try
		{
			p1 = findPiece(x1,y1);
			p2 = findPiece(x2,y2);
		}
		catch(InvalidMoveException e)
		{
			throw new InvalidMoveException(e.getMessage());
		}

		if (p1 == null)
		{
			throw new InvalidMoveException("Starting Piece is null");
		}

		//Note: Check pieces in between in specific piece class
		if (p1.isTeamOne() == p2.isTeamOne())
		{
			throw new WrongTeamException("Same Team");
		}

		//Passed Initial Exception Checking
		if (p1.isTeamOne())
		{
			try
			{
				p1.move(x1, y1, x2, y2, board, p2Eliminated);
			}
			catch (CheckmateException e) //Winner
			{
				throw new CheckmateException(); //Handle in driver
			}
			catch (InvalidMoveException e) //Handle in driver
			{
				throw new InvalidMoveException(e.getMessage());
			}
			
		}
	}

}
