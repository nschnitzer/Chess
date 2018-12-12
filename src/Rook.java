//****************************************
// Nathan & Ryan
// Rook.java
// 10/11/18
// Represents a Rook piece
//****************************************

import java.util.ArrayList;

public class Rook extends Piece
{
	//Constructor
	public Rook(boolean team1)
	{
		super(team1);
	}

	//Moves the piece
	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated) throws InvalidMoveException, CheckmateException
	{
		System.out.println("entering move");
		if (board[r1][c1].isTeamOne() == board[r2][c2].isTeamOne())     
		{
			System.out.println("testtkjgjkbbj");
			throw new InvalidMoveException();
		}
		else if((Math.abs(c1-c2) <= 7) && r1 == r2 || c1 == c2 && Math.abs(r1-r2) <= 7)
		{
			System.out.println("Inside else if");
			if (board[r2][c2] == null)
			{
				board[r2][c2] = board[r1][c1];
				board[r1][c1] = null;
			}
			else
			{
				if(board[r1][c2].isTeamOne() && board[r2][c2].isTeamOne() == false)
				{
					eliminated.add(board[r2][c2]);
				}
				else if (board[r1][c1].isTeamOne() == false && board[r2][c2].isTeamOne())
				{
					eliminated.add(board[2][c2]);
				}
				else
				{
					throw new InvalidMoveException();
				}
				
				board[r2][c2] = board[r1][c1];
				board[r1][c1] = null;
			}
		}
		
	}
	
	
	//Rook Coffee
	public void serveCoffee()
	{
		System.out.println("Here's your coffee!");
	}

	//Returns a string representing the piece
	public String toString()
	{
		if (super.isTeam1 == true)
			return "1R";
		else
			return "2R";
	}
	
	//Returns the name of the piece
	public String getName()
	{
		return "Rook";
	}
}
