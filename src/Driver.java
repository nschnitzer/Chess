//*******************************************************************
// Nathan & Ryan
// Driver.java
// 10/15/18
// Driver
//*******************************************************************

import java.util.Scanner;
import java.io.*;

public class Driver {

	public static void main(String[] args) throws IOException, CheckmateException, WrongTeamException, InvalidMoveException
	{
		//Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner(new File("src/inputs.txt"));
		Board board = new Board();
		board.printBoard();

	}

}
