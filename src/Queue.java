public class Queue extends LinkedList
{
    // Add item to rear of queue
    public void enqueue(String data)
    {
        try
        {
            addRear(data);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //remove and return item at front of queue
    public String dequeue()
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
