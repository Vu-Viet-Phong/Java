package tung.lab03;

import java.util.Stack;

public class Problem1 {
    /**
     * Convert a decimal number and convert it to octal form
     * 
     * @param dec a decimal number
     * @return an octal number
     */
    public static String decToOcta(int dec){
		Stack<Integer> octForm = new Stack<>();
		String s = new String();
		
        if (dec == 0) {
            octForm.push(0);
        }

		while (dec > 0) {
			octForm.push(dec % 8);
			dec /= 8;
		}
		
		while (octForm.isEmpty() != true) {
			s += octForm.peek().toString();
			octForm.pop();
		}

		return s;
	}

    /**
     * Concatenate two stacks
     * 
     * @param <T>
     * @param s1 first stack
     * @param s2 second stack
     * @return new stack
     */
    public static <T> Stack<T> concatenate(Stack<T> s1, Stack<T> s2) {
		Stack<T> stack1 = (Stack<T>) s1.clone();
		Stack<T> stack2 = (Stack<T>) s2.clone();

		while (!stack2.isEmpty()) {
			stack1.push(stack2.peek());
			stack2.pop();
		}
		
        return stack1;
	}
	
    /**
     * Determine if the contents of one stack are identical to that of another
     * 
     * @param <T>
     * @param st1 first stack
     * @param st2 second stack
     * @return true if identical, false otherwise
     */
	public static <T> Boolean checkIdentical(Stack<T> stack1, Stack<T> stack2) {
		if (stack1.size() != stack2.size()) {
            return false;
        }

		while (!stack1.isEmpty()) {
			if (!stack1.peek().equals(stack2.peek())) {
                return false;
            } 
            
            stack1.pop();
            stack2.pop();
		}

		return true;
	}

    public static void main(String[] args) {
		// ***** Decimal to Octa ***** //
		int dec = 100;
		System.out.println(decToOcta(dec));
		
		// ***** Concatenate ***** //
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		stack1.push(1);
		stack1.push(2);
		stack1.push(5);
		stack1.push(4);
		stack1.push(7);
		
		stack2.push(9);
		stack2.push(7);
		stack2.push(2);
		stack2.push(9);
		stack2.push(4);
		
		Stack<Integer> st = new Stack<Integer>();

		st = concatenate(stack1, stack2);
		while (!st.isEmpty()) {
			System.out.print(st.peek() + " ");
			st.pop();
		}
	
		System.out.println();
		
		// ***** Check identical***** //
		// Stack 1
        stack1.clear();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		
        // Stack 2
        stack2.clear();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		stack2.push(4);
		stack2.push(5);

        // Stack 3
        Stack<Integer> stack3 = new Stack<Integer>();
        stack3.push(6);
		stack3.push(7);
		stack3.push(8);
		stack3.push(9);
		stack3.push(10);

		if (checkIdentical(stack1, stack2)) {
            System.out.println("stack1 is identical to stack2");
        } else {
            System.out.println("stack1 isn't identical to stack2");
        }

        if (checkIdentical(stack2, stack3)) {
            System.out.println("stack2 is identical to stack3");
        } else {
            System.out.println("stack2 isn't identical to stack3");
        }
	}
}