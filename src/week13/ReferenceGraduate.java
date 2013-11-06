package week13;

public class ReferenceGraduate extends Graduate
{
	public ReferenceGraduate(Student student)
	{
		super(student.getName(), student.getYear());
		this.m_tests = student.m_tests;
	}
	
	public ReferenceGraduate(String name, YEAR year)
	{
		super(name, year);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateGrade()
	{
		double average = 0.0;
		for(double score : m_tests)
		{
			average += score;
		}
		
		double normalized = (average/m_tests.size()) / 45 * 4;
		return normalized;
	}

}
