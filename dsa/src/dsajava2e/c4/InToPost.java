package dsajava2e.c4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InToPost {
    private MyStack myStack;
    private String input;
    private String output = "";

    public InToPost(String input) {
        this.input = input;
        int stackSize = input.length();
        myStack = new MyStack(stackSize);
    }

    /* Do translation to postfix */
    public String doTrans() {
        for (int idx = 0; idx < input.length(); idx++) {
            char ch = input.charAt(idx);
            myStack.displayStack("For " + ch + " ");
            
            switch(ch) {
                case '+', '-':              // it's + or -
                    gotOper(ch, 1);         // go pop operators
                    break;                  //   (precedence 1)
                case '*', '/':              // it's * or /
                    gotOper(ch, 2);         // go pop operators
                    break;                  //   (precedence 2)
                case '(':                   // it's a left paren
                    myStack.push(ch);       // push it
                    break;
                case ')':                   // it's a right paren
                    gotParen(ch);           // go pop operators
                    break;
                default:                    // must be an operand
                    output = output + ch;   // write it to output
                    break;
            }
        }
        
        while (!myStack.isEmpty()) {         // pop remaining opers
            myStack.displayStack("While ");  // *diagnostic*
            output = output + myStack.pop(); // write to output
        }
        myStack.displayStack("End   ");     // *diagnostic*
        return output;                      // return postfix
    }

    /* Got operator from input */
    public  void gotOper(char opThis, int prec1) {
        while(!myStack.isEmpty()) {
            char opTop = (char) myStack.pop();

            if (opTop == '(') {         // if it's a '('
                myStack.push(opTop);    // restore '('
                break;
            } else {                    // it's an operator
                int prec2;              // precedence of new op

                if (opTop=='+' || opTop=='-') { // find new op prec
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                
                if (prec2 < prec1) { // if prec of new op less than prec of old
                    myStack.push(opTop); // save newly-popped op
                    break;
                } else { // prec of new not less than prec of old
                    output = output + opTop;
                }
            } 
            myStack.push(opThis); // push new operator
        } 
    }

    /* Got right paren from input */
    public  void gotParen(char ch) {
        while (!myStack.isEmpty()) {
            char chx = (char) myStack.pop();
            if (chx == '(') {               // if popped '('
                break;                      // we're done
            } else {                        // if popped operator
                output = output + chx;      // output it
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
        String input, output;
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();         // read a string from kbd
            
            if( input.equals("") )       // quit if [Enter]
                break;

            /* Make a translator */
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // do the translation
            System.out.println("Postfix is " + output + '\n');
        } 
    }
}