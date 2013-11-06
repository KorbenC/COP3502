package week13;

import java.util.ArrayList;

/**
 * Contains the test data for this assignment
 * @author korbenc
 *
 */
public class TestData
{
	// declare a static class variable
	// needs to be declared before the static initializer
	public static ArrayList<String> goodData;

	public static ArrayList<String> badData;
	
	public static ArrayList<String> noInputData = new ArrayList<String>();

	// Java allows static initialization
	// This initializes the test data variables.
	static
	{
		goodData = new ArrayList<String>();
		goodData.add("1,John Doe,34,40,45");
		goodData.add("2,Jill Dove,45,45,45");
		goodData.add("5,Jim Taubitz,45,45,45");
		goodData.add("5,Jeff Nichols,40,40,40");
		goodData.add("3,Steve Fritz,35,45,40");
		goodData.add("4,James Bond,45,45,45");
		goodData.add("5,Jenee Hill,45,44,37");
		goodData.add("1,John Bimby,40,40,40");
		goodData.add("2,Mary Key,40,30,30");
		goodData.add("2,Annette Childs,45,40,44");
		goodData.add("3,Dave Chalmers,45,34,44");
		goodData.add("4,Milky Way,44,44,44");
		goodData.add("4,Skylar Wayans,45,45,45");
		goodData.add("3,Sarah Kim,40,40,39");
		goodData.add("5,Jacob Smith,45,34,33");
		goodData.add("2,Steven Segal,45,44,43");
		goodData.add("5,Stephen Hawking,45,45,45");
		goodData.add("3,Isaac Newton,30,30,30");
		goodData.add("5,Luke Skywalker,40,40,40");
		goodData.add("2,Brittany Skye,40,34,45");

		badData = new ArrayList<String>();
		badData.add("2,John Doe,34,40,45");
		badData.add("1,Jill Dove,45,45,45");
		badData.add("5,Jim Taubitz,45,45,45");
		badData.add("5,Jeff Nichols,40,40,40");
		badData.add("2,Steve Fritz,35,45,40");
		badData.add("3,James Bond,45,45,45");
		badData.add("5,45,44,37");
		badData.add("2,John Bimby,40,40,40");
		badData.add("2,Mary Key,40,30,30");
		badData.add("3,Annette Childs,45");
		badData.add("4,Dave Chalmers,45,34,44");
		badData.add("4,Milky Way,44,44,44");
		badData.add("3,Skylar Wayans,45,45,45");
		badData.add("1,40,39");
		badData.add("45,34,33");
		badData.add("1,Steven Segal,45,44,43");
		badData.add("5,Stephen Hawking,45,45,45");
		badData.add("2,Isaac Newton,30,30,30");
		badData.add("40,40,40");
		badData.add("2,Brittany Skye,40,34,45");
	}
}
