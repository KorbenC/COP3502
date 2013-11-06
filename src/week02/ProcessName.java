package week02;

public class ProcessName {
	
	private String m_firstName = "";
	private String m_lastName = "";
	private String m_middleName = "";
	
	String getDisplayName(){
		return m_lastName + ", " + m_firstName;
	}
	
	String getFirstInitialLast(){
		return m_firstName +" "+ m_middleName.charAt(0) + ". " + m_lastName;
	}
	
	ProcessName(String firstName, String middleName, String lastName){
		m_firstName = firstName;
		m_middleName = middleName;
		m_lastName = lastName;
		
	}
}
