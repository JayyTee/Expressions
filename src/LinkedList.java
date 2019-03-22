/*
* This is a linked list class with Node inner class to be used-
* in creation of stacks and queues.
* Custom exceptions for full and empty linked list are also included
* By: Jaiquan Rainey
*/

public class LinkedList
{
    private Node first;
    protected int maxSize = 25;
    protected int size = 0;



    // Add new item to front of list
    protected void addFront(String data) throws ListFullException
    {
        Node newFront = new Node(data);
        if(full())
        {
            throw new ListFullException("List is full");
        }
        else if (empty())
        {
            first = newFront;
            size++;
        }
        else
        {
            newFront.link = first;
            first = newFront;
            size++;
        }

        size ++;
    }

    // Add new item to end of list
    protected void addRear(String data) throws ListFullException
    {   if(full())
        {
            throw new ListFullException("List is full");
        }
        else if(empty())
        {
            first = new Node(data);
            size++;
        }
        else
        {
            Node lastItem = traverse();
            lastItem.link = new Node(data);
            size++;
        }

    }

    // Delete first item from the list and return it
    protected String removeFirst() throws ListEmptyException
    {
        String oldFirst = null;

        if(empty())
        {
            throw new ListEmptyException("List is empty");
        }
        else
        {
            oldFirst = first.data;
            first = first.link;
            size--;
        }

        return oldFirst;
    }

    // Traverse to end of the list and return last node
    protected Node traverse()
    {
        if(empty())
            return null;

        Node current = first;

        while(current.link != null)
        {
            current = current.link;
        }
        return current;
    }

    // Return true when list is empty
    public boolean empty()
    {
        return first == null;
    }

    // return true when list is full
    public boolean full()
    {
        return size >= maxSize;
    }

    // Return size
    private int size()
    {
        return this.size;
    }

    /* Node class */
    private class Node
    {
        private Node link;
        private String data;

        private Node(String data)
        {
            Node link = null;
            this.data = data;
        }
    }

    /*list-is-full exception*/
    protected static class ListFullException extends Exception
    {
        ListFullException(String message)
        {
            super(message);
        }
    }

    /*list-is-empty exception*/
    protected static class ListEmptyException extends Exception
    {
        ListEmptyException(String message)
        {
            super(message);
        }
    }
}
    