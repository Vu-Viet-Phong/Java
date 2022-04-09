package algorithms.datastructures.stacks;

public class StackArray {
    private static final int DEFAULT_CAPACITY = 10;
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray() {
        this(DEFAULT_CAPACITY);
    }

    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

     /**
     * Adds an element to the top of the stack
     *
     * @param value The element added
     */
    public void push(int value) {
        if (!isFull()) {
            stackArray[++top] = value;
        } else {
            System.out.print("Can't push, stack is full.");
        }
    }

    /**
     * Removes the top element of the stack and returns the value you've removed
     *
     * @return value popped off the Stack
     */
    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Can't pop, stack is empty.");
        }

        return -1;
    }

    /**
     * Returns the element at the top of the stack
     * 
     * @return element at the top of the stack
     */
    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Can't peek, stack is empty");
            return -1;
        }
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
     * @return true if the stack is full
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    /**
     * Deletes everything in the Stack
     * Doesn't delete elements in the array but if you call push 
     * method after calling makeEmpty it will overwrite previous 
     * values
     */
    public void makeEmpty() { 
        top = -1;
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
        StackArray myStack = new StackArray(10);

        /* push items onto stack */
        myStack.push(20);
        myStack.push(40);
        myStack.push(60);
        myStack.push(80);

        while (!myStack.isEmpty()) {
            System.out.print(myStack.peek());
            myStack.pop();
            System.out.print(" ");
        }
        System.out.println("");
    }
}