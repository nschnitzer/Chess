import java.util.ArrayList;

//****************************************************************
// Nathan & Ryan
// Piece.java
// 10/11/18
// Abstract Class for Chess Pieces
//****************************************************************

/**
 * Abstract Class that represents Chess Pieces
 * @author 120nschnitzer
 * @author 120rgiovanniello
 */
abstract public class Piece 
{
  boolean isTeam1;
  public boolean king = false;
  public boolean pawn = false;
  
  //Constructor
  /**
   * Constructs a piece
   * Determines if team1 is true or false
   * @author 120nschnitzer
   * @author 120rgiovanniello
   * @param team1
   */
  public Piece(boolean team1)
  {
    isTeam1 = team1;
  }
  
  /**
   * Reuturns if the piece is player one's
   * @author 120nschnitzer
   * @author 120rgiovanniello
   * @return
   */
  public boolean isTeamOne()
  {
	  return isTeam1;
  }
  
  //Abstract method for move - In Piece class this time, not in Board
  // Must define according to the piece
  /**
   * Abstract method for Move - Moves piece as defined by the child class
   * @author 120nschnitzer
   * @author 120rgiovanniello
   * @param r1
   * @param c1
   * @param r2
   * @param c2
   * @param board
   * @param eliminated
   * @throws InvalidMoveException
   * @throws CheckmateException
   */
  abstract public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> eliminated) throws InvalidMoveException, CheckmateException;
 
  //For Pawn Use only
  //Need to oberride in Pawn Class
  //abstract public void move(int r1, int c1, int r2, int c2, Piece[][] board, ArrayList<Piece> p1Eliminated, ArrayList<Piece> p2Eliminated) throws InvalidMoveException, CheckmateException;
  
  /**
   * Returns a String representing the piece and team
   * @author 120nschnitzer
   * @author 120rgiovanniello
   * @return
   */
  abstract public String toString();
  
  /**
   * Returns the name of the piece
   * @author 120nschnitzer
   * @author 120rgiovanniello
   * @return
   */
  abstract public String getName();
  
  //Returns if it is a king
  /**
   * Returns if the piece is a king
   * @author 120nschnitzer
   * @author 120rgiovanniello
   * @return
   */
  public boolean isKing()
  {
	  return king;
  }
  
  //Returns if it is a pawn
  /**
   * Returns if it the piece is a pawn
   * @author 120nschnitzer
   * @author 120rgiovanniello
   * @return
   */
  public boolean isPawn()
  {
	  return pawn;
  }
}
