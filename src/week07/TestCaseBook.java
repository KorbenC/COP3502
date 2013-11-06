package week07;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import test.AbstractTestCase;

public class TestCaseBook extends AbstractTestCase
{

	public TestCaseBook()
	{
		super("TestCaseBook");
		builder = new StringBuilder();
		formatter = new SimpleDateFormat("MM/dd/yyyy");
		decimalFormatter = new DecimalFormat("#.00");
	}

	@Override
	protected boolean runTest()
	{
		initFilePath();
		//String file = "./src/week07/TestFile.txt";
		boolean result = false;
		boolean overdue = false;
		boolean changeDueDate = false;
		try
		{
			trace("Opening data access for " + m_filePath);
			DataAccess da = new DataAccess(m_filePath);

			ArrayList<Book> books = da.loadData();
			overdue = testOverdueCharge(books);
			changeDueDate = testChangeDueDate(books, da);

			// restore original data
			da.saveData(books);
		}
		catch(Exception ex)
		{
			builder.append(ex.getMessage());
		}

		result = overdue && changeDueDate;
		return result;
	}

	@Override
	protected String results()
	{
		return builder.toString();
	}

	
	private boolean testChangeDueDate(ArrayList<Book> books, DataAccess da)
	{
		trace(" ** Testing changing due date ** ");
		boolean result = true;
		ArrayList<Book> clones = new ArrayList<Book>();
		for(Book b : books)
		{
			clones.add(b.clone());
		}
		
		GregorianCalendar testDate = new GregorianCalendar(2012, 7, 4);
		// clone the list so we don't make permanent changes
		for(Book book : clones)
		{
			book.setDueDate(testDate);
		}
		
		da.saveData(clones);
		
		ArrayList<Book> testData = da.loadData();
		
		for(Book b : testData)
		{
			if( !b.getDueDate().equals(testDate))
			{
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	private boolean testOverdueCharge(ArrayList<Book> books)
	{
		trace(" ** Testing overdue charge ** ");
		boolean result = false;
		for(Book b : books)
		{
			GregorianCalendar returnDate = new GregorianCalendar();
			double charge = b.computeCharge(returnDate);
			Date due = b.getDueDate().getTime();
			Date ret = returnDate.getTime();
			String fmt = String.format("Due: %s, Returned %s, charge %f",
					formatter.format(due), formatter.format(ret), charge);
			trace(fmt);
			if(charge > 0)
			{
				trace(" - Overdue charge: " + decimalFormatter.format(charge));
				result = true;
			}	
		}

		return result;
	}
	/**
	 * Setup the test file path.
	 * Dev environment and runtime environment have different
	 * current directory behavior.
	 * For runtime testing, it is the bin folder
	 * For development, it is the current project folder.
	 * The test will create a new File instance for the current directory.
	 * If the directory is bin, the we use the simple file name for the test
	 * If it isn't we append the .\src\week10\ to the file path.
	 * That way this will work in development and testing.
	 */
	private void initFilePath()
	{		
		File curDir = new File(".");
		if( curDir.exists() && curDir.isDirectory() && curDir.getName() == "bin")
		{
			m_filePath = TEST_FILE;
		}
		else
		{
			m_filePath = DEV_PATH + TEST_FILE;
		}
	}

	private StringBuilder builder;
	private SimpleDateFormat formatter;
	private DecimalFormat decimalFormatter;
	private String m_filePath = "";
	private String TEST_FILE = "TestFile.txt";
	private String DEV_PATH = ".\\src\\week07\\";

}
