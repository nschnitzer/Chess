//****************************************
// Nathan & Ryan
// Bishop.java
// 10/11/18
// Represents a Bishop piece
//****************************************

import java.util.ArrayList;

/**
 * Creates an instance of a Bishop Piece
 * @author 120nschnitzer
 * @author 120rgiovanniello
 * @see Piece
 *
 */
public class Bishop extends Piece
{

	/**
	 * Constructs a Bishop Object
	 * @author 120nschnitzer
	 * @author 120rgiovanniello
	 * @param team1
	 * @see Piece
	 */
	public Bishop(boolean team1)
	{
		super(team1);
	}


	//Moves diagonally
	/**
	 * Moves the piece 
	 * @author 120nschnitzer
	 * @author 120rgiovanniello
	 */
	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated) throws InvalidMoveException, CheckmateException
	{

		//Check that the piece is moving diagonally
		//Ensure it moves diagonally
		if (Math.abs(r1-r2) != Math.abs(c1-c2))
		{
			throw new InvalidMoveException("Must Move Diagonally");
		}

		//Check for pieces in between
		//Check for when it moves up and right
		if (r1 - r2 > 0 && c1 - c2 < 0)
		{
			int x = 1;
			while (r1 + x - r2 > 0)
			{
				if (board[r1-x][c1+x].isTeamOne() == board[r1][c1].isTeamOne())
				{
					throw new InvalidMoveException("Piece in the way");
				}
				if (board[r1-x][c1+x] != null)
				{
					throw new InvalidMoveException("Piece in the way");
				}
				x++;
			}


			//Passed all exception catching
			//Check if king
			if (board[r2][c2].isKing())
			{
				throw new CheckmateException();
			}
			eliminated.add(board[r2][c2]);
			board[r2][c2] = board[r1][c1];
			return;
		}

		//Check for when it moves up and left
		if (r1 - r2 > 0 && c1 - c2 > 0)
		{
			int x = 1;
			while (r1+x-r2 < 0)
			{
				if (board[r1-x][c1-x].isTeamOne() == board[r1][c1].isTeamOne())
				{
					throw new InvalidMoveException("Piece in the way");
				}
				if (board[r1-x][c1-x] != null)
				{
					throw new InvalidMoveException("Piece in the way");
				}
				x++;
			}

			//Passed all exception catching
			if (board[r2][c2].isKing())
			{
				throw new CheckmateException();
			}
			eliminated.add(board[r2][c2]);
			board[r2][c2] = board[r1][c1];
			board[r1][c1] = null;
			return;
		}
		
		//Check for when it moves down and left
		if (r1-r2 < 0 && c1 - c2 > 0)
		{
			int x = 1;
			while (r1-x-r2 < 0)
			{
				if (board[r1+x][c1-x].isTeamOne() == board[r1][c1].isTeamOne())
				{
					throw new InvalidMoveException("Piece in the way");
				}
				if (board[r1+x][c1-x] != null)
				{
					throw new InvalidMoveException("Piece in the way");
				}
				x++;
			}
			
			//Passed all invalid move exception catching
			if (board[r2][c2].isKing())
			{
				throw new CheckmateException();
			}
			eliminated.add(board[r2][c2]);
			board[r2][c2] = board[r1][c1];
			board[r1][c1] = null;
			return;
		}
		
		//Check for when it moves down and right
		if (r1-r2 < 0 && c1-c2 < 0)
		{
			int x = 1;
			while (r1+x-r2 > 0)
			{
				if (board[r1+x][c1+x].isTeamOne() == board[r1][c1].isTeamOne())
				{
					throw new InvalidMoveException("Piece in the way");
				}
				if (board[r1+x][c1+x] != null)
				{
					throw new InvalidMoveException("Piece in the way");
				}
				x++;
			}
			
			//Passed all invalid move exception catching
			if (board[r2][c2].isKing())
			{
				throw new CheckmateException();
			}
			eliminated.add(board[r2][c2]);
			board[r2][c2] = board[r1][c1];
			board[r1][c1] = null;
			return;
		}

	}


	public String toString()
	{
		if (super.isTeam1 == true)
			return "1B";
		else
			return "2B";
	}
	
	//Returns the name of the piece
	public String getName()
	{
		return "Bishop";
	}

}
