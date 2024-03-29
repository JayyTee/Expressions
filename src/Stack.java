/*
*Stack based on the linked list class
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

    public String ontop()
    {
        String temp = pop();
        push(temp);
        return temp;
    }
}