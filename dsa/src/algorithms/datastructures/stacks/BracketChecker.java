package algorithms.datastructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        MyStack myStack = new MyStack(input.length());

        if (!myStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }

        for (int idx = 0; idx < input.length(); idx++) {
            char bracket = input.charAt(idx); // get a char from input

            switch (bracket) {
                case '{', '[', '(': // opening symbols
                    myStack.push(bracket);
                    break;
                case '}', ']', ')': // closing symbols
                    if (!myStack.isEmpty()) {
                        char bracketx = (char) myStack.pop();  // pop a char
                        
                        /* Check a char */
                        if ((bracket == '}' && bracketx != '{') 
                            || (bracket == ']' && bracketx != '[') 
                            || (bracket == ')' && bracketx != '(')) {
                            System.out.println("Error: " + bracket + " at " + idx);
                        }
                    } else {
                        System.out.println("Error: " + bracket + " at " + idx);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();

            String input = getString();     // read a string
            if (input.equals("")) {         // quit if [Enter]
                break;
            }

            /* Make a BracketChecker */
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check(); // check brackets
        }
    } 
}
