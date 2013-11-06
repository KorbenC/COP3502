package week08;

import java.util.Random;

public class FermiGame {

	private String m_fermi;
	private String m_pico;
	private String m_nano;
	
	private static String FERMI;
	private static String NANO;
	private static String PICO;
	
	private static int MAX;
	private static int MIN;
	
	private int[] m_random;
	private boolean m_wonGame;

	public FermiGame() {
		this("Fermi", "Pico", "Nano");
	}
	
	public FermiGame(String fermi, String pico, String nano){
		
	}
	
	private void generateRandomIntegers(){
		Random randomGenerator = new Random();
		for (int i = 0; i < 2; i++)
		{
			m_random[i] = randomGenerator.nextInt(9);
		}
	}
	
	public String[] guess (int one, int two, int three){
		String result[] = null;
		if(validateGuess(one,two,three))
		{
			System.out.println(String.format("-- Game: %d %d %d", m_random[0], m_random[1], m_random[2]));
			System.out.println(String.format("-- Game: %d %d %d", one, two, three));
			
			String response1 = testMatch(one, 0);
			String response2 = testMatch(two, 1);
			String response3 = testMatch(three, 2);
			
			if (response1.endsWith(m_fermi) && response2.endsWith(m_fermi) && response3.endsWith(m_fermi))
			{
				m_wonGame = true;
			}
			
			result = new String[] { response1, response2, response3};
		}
		
		return result;
		
	}
	
	public boolean isWinner(){
		return m_wonGame;
		
	}
	
	void newGame(){
		m_wonGame = false;
		generateRandomIntegers();
	}
	
	private String testMatch(int guess, int pos){
		return m_fermi;
		
	}
	
	private boolean validateGuess(int one, int two, int three){
		return m_wonGame;
		
	}
	
	private void validateParameters(String fermi, String pico, String nano){
		
	}
	

}
