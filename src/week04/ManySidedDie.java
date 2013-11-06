package week04;

import java.util.Random;

public class ManySidedDie {
	// Data Members

    // the largest number on a dice
    private int MAX_NUMBER = 6;

    // the smallest number on a dice
    private static final int MIN_NUMBER = 1;
    
 // to represent a dice that is not yet rolled
    private static final int NO_NUMBER = 0;

    private int number;

    private Random random;
    
    public ManySidedDie(int numberOfSides, boolean isValid)
    {
    	MAX_NUMBER = numberOfSides;
    	random = new Random();
    	number = NO_NUMBER;
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
