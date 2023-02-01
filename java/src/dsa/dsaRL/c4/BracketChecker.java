package dsa.dsaRL.c4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Stack Example 2: Delimiter Matching. */
class BracketChecker {
    private String input; 

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length(); // get max stack size
        Stack stack = new Stack(stackSize);
  
        for (int i = 0; i < stackSize; i++) { // get chars in turn
            char ch = input.charAt(i);        // get char
            
            switch (ch) {
                case '{':                      // opening symbols
                case '[':
                case '(':
                    stack.push(ch);            // push them
                    break;
                case '}':                      // closing symbols
                case ']':
                case ')':
                    if (!stack.isEmpty()) { 
                        char chx = (char) stack.pop();  // pop and check
                        
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {                        // prematurely empty
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:    // no action on other characters
                    break;
            }
        }
        // at this point, all characters have been processed
        if (!stack.isEmpty())
           System.out.println("Error: missing right delimiter");
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        String input;
        
        while(true) {
            System.out.print( "Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;
            // Make a BracketChecker
            BracketChecker checker = new BracketChecker(input);
            checker.check();
        }
    }
}