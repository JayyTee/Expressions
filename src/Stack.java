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
        addFront(data);
    }

    // Remove top item and return it
    public String pop()
    {

        String s = removeFirst();

            return s;
    }
}
