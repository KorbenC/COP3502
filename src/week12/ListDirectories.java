package week12;

import java.io.File;
import java.util.ArrayList;


/**
 * Demonstrates the using the File class to find directories.
 * Assignment:
 *   Create a new class in the IDE under week12 and type in the
 *   code listing here.
 * @author korbenc
 */
public class ListDirectories
{
    /**
     * This method does all the hard work
     *
     * @param root
     *            root directory string
     * @return String array of child directory paths
     */
    String[] getDirectories(String root)
    {
        // Handle dynamic number of results
        // TODO: Create an array of strings named dirs to hold the directory paths
    	ArrayList<String> dirs = new ArrayList<String>();

        // locate files
        File dir = new File(root);
        File[] files = dir.listFiles();
        for(File file : files)
        {
            if(file.isDirectory())
            {
				// TODO Add the file to your array of strings.
				// Be sure to add the full path
            	dirs.add(file.getAbsolutePath());
            }
        }

        // Prepare return result
        // NOTE: the
        String[] dirList = new String[dirs.size()];
        dirList = dirs.toArray(dirList); // this is typesafe
        return dirList;
    }

    /**
     * This requires a folder argument From the commandline: java -classpath .
     * week12.ListDirectories <folderpath>
     *
     * Or
     *
     * In the Eclipse IDE, right click on the source file: Select Debug
     * Configurations... Select the Arguments tab Enter the folder in Program
     * Arguments textbox Click Apply
     *
     * @param args
     *            Commandline arguments
     */
    public static void main(String[] args)
    {
        if(validArguments(args))
        {
            ListDirectories listDirs = new ListDirectories();
            String[] dirs = listDirs.getDirectories(args[0]);

            // locate files
            for(String dir : dirs)
            {
                trace(dir);
            }
        }
        else
        {
            trace("Invalid arguments");
        }
    }

    private static void trace(String msg)
    {
        System.out.println(msg);
    }

    /**
     * Validate the commandline argument Check that there is only one argument
     *
     * @param args
     *            commandline arguments
     * @return true if valid argument, otherwise false
     */
    private static boolean validArguments(String[] args)
    {
        boolean isValid = false;
        if(args.length == 1)
        {
            File dir = new File(args[0]);
            if(dir.isDirectory())
            {
                isValid = true;
            }
        }

        return isValid;
    }
}
