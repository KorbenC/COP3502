package week02;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
public class DateFormat {
	
	
	private String m_dateFormat = "dd MMMM yyyy";
	SimpleDateFormat m_formatter;
	
	public DateFormat()
	{
		m_formatter = new SimpleDateFormat(m_dateFormat);
	}	
	

	public String getCurrentDate() {
		Calendar cal = GregorianCalendar.getInstance();
		
		return m_formatter.format(cal.getTime());
	}
	
	
	public String formatDate(Date d) {
		return m_formatter.format(d);
	}
}
