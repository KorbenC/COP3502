package week12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class writes some text to a file. The file path is hard-coded for
 * demonstration purposes
 * 
 * @author korbenc
 * 
 */
public class WriteFile
{
    /**
     * Main entry point
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        FileWriter writer = null;

        try
        {
            // TODO: create a new FileWriter instance and use
            // "./src/week12/writeFile.txt"
            // to initialize it
        	
        	java.io.File f = new java.io.File("./src/week12/writeFile.txt");
        	
        	if(!f.exists()){
        		f.createNewFile();
        	}
        	writer = new FileWriter(f.getAbsoluteFile()); 
            BufferedWriter out = new BufferedWriter(writer);

            // TODO: Write the following text: "WriteFile demo\n"
            out.write("WriteFile demo\n");
            

            out.close();
            System.out.println("File created successfully.");
        }
        catch(IOException ex)
        {
            // Report an IO error
            System.out.println(ex);
        }
        finally
        {
            if(writer != null)
            {
                try
                {
                    writer.close();
                }
                catch(IOException ex)
                {
                }
            }
        }
    }
}
