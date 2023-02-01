package dsa.dsaRL.c4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Reverse {
    private String input;

    public Reverse(String in) {
        input = in;
    }

    // Reverse the string
    public String doRev() {
        int stackSize = input.length(); // get max stack size
        Stack stack = new Stack(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i); // get a char from input
            stack.push(ch);
        }
        
        String output = "";
        while (!stack.isEmpty()) {
            char ch = (char) stack.pop(); 
            output = output + ch;
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
        String input, output;

        while(true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString(); // read a string from kbd
            if (input.equals("")) // quit if [Enter]
                break;

            Reverse reverser = new Reverse(input);
            output = reverser.doRev(); // use it
            System.out.println("Reversed: " + output);
        }
    }
}