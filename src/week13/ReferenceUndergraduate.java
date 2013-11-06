package week13;

public class ReferenceUndergraduate extends Undergraduate
{
	public ReferenceUndergraduate(Student student)
	{
		super(student.getName(), student.getYear());
		this.m_tests = student.m_tests;
	}
	
	public ReferenceUndergraduate(String name, YEAR year)
	{
		super(name, year);
	}

	@Override
	public double calculateGrade()
	{
		double average = 0.0;
		for(double score : m_tests)
		{
			average += score;
		}
		
		return average/m_tests.size();
	}

}
