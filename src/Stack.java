/*
*
*
*
*/
public class Stack extends LinkedList
{
    public Stack(int maxSize)
    {
        super(maxSize);
        this.maxSize = maxSize;
    }

    // Push onto stack if full() == false;
    void push(String data)
    {
        try
        {
            addFront(data);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Remove top item and return it
    public String pop()
    {
        String s = "";

        try
        {
            s = removeFirst();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return s;
    }
}
