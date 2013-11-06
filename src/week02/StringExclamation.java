package week02;

import java.util.ArrayList;

public class StringExclamation {
	
	private ArrayList<String> m_list;
	
	public StringExclamation()
	{
		m_list = new ArrayList<String>();
	}

	public ArrayList<String> splitByExclamation(String m_stringTest) {
		m_list.clear(); // remove any previous entries
		
		String[] list = m_stringTest.split("!");
		for(int i = 0; i < list.length; i++)
		{
			// Get the next string in the list. 
			// Note, this is zero based
			String s = list[i];
			
			// Add the string, but trim leading and trailing whitespace
			m_list.add(s.trim());
		}
		
		return m_list;
	}
	
}
