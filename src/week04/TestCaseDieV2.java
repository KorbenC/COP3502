package week04;

import test.AbstractTestCase;

public class TestCaseDieV2 extends AbstractTestCase {

	
	protected String m_results;
	
	protected TestCaseDieV2() {
		super("DieTestCase2");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean runTest() {
		boolean result = true;
		DieVer2 one = new DieVer2();
		DieVer2 two = new DieVer2();
		DieVer2 three = new DieVer2();

        
        if(one.getNumber() == two.getNumber() && two.getNumber() == three.getNumber())
        {
        	result = false;
        	m_results = "Expected different numbers";
        }
        
      trace("Results are " + one.getNumber() + "  " 
    		  + two.getNumber() + "  " + three.getNumber());
      m_results = "Results are " + one.getNumber() + "  " 
    		  + two.getNumber() + "  " + three.getNumber();
      return result;
	}

	@Override
	protected String results() {
		return m_results;
	}

}
