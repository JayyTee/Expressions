/*
*Stack based on the packaged linked list
*Impelements standard Stack
*
*/
public class Stack extends LinkedList
{

    // Push onto stack if stack !full();
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