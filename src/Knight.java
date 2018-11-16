//****************************************
// Nathan & Ryan
// Knight.java
// 10/11/18
// Represents a Knight piece
//****************************************

import java.util.ArrayList;

public class Knight extends Piece
{
	//Constructor
	public Knight(boolean team1)
	{
		super(team1);
	}

	//Moves the piece
	//Moves in an L shape
	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated)
	{

	}

	public String toString()
	{
		if (super.isTeam1 == true)
			return "1k";
		else
			return "2k";
	}

	//Returns the name of the piece
	public String getName()
	{
		return "Knight";
	}
}
