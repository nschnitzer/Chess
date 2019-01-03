//****************************************
// Nathan & Ryan (and Ishma!!)
// Queen.java 
// 10/11/18
// Represents a Queen piece
//****************************************

import java.util.ArrayList;

public class Queen extends Piece
{

	public Queen(boolean team1)
	{
		super(team1);
	}

	/**
	 * Moves the queen. Can move any number of spaces in any direction
	 * @author 120nschnitzer
	 * @author 120rgionnaviello
	 * @param r1
	 * @param c1
	 * @param r2
	 * @param c2
	 * @param board
	 * @param eliminated
	 */
	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated) throws InvalidMoveException, CheckmateException
	{
		//Handle Diagonal movement
		//Literally same code as Bishop
		//Checks for diagonal movement

		if (board[r2][c2] != null)
		{
			//Check that the piece is moving diagonally
			//Ensure it moves diagonally
			if (Math.abs(r1-r2) != Math.abs(c1-c2))
			{
				throw new InvalidMoveException("Must Move Diagonally");
			}
			if (board[r1][c1].isTeamOne() == board[r2][c2].isTeamOne())
			{
				throw new InvalidMoveException();
			}
		}
		
		//if (Math.abs(r1-r2) != Math.abs(c1-c2))
		//{
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
				if (board[r2][c2] != null && board[r2][c2].isKing())
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
				if (board[r2][c2] != null && board[r2][c2].isKing())
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
		//}

		//Handles Horizontal Movement
		if (r1-r2 == 0 && c1-c2 != 0)
		{
			//If moving left
			if (c1 - c2 < 0)
			{
				int x = 1;
				while (c1 + x < c2)
				{
					//If there are pieces blocking
					if (board[r1][c1+x].isTeamOne() == board[r1][c1].isTeamOne())
					{
						throw new InvalidMoveException("Piece in the way");
					}
					if (board[r1][c1+x] != null)
					{
						throw new InvalidMoveException("Piece in the way");
					}
					x++;
				}
			}

			//If moving right
			if (c1 - c2 > 0)
			{
				int x = 1;
				while (c1-x > c2)
				{
					//If there are pieces blocking
					if (board[r1][c1-x].isTeamOne() == board[r1][c1].isTeamOne())
					{
						throw new InvalidMoveException("Piece in the way");
					}
					if (board[r1][c1-x] != null)
					{
						throw new InvalidMoveException("Piece in the way");
					}
					x++;
				}
			}
			//Passed the exception catching
			//Check if capturing king
			if (board[r2][c2].isKing())
			{
				throw new CheckmateException();
			}
			eliminated.add(board[r2][c2]);
			board[r2][c2] = board[r1][c1];
			board[r1][c1] = null;
		}

		//Handles Vertical Movement
		if (r1-r2 != 0 && c1-c2 == 0)
		{
			//If moving up
			if (r1 - r2 > 0)
			{
				int x = 1;
				while (r1 - x > r2)
				{
					//If there are pieces blocking
					if (board[r1-x][c1].isTeamOne() == board[r1][c1].isTeamOne())
					{
						throw new InvalidMoveException("Piece in the way");
					}
					if (board[r1-x] != null)
					{
						throw new InvalidMoveException("Piece in the way");
					}
					x++;
				}
			}

			//If moving down
			if (r1 - r2 < 0)
			{
				int x = 1;
				while (r1 + x < r2)
				{
					//If there are pieces in the way
					if (board[r1+x][c1].isTeamOne() == board[r1][c1].isTeamOne())
					{
						throw new InvalidMoveException("Piece in the way");
					}
					if (board[r1+x] != null)
					{
						throw new InvalidMoveException("Piece in the way");
					}
				}
			}

			//Passed exception checking
			//Check if capturing king
			if (board[r2][c2] != null)
			{
				if (board[r2][c2].isKing())
				{
					throw new CheckmateException();
				}
			}
			
			eliminated.add(board[r2][c2]);
			board[r2][c2] = board[r1][c1];
			board[r1][c1] = null;
		}
	}

	public String toString()
	{
		if (super.isTeam1 == true)
			return "1Q";
		else
			return "2Q";
	}

	//Returns the name of the piece
	public String getName()
	{
		return "Queen";
	}
}
