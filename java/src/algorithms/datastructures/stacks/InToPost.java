package algorithms.datastructures.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    /** Put item on top of stack */
    public void push(char item) {
        stackArray[++top] = item;
    }

    /** Take item from top of stack */
    public char pop() {
        return stackArray[top--];
    }

    /** Peek at top of stack */
    public char peek() {
        return stackArray[top];
    }

    /** Return item at index n */
    public char peekN(int n) {
        return stackArray[n];
    }

    /** True if stack is empty */
    public boolean isEmpty() {
        return top == -1;
    }

    /** Return size of stack */
    public int size() {
        return top + 1;
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom --> top): ");

        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print("");
        }
        System.out.println("");
    }
}

/**
 * Converts infix arithmetic expressions to postfix
 */
class InToPost {
    private Stack theStack;
    private String input;
    private String output = "";
    private int stackSize;

    public InToPost(String input) {
        this.input = input;
        stackSize = input.length();
        theStack = new Stack(stackSize);
    }

    /** Do translate to postfix */
    public String doTrans() {
        int n = input.length();

        for (int i = 0; i < n; i++) {
            char ch = input.charAt(i);
            theStack.displayStack("For " + ch + ""); // *giagnostic*

            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2); // go pop operators (precedence 2)
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default: 
                    output += ch;
                    break;
            } 
        }

        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output += theStack.pop();
        }
        theStack.displayStack("End  ");

        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            
            if (opTop == '(' ) { // if it's a '('
                theStack.push(opTop); // restore '('
                break;
            } else { // it's an operator precedence of new op
                int prec2; 
                
                // Find new op precedence
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else { // it's an operator precedence of new op
                    prec2 = 2;
                }

                if (prec2 < prec1) { 
                    theStack.push(opTop); // save newly popped op
                    break;
                } else { 
                    output += opTop; 
                }
            }
        }
        theStack.push(opThis); // push new operator
    }

    public void gotParen(char ch) {
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();

            if (ch == '(') break;
            else output += chx;
        }
    }
}

class InfixApp {
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            String input = getString(); 
            if (input.equals("")) break;
            InToPost theTrans = new InToPost(input); // make a translator
            String output = theTrans.doTrans(); // do the translation
            System.out.println("Postfix is " + output + '\n');
        }
    } 
}
