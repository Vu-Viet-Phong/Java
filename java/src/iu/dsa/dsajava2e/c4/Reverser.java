package dsajava2e.c4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser {
    private String input;

    public Reverser(String input) { 
        this.input = input; 
    }

    /* Reverse the string */
    public String doReverser() {
        int stackSize = input.length();
        MyStack myStack = new MyStack(stackSize);

        for (int idx = 0; idx < input.length(); idx++) {
            char ch = input.charAt(idx);    // get a char from input
            myStack.push(ch);               // push it
        }

        String output = "";
        while (!myStack.isEmpty()) {        // if stack not empty
            char ch = (char) myStack.pop(); // pop a char
            output += ch;                   // append to output
        }

        return output;
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            
            String input = getString();     // read a string
            if (input.equals("")) {         // quit if [Enter]
                break;
            }
            
            /* Make a Reverser */
            Reverser reverser = new Reverser(input);
            System.out.println("Reversed: " + reverser.doReverser());
        }
    }
}