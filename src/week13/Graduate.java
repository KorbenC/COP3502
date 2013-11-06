package week13;

/**
 * A graduate student instance
 * 
 * @author korbenc
 * 
 */
public class Graduate extends Student
{
    /**
     * Constructor
     * 
     * @param name
     *            Student name
     * @param year
     *            Student year
     */
    public Graduate(String name, YEAR year)
    {
        super(name, year);
    }

    /**
     * Graduate students use a 4.0 scale Calculate the average of the scores.
     * The max score for all the tests is 45. Calculate the percent (average/45)
     * and multiply by 4. Return this normalized value
     */
    @Override
    public double calculateGrade()
    {
        // TODO: calculate average/45*4
    	double average = 0.0;
		for(double score : m_tests)
		{
			average += score;
		}
		return (average/m_tests.size()) / 45 * 4;

    }

}
