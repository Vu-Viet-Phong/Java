package datastructures.stacks;

public class StackArray {
    private int maxSize;        // The max size of the stack
    private int[] stackArray;   // The array representation of the stack
    private int top;            // The top of the stack

    public StackArray(int max) {
        maxSize = max;
        stackArray = new int[maxSize];
        top = -1;
    }

    /**
     * Adds an element to the top of the stack
     *
     * @param value The element added
     */
    public void push(int value) {
        if (!isFull()) { // Checks for a full stack
            top++;
            stackArray[top] = value;
        } else {
            resize(maxSize * 2);
            push(value); // don't forget push after resizing
        }
    }

    /**
     * Removes the top element of the stack and returns the value you've removed
     *
     * @return value popped off the Stack
     */
    public int pop() {
        if (!isEmpty()) { // Checks for an empty stack
            return stackArray[top--];
        }

        if (top < maxSize / 4) {
            resize(maxSize / 2);
            return pop(); // don't forget pop after resizing
        } else {
            System.out.println("The stack is already empty");
            return -1;
        }
    }

    /**
     * Returns the element at the top of the stack
     *
     * @return element at the top of the stack
     */
    public int peek() {
        if (!isEmpty()) { // Checks for an empty stack
            return stackArray[top];
        } else {
            System.out.println("The stack is empty, cant peek");
            return -1;
        }   
    }

    private void resize(int newSize) {
        int[] transferArray = new int[newSize];

        for (int i = 0; i < stackArray.length; i++) {
            transferArray[i] = stackArray[i];
        }
        // This reference change might be nice in here
        stackArray = transferArray;
        maxSize = newSize;
    }
    
    /**
     * Returns true if the stack is empty
     * 
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Returns true if the stack is full
     * 
     * @return true if the stack is full, 
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    /**
     * Return size of stack
     *
     * @return size of stack
     */
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackArray stackArr = new StackArray(10);
        stackArr.push(20);
        stackArr.push(40);
        stackArr.push(60);
        stackArr.push(80);

        System.out.println(stackArr.size());
        System.out.println(stackArr.pop());
        System.out.println(stackArr.isFull());
        
        stackArr.push(10);
        stackArr.push(15);
        stackArr.push(65);
        stackArr.push(22);
        stackArr.push(30);
        stackArr.push(50);

        System.out.println(stackArr.size());
        System.out.println(stackArr.pop());
        System.out.println(stackArr.isFull());
    }
}
