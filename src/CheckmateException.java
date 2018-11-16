//**************************************************
// Nathan & Ryan
// CheckmateException.java
// 10/16/18
// Gets thrown if there is a winner
//**************************************************

public class CheckmateException extends Exception
{
	//NO MESSAGE
	public CheckmateException()
	{
		super();
	}
	
	//With Message
	public CheckmateException(String s)
	{
		super(s);
	}

}
