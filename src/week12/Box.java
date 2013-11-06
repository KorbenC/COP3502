package week12;

import java.io.Serializable;

/**
 * This class can be serialized to a file When you implement Serializable, it is
 * good to define a serialVersionUID
 * 
 * @author korbenc
 * 
 */
public class Box implements Serializable
{
    private static final long serialVersionUID = -6065290475012823627L;

    /**
     * Compares two Box objects
     * @return true if width and height are equal
     */
    @Override
    public boolean equals(Object rhs)
    {
        Box rhsBox = (Box)rhs;
        boolean result = false;

        if(this.getWidth() == rhsBox.getWidth()
                && this.getHeight() == rhsBox.getHeight())
        {
            result = true;
        }

        return result;
    }

    /**
     * Box width
     * @return width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Sets the width
     * @param width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Box height
     * @return height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Sets the height
     * @param height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    private int height;
    private int width;
}
