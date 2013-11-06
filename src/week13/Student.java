package week13;

import java.util.ArrayList;

/**
 * Abstract class that represents the common student information
 *
 * @author korbenc
 *
 */
public abstract class Student
{
	public enum YEAR
	{
		FRESHMAN,
		SOPHOMORE,
		JUNIOR,
		SENIOR,
		GRADUATE
	}
	
    protected Student(String name, YEAR year)
    {
        m_tests = new ArrayList<Double>();
        m_name = name;
        m_year = year;
    }

    /**
     * Calculate the grade for the student. Undergraduate and graduate students
     * have different grading algorithms
     *
     * @return Calculated grade
     */
    public abstract double calculateGrade();

    /**
     * Adds a test score for the student
     *
     * @param score
     *            The test score
     */
    public void addTest(double score)
    {
        m_tests.add(score);
    }

    // Getters/Setters
    public String getName()
    {
        return m_name;
    }
    
    public YEAR getYear()
    {
    	return m_year;
    }

    protected YEAR m_year;
    protected String m_name;
    protected ArrayList<Double> m_tests;
}
