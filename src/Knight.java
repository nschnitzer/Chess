//****************************************
// Nathan & Ryan
// Knight.java
// 10/11/18
// Represents a Knight piece
//****************************************

import java.util.ArrayList;

public class Knight extends Piece
{

	public Knight(boolean team1)
	{
		super(team1);
	}

	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated) throws InvalidMoveException, CheckmateException
	{
		if (board[r2][c2] != null)
		{
			if (board[r1][c1].isTeamOne() == board[r2][c2].isTeamOne())//if the new piece location is the same team as the current piece
			{
				throw new InvalidMoveException();
			}
			else if ((Math.abs(c1-c2) == 2 && Math.abs(r1-r2) == 1) || (Math.abs(c1-c2) == 1 && Math.abs(r1-r2) == 2))
			{
				//must be enemy piece

				if (board[r1][c1].isTeamOne() && board[r2][c2].isTeamOne() == false)//if team 1 captures team 2
				{
					eliminated.add(board[r2][c2]);
				}
				else if (board[r1][c1].isTeamOne() == false && board[r2][c2].isTeamOne())//if team 2 captures team 1
				{
					eliminated.add(board[r2][c2]);
				}
				else
				{
					throw new InvalidMoveException();
				}

				board[r2][c2] = board[r1][c1];
				board[r1][c1] = null;
			}
			else
			{
				throw new InvalidMoveException();
			}
		}
		else
		{
			
				board[r2][c2] = board[r1][c1];
				board[r1][c1] = null;
		}

	}

	public String getName()
	{
		return "Knight";
	}


	public String toString()
	{
		if (super.isTeam1 == true)
			return "1k";
		else
			return "2k";
	}
}