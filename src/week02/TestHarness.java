package week02;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class tests the week 2 assignments It tests the DateFormat, ProcessName
 * and StringExclamation classes All classes are part of the package week2
 * 
 * @author korbenc
 * 
 */
public class TestHarness
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		boolean testSuccess = true;

		trace("Starting test...");

		trace(" -- setup test data");
		m_testDate.set(1961, 9, 20);
		Date testDate = m_testDate.getTime();

		trace(" -- Testing DateFormat");
		DateFormat dateFormat = new DateFormat();
		String curDate = dateFormat.getCurrentDate();
		String testDateString = dateFormat.formatDate(testDate);

		// Verify
		if(!testDateString.equals(m_dateVerifyTest))
		{
			trace("  ** DateFormat failed! Got: " + testDateString + " Expected: " + m_dateVerifyTest);
			testSuccess = false;
		}

		trace(" -- Testing ProcessName");
		ProcessName name = new ProcessName(m_nameTest[0], m_nameTest[1], m_nameTest[2]);
		String formattedName = name.getFirstInitialLast();
		String displayName = name.getDisplayName();
		
		// Verify
		if(!formattedName.equals(m_nameVerifyTest))
		{
			trace("  ** ProcessName failed! Got: " + formattedName + " Expected: " + m_nameVerifyTest);
			testSuccess = false;
		}
		
		// Verify
		if(!displayName.equals(m_displayNameVerifyTest))
		{
			trace("  ** ProcessName failed! Got: " + displayName + " Expected: " + m_displayNameVerifyTest);
			testSuccess = false;
		}

		trace(" -- Testing StringExclamation");
		
		StringExclamation exclamation = new StringExclamation();
		ArrayList<String> split = exclamation.splitByExclamation(m_stringTest);
		
		if( split.size() != m_stringVerifyTest.length)
		{
			trace("  ** StringExclamation failed! Got: " + split.size() + " Expected: " + m_stringVerifyTest.length);
			testSuccess = false;
			
			if( !split.get(0).equals(m_stringVerifyTest[0]))
			{
				trace("  ** StringExclamation failed! Got: " + split.get(0) + " Expected: " + m_stringVerifyTest[0]);
				testSuccess = false;
			}
			
			if( !split.get(1).equals(m_stringVerifyTest[1]))
			{
				trace("  ** StringExclamation failed! Got: " + split.get(1) + " Expected: " + m_stringVerifyTest[1]);
				testSuccess = false;
			}			
		}
		
		trace("");
		if( testSuccess)
		{			
			trace(" ** Success ** ");
		}
		else
		{
			trace(" ** Failed **");
		}
		trace("Test complete");

	}

	static private void trace(String msg)
	{
		System.out.println(msg);
	}

	// Test data
	// DateFormat
	static private String m_dateVerifyTest = "20 October 1961";
	static private Calendar m_testDate = Calendar.getInstance();

	// ProcessName
	static private String[] m_nameTest = new String[] { "Scott", "Kevin",
			"LaChance" };
	static private String m_nameVerifyTest = "Scott K. LaChance";
	static private String m_displayNameVerifyTest = "LaChance, Scott";

	// StringExclamation
	static private String m_stringTest = "Hello from!the second line";
	static private String[] m_stringVerifyTest = new String[] { "Hello from",
			"the second line" };

}
