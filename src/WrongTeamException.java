//***********************************************
// Nathan & Ryan
// WrongTeamException.java
// 10/15/18
// Gets thrown when the player chooses a piece that isnt his
//************************************************

public class WrongTeamException extends Exception
{

	//No Message
	public WrongTeamException()
	{
		super();
	}
	
	//With Message
	public WrongTeamException(String s)
	{
		super(s);
	}
}
