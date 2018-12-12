//**************************************************
// Nathan & Ryan
// RetreivePieceException.java
// 10/18/18
// Throws when a pawn reaches the opposite side
//*********************************************

public class RetreivePieceException extends Exception
{
	//No Message
	public RetreivePieceException()
	{
		super();
	}
	
	//With Message
	public RetreivePieceException(String s)
	{
		super(s);
	}

}
