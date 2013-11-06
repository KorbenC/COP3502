package week02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleDateFormat {

	public SampleDateFormat() {
		m_formatter = new SimpleDateFormat(m_dateFormat);
	}
	
	public String formatDate(Date d)
	{
		String formattedString = m_formatter.format(d);
		return formattedString;
	}

	public static String m_dateFormat = "dd MMMM yyyy";
	public SimpleDateFormat m_formatter;

}
