package week11;

/**
 * This is the abstract base class that the search algorithms inherit from. On a
 * successful search, the caller retrieves. The <T> defines the data type of the
 * class
 * 
 * @author korbenc
 * 
 */
public abstract class AbstractSearch
{
    /**
     * Result enumerations
     * 
     * @author scottl
     * 
     */
    public enum RESULT
    {
        NOT_FOUND, FOUND
    }

    /**
     * This method must be implemented by the subclasses
     * 
     * @return A RESULT Enumeration
     */
    public abstract RESULT search(int[] array, int searchValue);
}
