package week11;

import java.util.Random;
import test.AbstractTestCase;

public class TestCaseLinearSearch extends AbstractTestCase
{
	/**
	 * Default constructor
	 */
	public TestCaseLinearSearch()
	{
		super("TestCaseLinearSearch");
	}
	
	@Override
	protected boolean runTest()
	{        
		boolean result = false;
		
		trace(" fixed test");
		if( fixedTest())
		{
			result = true;
		}
		
		trace(" -- test large list");
		String s = "";
        for(int i = 0; i < 30; i++)
        {           
            long start = System.nanoTime();
            AbstractSearch.RESULT testResult = test();
            long end = System.nanoTime();
            long elapsed = end - start;
            
            switch(testResult)
            {
            	case FOUND:
            		s = "Found";
            		break;
            		
            	case NOT_FOUND:
            		s = "Not Found";
            		break;
            }
            
            m_result += String.format("Run %d, %s, %d ns\r\n",  i, s, elapsed);
        }
        
		return result;
	}


	@Override
	protected String results()
	{
		return m_result;
	}	

    private AbstractSearch.RESULT test()
    {
    	AbstractSearch.RESULT result = AbstractSearch.RESULT.NOT_FOUND;
        int[] list = generateTestData();
        IntLinearSearch search = new IntLinearSearch();

        if(search.search(list, 100) == AbstractSearch.RESULT.FOUND)
        {
        	result = AbstractSearch.RESULT.FOUND;
        }
        
        return result;
    }
    
	/**
	 * Tests using a fixed list of known values
	 * @return true if test is successful
	 */
	private boolean fixedTest()
	{
		boolean result = false;
		int[] array = new int[]{2,4,16,10,11,13,15,47,21,22,23,51,32,33,35,37,39,49,50,5,57,6,61,63,17,70,72,14,25,77};
		int expected = 37;
		IntLinearSearch search = new IntLinearSearch();

		switch(search.search(array,  expected))
		{
			case FOUND:
				result = true;
				break;
			case NOT_FOUND:
				result = false;
				break;
		}
		
		return result;
	}    

    private static int[] generateTestData()
    {
        int size = 10000;
        Random rand = new Random();

        int[] list = new int[size];
        for(int i = 0; i < list.length; i++)
        {
            list[i] = rand.nextInt(size);
        }

        return list;
    }


    private String m_result = "";

}
