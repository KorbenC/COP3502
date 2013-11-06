package week04;

import test.AbstractTestCase;

public class TestCaseDieMany extends AbstractTestCase {
	
	protected String m_results;
	private int m_runs = 10;

	protected TestCaseDieMany() {
		super("DieTestCase3");
	}

	@Override
	protected boolean runTest() {
		boolean result = true;

		ManySidedDie one = new ManySidedDie(8, true);
		ManySidedDie two = new ManySidedDie(12, true);
		ManySidedDie three = new ManySidedDie(20, true);

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
