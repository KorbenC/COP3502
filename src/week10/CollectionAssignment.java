package week10;

import java.util.List;
import java.util.ArrayList;


public class CollectionAssignment {
	
	public double calculateSum(double[] data){
		double result = 0;
		for(int i = 0;i < data.length; i++)
			result = data[i] += result;
		
		return result;
		
	}
	
	public int calculateProduct(int[] data){
		int result = 1;
		
		for(int i = 0; i < data.length; i++)
			result = data[i] *= result;
		
		
		return result;
		
	}
	
	public Integer calculateIntegerSum(List<Integer> data){
		int result = 0;
		
		for(int i = 0; i < data.size(); i++)
			result = result + data.get(i);
		return result;
		
		
	}
	
	public void setPersonAge(List<Person> personList, int age) {
		List<Person> persons = personList;
		for(Person p : persons)
		{
			p.setAge(45);
		}		
	}
	
	public ArrayList<Person> copyArrayToList(Person[] personList) {
		Person p1;
		
		return null;
		
	}

}
