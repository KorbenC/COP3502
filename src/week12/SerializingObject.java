package week12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Demonstrates serializing an object
 * 
 * @author korbenc
 * 
 */
public class SerializingObject
{
    public static void main(String[] args)
    {
        FileOutputStream fstream = null;

        try
        {
            File f = new File("./src/week12/serial.txt");
            fstream = new FileOutputStream(f);
            // TODO: Create an ObjectOutput instance using the
            // ObjectOutputStream
            // use the FileOutStream variable we just created

            // Note: no user data is being serialized
            
            ObjectOutput ObjOut = new ObjectOutputStream(fstream);
            ObjOut.writeObject(f);
            ObjOut.close();

            System.out
                    .println("Serializing an Object Creation completed successfully.");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
