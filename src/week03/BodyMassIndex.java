package week03;

public class BodyMassIndex {
	
	private final int CONVERSION_FACTOR = 703;

	public BodyMassIndex() {
		
	}

	public double calculateBMI(int weight, int height)
	{
		return (double)(weight / (height * height)) * CONVERSION_FACTOR;
		
	}
	
}
