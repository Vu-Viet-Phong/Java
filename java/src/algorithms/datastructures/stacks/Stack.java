package algorithms.datastructures.stacks;

/** Implements a Stack using an array */
public class Stack {
    private static final int DEFAULT_CAPACITY = 10;
    private int maxSize;
    private int[] stackArray;
    private int top;

    /** Initial Stack with default capacity */
    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /** Initial Stack with input size */
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    /**
     * Adds an element to the top of the stack
     * @param item The element added
     */
    public void push(int item) {
        if (isFull()) {
            System.out.print("Can't push, stack is full.");
        } else {
            stackArray[++top] = item;
        }
    }

    /**
     * Removes the top element of the stack and returns the value you've removed
     * @return value popped off the Stack
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Can't pop, stack is empty.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    /**
     * Returns the element at the top of the stack
     * @return element at the top of the stack
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Can't peek, stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
        
    }

    /**
     * Returns true if the stack is empty
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns true if the stack is full                                                                                                                                                                                                                                                                                                               
     * @return true if the stack is full
     */
    public boolean isFull() {
        return top == maxSize - 1;
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
     * @return size of stack
     */
    public int getSize() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(4);

        /* Push items onto stack */
        myStack.push(20);
        myStack.push(40);
        myStack.push(60);
        myStack.push(80);

        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println("");
    }
}