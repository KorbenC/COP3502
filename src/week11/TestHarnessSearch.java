package week11;

import test.TestEngine;

/**
 * File: TestHarness.java
 */
class TestHarnessSearch
{ 
    public static void main(String[] args)
    {		
    	trace("Starting test...");

		trace(" -- setup test data");
    	TestEngine engine = new TestEngine();
    	engine.addTest(new TestCaseBinarySearch());
    	engine.addTest(new TestCaseLinearSearch());
    	
    	engine.runTests();

    	trace("Completed test");
    }
    
	static private void trace(String msg)
	{
		System.out.println(msg);
	}    
}