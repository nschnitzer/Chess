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
	public void move(int x1, int y1, int x2, int y2, Piece[][] board, ArrayList<Piece> eliminated)
	{
		

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
