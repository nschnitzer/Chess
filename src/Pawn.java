//****************************************
// Nathan & Ryan
// Pawn.java
// 10/11/18
// Represents a pawn piece
//****************************************

import java.util.ArrayList;

public class Pawn extends Piece
{
	boolean firstMove = true;

	public Pawn(boolean team1)
	{
		super(team1);
		super.pawn = true;
	}


	/**
	 * Just fulfills the inheritance requirement... Use overloaded move method
	 * @author 120nschnitzer
	 * @author 120rgiovanniello
	 * @param r1
	 * @param c1
	 * @param r2
	 * @param c2
	 * @param board
	 * @param eliminated
	 * @throws InvalidMoveException
	 * @throws CheckmateException
	 */
	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated)
	{

	}

	//checks if it moves in the correct direction and if it can move the proper number of spaces
	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> p1Eliminated, ArrayList<Piece> p2Eliminated) throws InvalidMoveException, CheckmateException
	{
		if (firstMove == true)
		{
			if (c1 != c2)
			{
				throw new InvalidMoveException();
			}
			if (Math.abs(r1 - r2) <= 2)
			{
				board[r2][c2] = board[r1][c1];
				board[r1][c1] = null;
			}
			else
			{
				throw new InvalidMoveException();
			}
		}//end large if
		else if (Math.abs(r1 - r2) > 1)
		{
			throw new InvalidMoveException();
		}
		else if (c1 == c2 && board[r2][c2] == null)//moving forward one space
		{
			if (board[r1][c1].isTeamOne() && r1 - r2 == -1) //if moves down 1
			{
				board[r2][c2] = board[r1][r2];
				board[r1][r2] = null;
			}
			else if (board[r1][c1].isTeamOne() == false && r1 - r2 == 1)//if moves up 1
			{
				board[r2][c2] = board[r1][r2];
				board[r1][r2] = null;
			}
			else
			{
				throw new InvalidMoveException();
			}
		}
		//end large else
		else if (board[r2][c2].isTeamOne() != board[r1][c1].isTeamOne()) //if enemy piece
		{
			if (board[r2][c2]!= null)
			{
				if(r1-r2 == -1 && board[r2][c2].isTeamOne())//captures team 2 piece
				{
					p2Eliminated.add(board[r2][c2]);
				}
				else
				{
					if (r1-r2 == 1 && board[r2][c2].isTeamOne())//captures team 1 piece
					{
						p1Eliminated.add(board[r2][c2]);
					}
					else
					{
						throw new InvalidMoveException();
					}
				}
			}//end outer if
			else
			{
				throw new InvalidMoveException();
			}
		}
		else
		{
			throw new InvalidMoveException();
		}
		if (board[r2][c2].isKing())
		{
			throw new CheckmateException();
		}

		firstMove = false;
	}

	public String toString()
	{
		if (super.isTeamOne() == true)
			return "1P";
		else
			return "2P";
	}
	public String getName()
	{
		return "Pawn";
	}

}