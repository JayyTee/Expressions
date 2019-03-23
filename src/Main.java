/*
* Main Class
* use stacks and queues to convert infix to postfix, then evaluate.
* used inheritance as review opportunity
* Jaiquan Rainey
* */
public class Main {
    public static void main(String[] args)
    {
        String expression = "A * B / C + D #";
        String[] token = expression.split(" ");
        String temp = "";
        Stack operators = new Stack();
        Queue infix = new Queue();
        Queue postfix = new Queue();

        for(int i = 0; i < token.length; i++) // Push infix expression to infix queue
        {
            infix.enqueue(token[i]);
        }

        operators.push("#"); // Initialize operator stack with #

        while(!infix.empty())
        {
            temp = infix.dequeue();
        }
    }

    private static int Priority(String token)
    {
        String op = "";
        int value;

        switch(op)
        {
            case "(":
                value = 3;
                break;
            case "*":
                value = 2;
                break;
            case "/":
                value = 2;
            case "+":
                value = 1;
            case"-":
                value = 1;
            default:
                value = 0;
        }
        return value;
    }
}
