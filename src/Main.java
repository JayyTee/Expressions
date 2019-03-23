/*
* Main Class
* use stacks and queues to convert infix to postfix, then evaluate.
* used inheritance as review opportunity
* Jaiquan Rainey
* */
public class Main {
    public static void main(String[] args)
    {   //variables
        String expression = "A * B / C + D #";
        String[] token = expression.split(" ");
        String temp = "";

        int current; // Current token's priority
        int previous = 0; // Previous token's priority
        boolean popStop = false;// Stop enqueue if left parenthesis is found

        //ADTs
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
            current = priority(temp);

            if (current < 0) // add to postfix if temp is an operand
            {
                postfix.enqueue(temp);
            }
            else if(current == 3) // if token is left parenthesis, pause enqueues and add to stack
            {
                operators.push(temp);
                popStop = true;
            }
            else if(popStop && current > 0) // If there is a left parenthesis, only push() onto operator stack
            {
                operators.push(temp);
                previous = current;
            }
            else if(!popStop && current > 0) // if previous item in op stack is < current held item, move previous to postfix and push current
            {
                if(current > previous && operators.size() > 1)
                {
                    temp = operators.pop();
                    postfix.enqueue(temp);
                    operators.push(temp);
                    previous = current;
                }
                else
                {
                    operators.push(temp);
                    previous = current;
                }

            }
            else if(!temp.equals(")")) //once right parenthesis is reached, pop all operators until left one is found
            {
                temp = operators.pop();

                while(!temp.equals("("))
                {
                    postfix.enqueue(temp);
                    temp = operators.pop();
                }
                popStop = false;

            }
            else if(temp.equals("#")) // If end character is found, pop all on operator stack
            {
                temp = operators.pop();

                while(temp != "#")
                {
                   while(!operators.empty())
                        postfix.enqueue(temp);
                }

            }

        }
        while(!postfix.empty())
            System.out.print(postfix.dequeue() + " ");

    }

    // Return the priority of input token
    private static int priority(String token)
    {

        int value = 0;

        switch(token)
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
                value = -1;
        }
        return value;
    }
}
