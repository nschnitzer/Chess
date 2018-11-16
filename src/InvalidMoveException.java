//*****************************************************
// Nathan Schnitzer
// InvalidMoveException.java
// 10/15/18
// gets thrown when an invalid move is played
//*****************************************************

public class InvalidMoveException extends Exception
{
	//No Message
	public InvalidMoveException()
	{
		super();
	}
	
	//With a Message
	public InvalidMoveException(String s)
	{
		super(s);
	}

}
