package dsajava2e.c4;

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
    
        for (int idx = 0; idx < input.length(); idx++) {
            char ch = input.charAt(idx); // get a char from input

            switch (ch) {
                case '{', '[', '(':     // opening symbols
                    myStack.push(ch);   // push them
                    break;
                case '}', ']', ')':     // closing symbols
                    if (!myStack.isEmpty()) {  // if stack not empty
                        char chx = (char) myStack.pop();  // pop a char

                        /* Check a char */
                        if ((ch == '}' && chx != '{') 
                            || (ch == ']' && chx != '[') 
                            || (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + idx);
                        }
                    } else { // prematurely empty
                        System.out.println("Error: " + ch + " at " + idx);
                    }
                    break;
                default: // no action on other characters
                    break;
            }
        }

        // At this point, all characters have been processed
        if (!myStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
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