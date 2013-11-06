package week06;

import test.AbstractTestCase;

public class TestCaseRepetition extends AbstractTestCase
{

	protected TestCaseRepetition()
	{
		super("TestCaseRepetition");
	}

	@Override
	protected boolean runTest()
	{
		TimedGcd gcd = new TimedGcd();

		int run = 1;
		for(TestData test : m_testData)
		{
			trace("test " + run);
			m_result += "\r\ntest " + run++;
			try
			{
				gcd.start(test.getM(), test.getN());
				m_result += "\r\nM: " + test.getM();
				m_result += "\r\nN: " + test.getN();
				m_result += "\r\nBrute force time: " + gcd.bruteForceTime();
				m_result += "\r\nEuclid time: " + gcd.euclidTime();
			}
			catch(ArithmeticException ex )
			{
				trace("Error processing");
				m_result += "\r\nError for ";
				m_result += "\r\nM: " + test.getM();
				m_result += "\r\nN: " + test.getN();
			}
		}
		
		return true;
	}

	@Override
	protected String results()
	{
		return m_result;
	}

	private String m_result = "";
	private TestData[] m_testData = new TestData[] { 
			new TestData(4567820, 2147483640),
			new TestData(545690876L, 3456901294L),
			new TestData(546587619L, 21474836121L),
			new TestData(951987545L, 21474836651L),
			new TestData(1542354865L, 3216548445L)
			};
}

class TestData
{
	public TestData(long m, long n)
	{
		m_M = m;
		m_N = n;
	}

	public long getM()
	{
		return m_M;
	}

	public long getN()
	{
		return m_N;
	}

	private long m_M;
	private long m_N;
}
