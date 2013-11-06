package week13;

import java.util.ArrayList;

import week13.Student.YEAR;

/**
 * This class manages the data storage. This initial implementation will be a
 * file based solution.
 * 
 * @author korbenc
 * 
 */
public class DataManager
{
	/**
	 * Constructor
	 */
	public DataManager()
	{

	}

	/**
	 * Read students in from the supplied file. The file format description:
	 * Data is comma-separated and is in a specific order. There are three
	 * tests, which all have a max of 45 points <Student Type>,<Student
	 * Name>,<Test1>,<Test2,<Test3>
	 * 
	 * Example: U,Test Student,45,45,45
	 * 
	 * @param filePath
	 *            Fully qualified path to the data file
	 * @return ArrayList of Students.
	 */
	public ArrayList<Student> loadStudents(ArrayList<String> data)
	{
		ArrayList<Student> students = new ArrayList<Student>();

		for(String info : data)
		{
			try
			{
				Student student = parseStudentData(info);
				students.add(student);
			}
			catch(InvalidArgumentException ex)
			{
				// eat the error
				System.out.println(ex.getMessage());
			}
		}

		return students;
	}

	/**
	 * Creates a Undergraduate or Graduate student based on the type of student.
	 * The data is a string of comma-separated values For example: U,John Doe,
	 * 1, 34,40,45 The first element is the year. 1 = Freshman, 2 = Sophomore, 3
	 * = Junior, 4 = Senior, 5 = Graduate * The first element is U or G
	 * representing graduate (G) or undergraduate (U) The second element is the
	 * student name
	 * 
	 * The following element (and there can be zero to many) are the test
	 * scores.
	 * 
	 * Parse the string into its parts and create a Student object
	 * 
	 * Need to handle formatting errors here
	 * 
	 * @param data
	 *            A string of data representing a student
	 * @return A Graduate or Undergraduate student instance
	 * @exception InvalidArgumentException
	 *                Thrown when data is missing to create student.
	 */
	private Student parseStudentData(String data)
			throws InvalidArgumentException
	{
		String[] elements = data.split(",");
		Student student = null;
		try
		{
			// verify we have at least the year and name
			if(elements.length < 2)
			{
				// error with this data, eat it
			}
			else
			{
				String yearString = elements[0];
				String name = elements[1];
				YEAR yearEnum = YEAR.FRESHMAN;
				
				int year = Integer.parseInt(yearString);
				switch(year)
				{
					// Set the appropriate year, fall through and create a 
					case 1: yearEnum = YEAR.FRESHMAN;break;
					case 2: yearEnum = YEAR.SOPHOMORE;break;
					case 3: yearEnum = YEAR.JUNIOR;break;
					case 4: yearEnum = YEAR.SENIOR;break;
					case 5: yearEnum = YEAR.GRADUATE;break;
					default:
						throw new InvalidArgumentException("Invalid year");
				}

				if( YEAR.GRADUATE == yearEnum)
				{
					student = new Graduate(name, yearEnum);
				}
				else
				{
					student = new Undergraduate(name, yearEnum);
				}				
				
				// get the test scores
				for(int i = 2; i < elements.length; i++)
				{
					int score = Integer.parseInt(elements[i]);
					student.addTest(score);
				}
			}
		}
		catch(Exception ex)
		{
			throw new InvalidArgumentException("Error creating student object",
					ex);
		}
		
		return student;
	}
}
