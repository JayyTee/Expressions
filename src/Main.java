/*
* Main Class
* use stacks and queues to convert infix to postfix, then evaluate.
* used inheritance as review opportunity
* Jaiquan Rainey
* */
public class Main {
    String ADDITION = "+";
    String SUBTRACTION = "-";
    String MULTIPLICATION = "*";
    String DIVISION = "/";
    public static void main(String[] args)
    {   //variables
        String expression = "( 5 * 4 )/ 10 + 2 #";
        String[] token = expression.split(" ");
        String temp;
        String  post = "";

        int current; // Current token's priority
        int previous = 0; // Previous token's priority
        boolean parenthesis = false;// Stop enqueue if left parenthesis is found

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

           if(temp.equals("(")) // If current item is left parenthesis, pause pop() from operators
           {
               operators.push(temp);
               parenthesis = true;
           }
           else if(temp.equals(")"))// When right parenthesis is found, pop all up to left parenthesis
           {
               temp = operators.pop();
               while(!temp.equals("("))
               {
                   postfix.enqueue(temp);
                   temp = operators.pop();
               }
           else if(current == 0) // if current item is '#' pop() all operators
           {
               temp = operators.pop();
               while(!temp.equals("#"))
               {
                   postfix.enqueue(temp);
                   temp = operators.pop();

               }
           }
           else if(current < 0) //if current item is an operand, enqueue to postfix
           {
               postfix.enqueue(temp);
           }
           else if(current >= priority(operators.ontop())) //if priority of current item is greater then item atop operator stack, push
           {
               operators.push(temp);
           }
           else if(current < priority(operators.ontop()))
           {
               if(parenthesis)
               {
                   operators.push(temp);
               }
               else
               {
                   while(current < priority(operators.ontop()))
                       postfix.enqueue(operators.pop());

                   operators.push(temp);
               }
           }
        }
        while(!postfix.empty())
        {
            post += postfix.dequeue();
            post += " ";
        }


        evaluate(post);

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
                break;
            case "+":
                value = 1;
                break;
            case"-":
                value = 1;
                break;
            case"#":
                value = 0;
                break;
            default:
                value = -1;
        }
        return value;
    }

    private static int evaluate(String post)
    {
        String operator = "";
        int operand1 = 0;
        int operand2 = 0;
        String[] postfixArray = post.split(" ");

        for(int i = 0; i < postfixArray.length-1; i++)
        {
            if (postfixArray[i].matches("\\d+"))
            {
                if(operand1 == 0)
                {
                    operand1 = Integer.parseInt(postfixArray[i]);
                    System.out.println(operand1);
                }
                else
                {
                    operand2 = Integer.parseInt(postfixArray[i]);
                    System.out.println(operand2);
                }
                System.out.println(operand1);
            }

            switch(operator)
            {
                case "+":
                {
                    operand1 = operand1 + operand2;
                    operand2 = 0;
                }
                case "-":
                {
                    operand1 = operand1 - operand2;
                    operand2 = 0;
                }

                case "/":
                {
                    operand1 = operand1 / operand2;
                    operand2 = 0;
                }
                case "*":
                {
                    operand1 = operand1 * operand2;
                    operand2 = 0;
                }

            }
        }


        return 1;
    }
}
