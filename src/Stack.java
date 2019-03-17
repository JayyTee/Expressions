public class Stack extends LinkedList
{
    int maxSize = 0;
    int size = 0;

    public Stack(int maxSize)
    {
        this.maxSize = maxSize;
    }

    // Push onto stack if it is not full, else print message
    void push(String data)
    {
        if(size < maxSize)
        {
            addFront(data);
            size ++;
        }

        else
        {
            System.out.println("stack is full");
        }
    }

    // Remove top item and return popped item
    String pop()
    {
        size --;
        String s = removeFirst();
        return s;
    }
}
