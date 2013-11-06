package week05;

import java.util.Random;

/**
 * This is a guided programming assignment
 * It will use enumerations, arrays, selection and repetition.
 * Review the TestCaseVegas.java code
 * @author korbenc
 *
 */
public class LasVegasGame
{	
	/**
	 * Enumeration of valid guesses
	 * @author scottl
	 *
	 */
	public enum GUESS
	{
		BETWEEN,
		NOT_BETWEEN
	}
	/**
	 * Constructor
	 */
	public LasVegasGame()
	{
		m_random = new Random();
	}
	
	public void startSession()
	{
		m_lowInt = 0;  // low number
	    m_hiInt = 0;   // high number
	    m_nextInt = 0; // next random number
	    m_winners = 0; // number of wins
	    m_losers = 0;  // number of losses
	}
	
	/**
	 * Starts a new guessing session
	 * @return An array of two ints. int[0] = lo, int[1]=hi
	 */
	public int[] startGame()
	{
		generateRandomInts();
		
		// Note how we are initializing the return array
		int[] range = new int[]{m_lowInt, m_hiInt};
		return range;
	}
	
	/**
	 * This method uses the &&, !, || and enumerations to determine 
	 * whether the guess is a winner or not.
	 * @param guess
	 * @return
	 */
	public boolean guess(GUESS guess)
	{
		// get the next random it.
		m_nextInt = m_random.nextInt(MAX_RANGE);
		
		// Determine if the user won or lost and update the 
		// won/lost counters
		// TODO
		if(m_nextInt > m_lowInt && m_nextInt < m_hiInt && guess == guess.BETWEEN)
		{
			m_gameWon = true;
		}
		else if(m_nextInt > m_hiInt || m_nextInt < m_lowInt && guess == guess.NOT_BETWEEN)
		{
			m_gameWon = true;
		}
		else if (m_nextInt > m_lowInt && m_nextInt < m_hiInt  && guess == guess.NOT_BETWEEN)
		{
			m_gameWon = false;
		}
		else if(m_nextInt > m_hiInt || m_nextInt < m_lowInt && guess == guess.BETWEEN)
		{
			m_gameWon = false;
		}
		//throw new RuntimeException("Not Implemented");	
		if(m_gameWon == true)
		{
			m_winners++;
		}
		else if(m_gameWon == false)
		{
			m_losers++;
		}
        return m_gameWon; 
	}

    /**
     * Returns the summary of wins and losses
     * 
     * @return Formatted string of wins and losses
     */
    public String endGame()
    {
        return String.format(END_GAME, m_winners, m_losers);
    }
    
    public int getWinnerCount()
    {
		// TODO
    	return m_winners;
		//throw new RuntimeException("Not Implemented");	
    }
    
    public int getLosersCount()
    {
		// TODO
    	return m_losers;
		//throw new RuntimeException("Not Implemented");	
    }
	
    /**
     * Generate two random integers and assign
     * them to m_lowInt and m_hiInt respectively
     */
	private void generateRandomInts()
	{
		// TODO
		m_lowInt = m_random.nextInt(100) + 1;
		m_hiInt = m_random.nextInt(100) + 1;
		
		if (m_lowInt > m_hiInt)
		{
			int temp = m_lowInt;
			m_lowInt = m_hiInt;
			m_hiInt = temp;
		}
		//throw new RuntimeException("Not Implemented");	
	}
	
	private int m_lowInt = 0;  // low number
    private int m_hiInt = 0;   // high number
    private int m_nextInt = 0; // next random number
    private int m_winners = 0; // number of wins
    private int m_losers = 0;  // number of losses
    private boolean m_gameWon; // Indicates if
    private Random m_random;
    private static final int MAX_RANGE = 100; // max range 
    private static final String END_GAME = "Winners: %d, Losers: %d";
}
