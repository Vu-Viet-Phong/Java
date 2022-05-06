package algorithms.datastructures.stacks.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithms.datastructures.stacks.MyStack;

/**
 * Stack used to reverse a string
 */
public class ReversingWord {
    private String word;

    public ReversingWord(String input) { 
        word = input; 
    }

    /* Reverse the string */
    public String doReverser() {
        MyStack myStack = new MyStack(word.length());

        for (int idx = 0; idx < word.length(); idx++) {
            myStack.push(word.charAt(idx));
        }

        String output = "";
        while (!myStack.isEmpty()) { 
            output += (char) myStack.pop(); // append to output
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
            ReversingWord reverser = new ReversingWord(input);
            System.out.println("Reversed: " + reverser.doReverser());
        }
    }
}
