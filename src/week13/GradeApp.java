package week13;

import java.util.ArrayList;

/**
 * Main application entry point
 * 
 * @author korbenc
 * 
 */
public class GradeApp
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		run();
	}

	private static void run()
	{
		try
		{
			DataManager dm = new DataManager();

			trace("******* Good Data **********");
			ArrayList<Student> students = dm.loadStudents(TestData.goodData);
			displayStudents(students);
			boolean result = testStudents(students);
			trace("Test success: " + result);
			trace("+++++++++++++++++++++++++++");

			trace("******* Bad Data **********");
			students = dm.loadStudents(TestData.badData);
			displayStudents(students);
			result = testStudents(students);
			trace("Test success: " + result);
			trace("+++++++++++++++++++++++++++");

			trace("******* No Data **********");
			students = dm.loadStudents(TestData.noInputData);
			displayStudents(students);
			result = testStudents(students);
			trace("Test success: " + result);
			trace("+++++++++++++++++++++++++++");
		}
		catch(Exception ex)
		{
			trace("Error processing: " + ex.getMessage());
		}

		System.out.println("Complete");
	}

	private static void displayStudents(ArrayList<Student> students)
	{
		for(Student student : students)
		{
			display(student);
		}
	}
	
	private static boolean testStudents(ArrayList<Student> students)
	{
		boolean result = true; // matches
		String fmt = "Grade calculation mismatch for %s %s, expected %.2f, actual %.2f";
		for(Student student : students)
		{
			if( student instanceof Undergraduate )
			{
				ReferenceUndergraduate ref = new ReferenceUndergraduate(student);
				double expected = ref.calculateGrade();
				double actual = student.calculateGrade();
				if( expected != actual)
				{
					result = false;
					String msg = String.format(fmt, student.getYear(), student.getName(), expected, actual);
					trace(msg );
				}
			}
			else
			{

				ReferenceGraduate ref = new ReferenceGraduate(student);
				double expected = ref.calculateGrade();
				double actual = student.calculateGrade();
				if( expected != actual)
				{
					result = false;
					String msg = String.format(fmt, student.getYear(), student.getName(), expected, actual);
					trace(msg );
				}
			}
		}
		
		return result;
	}

	private static void display(Student student)
	{
		String fmt = String.format(m_displayFmt, student.getName(),
				student.getYear(), student.calculateGrade());
		trace(fmt);
	}

	private static void trace(String msg)
	{
		System.out.println(msg + "\r\n");
	}

	private static String m_displayFmt = "%s Year: %s, Grade: %.2f";
	// private static String filePath = "modelsrc/week13/good_input.txt";
	// private static String badFilePath = "modelsrc/week13/bad_input.txt";
	// private static String noFilePath = "modelsrc/week13/no_input.txt";
}
