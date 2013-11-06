package week12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serializes the user defined Box class
 * 
 * @author korbenc
 * 
 */
public class TestBoxSerialization
{
    public static void main(String[] args)
    {
        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeight(20);

        saveBox(myBox); // serialize

        Box box = getBox(); // read it back
        compareBoxes(myBox, box);

        myBox.setHeight(100);

        // save the changes
        saveBox(myBox);

        // Read the box back
        Box box2 = getBox();
        compareBoxes(box, box2);
    }

    private static void compareBoxes(Box left, Box right)
    {
        if(left.equals(right))
        {
            System.out.println("Boxes are the same");
        }
        else
        {
            System.out.println("Boxes are different");
        }
    }

    private static void saveBox(Box myBox)
    {
        FileOutputStream fout = null;
        try
        {
            fout = new FileOutputStream(m_file);
            // TODO Create an ObjectOutputStream instance called out
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(myBox);
            out.close();
        }
        catch(java.io.IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(fout != null)
            {
                try
                {
                    fout.close();
                }
                catch(Exception ex)
                {
                }
            }
        }
    }

    private static Box getBox()
    {
        FileInputStream fin = null;
        Box box = null;
        try
        {
            fin = new FileInputStream(m_file);
            // TODO Create an ObjectInputStream instance called ins
            ObjectInputStream ins = new ObjectInputStream(fin);       
            box = (Box)ins.readObject();
            ins.close();
        }
        catch(java.io.IOException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(fin != null)
            {
                try
                {
                    fin.close();
                }
                catch(Exception ex)
                {
                }
            }
        }

        return box;
    }

    private static final String m_file = "./src/week12/box.ser";
}
