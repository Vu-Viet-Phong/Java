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
        int stackSize = input.length();
        MyStack myStack = new MyStack(stackSize);

        if (!myStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }

        for (int idx = 0; idx < input.length(); idx++) {
            char rightBracket = input.charAt(idx); // get a char from input

            switch (rightBracket) {
                case '{', '[', '(': // opening symbols
                    myStack.push(rightBracket);
                    break;
                case '}', ']', ')': // closing symbols
                    if (!myStack.isEmpty()) {
                        char leftBracket = (char) myStack.pop();  // pop a char
                        
                        /* Check a char */
                        if ((rightBracket == '}' && leftBracket != '{') 
                            || (rightBracket == ']' && leftBracket != '[') 
                            || (rightBracket == ')' && leftBracket != '(')) {
                            System.out.println("Error: " + rightBracket + " at " + idx);
                        }
                    } else {
                        System.out.println("Error: " + rightBracket + " at " + idx);
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
