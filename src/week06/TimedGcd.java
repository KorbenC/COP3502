package week06;

import java.util.Date;

public class TimedGcd
{
	static enum ComputationType
	{
		BRUTE_FORCE,
		EUCLID
	}
	/**
	 * Compares the performance of two GCD implementations
	 * @param m Number to calculate GCD on
	 * @param n Number to calculate GCD on
	 */
	public TimedGcd()
	{
	}
	
	
	/**
	 * Start the timed calculations.
	 */
	public void start(long m, long n)
	{
		// This updates the internal state of the TimedGcd object
		m_bruteForceTime = timeMethod(m, n, ComputationType.BRUTE_FORCE);
		m_euclidTime = timeMethod(m, n, ComputationType.EUCLID);		
	}
	
	public long bruteForceTime()
	{
		//System.out.println(m_bruteForceTime);
		return m_bruteForceTime;
	}
	
	public long euclidTime()
	{
		//System.out.println(m_euclidTime);
		return m_euclidTime;
	}
	
	private long timeMethod(long m, long n, ComputationType type)
	{
		Date startTime;
		Date stopTime;
		
		startTime = new Date();
		
		switch(type)
		{
			case BRUTE_FORCE:
				bruteForceGcd(m, n);
				break;
			case EUCLID:
				getGcdBreak(m, n);
				break;
		}
		
		stopTime = new Date();
		
		return stopTime.getTime() - startTime.getTime();
	}
	
	/**
	 * Implementation of algorithm on page 311 of text
	 * @param m Number to calcluate GCD for
	 * @param n Number to calcluate GCD for
	 * @return gcd value
	 */
	private long bruteForceGcd(long m, long n)
	{
		System.out.println("bruteForceGcd");
		long largest = 1;
		long to = m;
		
		if(n < m)
			to = n;
		for(int i = 2; i <= to;i++){
			if(m % i == 0 && n % i == 0)
				largest = i;
		}
		
		return largest;
		
		
	}
	
	/**
	 * Implementation of algorithm on page 326 of text
	 * @param m Number to calcluate GCD for
	 * @param n Number to calcluate GCD for
	 * @return gcd value
	 */
	private long getGcdBreak(long m, long n)
    {
		System.out.println("euclidGcd");
		while(n != 0){
			long temp = n;
			n = m % n;
			m = temp;
		}
		return m;
    }
	
	private long m_bruteForceTime = 0;
	private long m_euclidTime = 0;
}
