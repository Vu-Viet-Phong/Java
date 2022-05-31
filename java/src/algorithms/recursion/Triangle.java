package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    /** Evaluates triangular numbers */
    public static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangle(n - 1);
        }
    }

    public static void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }

        for (int idx = 0; idx < newSize; idx++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                displayWord();
            } 
            rotate(newSize);
        }
    }

    /** Rotate left all chars from position to end */
    public static void rotate(int newSize) {
        int idx;
        int position = size - newSize;
        char temp = arrChar[position];

        for (idx = position +1; idx < size; idx++) {
            arrChar[idx - 1] = arrChar[idx];
        }
        arrChar[idx - 1] = temp;
    }

    public static void displayWord() {
        if (count < 99) {
            System.out.print(" ");
        }
        
        if (count < 9) {
            System.out.print(" ");
        }
        System.out.print(++count + " ");

        for (int idx = 0; idx < size; idx++) {
            System.out.print(arrChar[idx]);
        }
        System.out.print(" ");
        
        if (count % 6 == 0) {
            System.out.println("");
        }
    }

    public static String getString() throws IOException {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static void testTriangle() throws IOException {
        System.out.print("Enter a number: ");
        int theNumber = getInt();
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle = " + theAnswer);
    } 

    public static void testAnagram() throws IOException {
        System.out.print("Enter a word: ");
        String input = getString();
        size = input.length();
        count = 0;
        for (int idx = 0; idx < size; idx++) {
            arrChar[idx] = input.charAt(idx);
        }
        doAnagram(size);
    }
    
    public static void main(String[] args) throws IOException {
        // testTriangle();
        testAnagram();
    }
}
