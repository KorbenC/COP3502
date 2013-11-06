package week04;

import java.util.Random;

public class DieVer2 {

	// Data Members

    // the largest number on a dice
    private static final int MAX_NUMBER = 6;

    // the smallest number on a dice
    private static final int MIN_NUMBER = 1;

    private int number;

    private Random random;
    
    public DieVer2()
    {
    	random = new Random();
    	roll();
    }
    
    // Rolls the dice
    public void roll()
    {
        number = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    // Returns the number on this dice
    public int getNumber()
    {
        return number;
    }

}
