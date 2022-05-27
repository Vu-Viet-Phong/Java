package algorithms.datastructures.stacks.medium;

import algorithms.datastructures.stacks.Stack;

/**
 * Given a stack, the task is to sort it such that the top of the 
 * stack has the greatest element.
 * Input: 10 7 32 23 45
 * Output: 45 32 23 10 7 
 */
public class SortStack {
    public static Stack sortStack(Stack s) {
        Stack tempStack = new Stack(s.getSize());

        while (!s.isEmpty()) {
            int temp = s.peek();
            
            s.pop();    
            while (!tempStack.isEmpty() 
                && tempStack.peek() > temp) {
                s.push(tempStack.peek());
                tempStack.pop();
            }
            tempStack.push(temp);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();

        myStack.push(45);
        myStack.push(32);
        myStack.push(23);
        myStack.push(10);
        myStack.push(7);

        myStack = sortStack(myStack);

        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println("");
    }
}
