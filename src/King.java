//****************************************
// Nathan & Ryan
// King.java
// 10/11/18
// Represents a King piece
//****************************************

import java.util.ArrayList;

public class King extends Piece
{
	//Constructor
	public King(boolean team1)
	{
		super(team1);
		super.king = true;
	}

	//Moves the piece
	public void move(int x1, int y1, int x2, int y2, Piece[][] board, ArrayList<Piece> eliminated) throws InvalidMoveException, CheckmateException
	{
		if (board [x1][y1].isTeamOne() == board[x2][y2].isTeamOne())
		{
			throw new InvalidMoveException();
		}
		else if (Math.abs(x1-x2) <= 1 && Math.abs(y1- y2) <= 1)
		{
				if (board[x2][y2] == null)
				{
					board[x2][y2] = board[x1][y1];
					board[x1][y1] = null;
				}
				else if (board[x1][y1].isTeamOne() && board[x2][y2].isTeamOne() == false)
				{
					eliminated.add(board[x2][y2]);
				}
		}
			else
			{
				throw new InvalidMoveException();
			}
		}
			

	}
	
	//Returns a string representing the piece
	public String toString()
	{
		if (super.isTeam1 == true)
			return "1K";
		else
			return "2K";
	}
	
	//Returns the name of the piece
	public String getName()
	{
		return "King";
	}
}
