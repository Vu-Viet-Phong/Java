package iu.dsa.tung.labs.lab03;

public class Problem1 {
    public static String decToOcta(int dec){
        MyStack octForm = new MyStack(10);

        if (dec == 0) { 
            octForm.push(0);
        }

        while (dec > 0) {
            octForm.push(dec % 8);
            dec /= 8;
        }

        String s = "";
        while (!octForm.isEmpty()) {
            s += octForm.pop();
        }

        return s;
	}

    public static MyStack concatenate(MyStack s1, MyStack s2) {
        MyStack newStack = new MyStack(s1.size() + s2.size());

        while (!s1.isEmpty()) {
            newStack.push(s1.peek());
            s1.pop();
        }

        while (!s2.isEmpty()) {
            newStack.push(s2.peek());
            s2.pop();
        }

        return newStack;
    }

    public static boolean checkIdentical(MyStack s1, MyStack s2) {
        if (s1.size() != s2.size()) {
            return false;
        }

        while (!s1.isEmpty()) {
            if (s1.peek() != s2.peek()) {
                return false;
            }
            s1.pop();
            s2.pop();
        }

        return true;
    }

    public static void main(String[] args) {
        // ***** Decimal to Octa ***** //
		int dec = 100;
		System.out.println(decToOcta(dec));

        // ***** Concatenate ***** //
        MyStack stack1 = new MyStack(3);
		MyStack stack2 = new MyStack(3);
		
		stack1.push(1);
		stack1.push(2);
		stack1.push(5);
		stack2.push(4);
		stack2.push(7);
		stack2.push(9);

        /* MyStack stack3 = new MyStack(stack1.size() + stack2.size());

        stack3 = concatenate(stack1, stack2);
        while (!stack3.isEmpty()) {
            System.out.print(stack3.pop() + " ");
        }
        System.out.println(""); */

        // ***** Check identical***** //
        if (checkIdentical(stack1, stack2)) {
            System.out.println("stack1 is identical to stack2");
        } else {
            System.out.println("stack1 isn't identical to stack2");
        }
    }
}