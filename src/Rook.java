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
	public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated)
	{

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
