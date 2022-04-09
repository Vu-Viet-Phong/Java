package dsajava2e.c4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParsePost {
    private MyStack myStack;
    private String input;
    
    public ParsePost(String input) { 
        this.input = input; 
    }

    public int doParse() {
        myStack = new MyStack(20);

        char ch;
        int num1, num2, interAns;

        for (int i=0; i<input.length(); i++) {
            ch = input.charAt(i);                 // read from input
            myStack.displayStack("" + ch + " ");  // *diagnostic*
            
            if (ch >= '0' && ch <= '9')           // if it's a number
                myStack.push( (int)(ch-'0') );    //   push it
            else {                                // it's an operator
                num2 = myStack.pop();             // pop operands
                num1 = myStack.pop();
                switch(ch) {                      // do arithmetic 
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                myStack.push(interAns); // push result
            }
        }
        interAns = myStack.pop(); // get answer
        return interAns;
    } 

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {
        String input;
        int output;

        while(true) {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();   

            if( input.equals("") ) {
                break;
            }

            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();  // do the evaluation
            System.out.println("Evaluates to " + output);
        } 
    }
}
