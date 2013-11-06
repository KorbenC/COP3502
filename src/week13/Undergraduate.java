package week13;

/**
 * Undergraduate student
 * 
 * @author korbenc
 * 
 */
public class Undergraduate extends Student
{
    /**
     * Constructor
     * 
     * @param name
     *            Student name
     * @param year
     *            Student year
     */
    public Undergraduate(String name, YEAR year)
    {
        super(name, year);
    }

    /**
     * Undergraduate grade is a simple average of the scores
     */
    @Override
    public double calculateGrade()
    {
    	double average = 0.0;
		for(double score : m_tests)
		{
			average += score;
		}
		
		return average/m_tests.size();
        // TODO: Iterate the test scores and return the average
    }

}
