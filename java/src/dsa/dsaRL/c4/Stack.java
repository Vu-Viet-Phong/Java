package dsa.dsaRL.c4;

/** Implements a Stack using an array */
class Stack {
    private static final int DEFAULT_CAPACITY = 10;
    private int maxSize;
    private long[] stackArray;
    private int top;

    /** Initial Stack with default capacity */
    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /** Initial Stack with input size */
    public Stack(int size) {
        maxSize = size;
        stackArray = new long[maxSize];
        top = -1;
    }

    /** Adds an element to the top of the stack */
    public void push(long value) {
        if (isFull()) {
            System.out.print("Can't push, stack is full.");
        } else {
            stackArray[++top] = value;
        }
    }

    /**
    * Removes the top element of the stack
    * @returns the removed value
    */
    public long pop() {
        if (isEmpty()) {
            System.out.println("Can't pop, stack is empty.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    /** Returns the element at the top of the stack */
    public long peek() {
        if (isEmpty()) {
            System.out.println("Can't peek, stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    /** Returns true if the stack is empty */
    public boolean isEmpty() {
        return top == -1;
    }

    /** Returns true if the stack is full */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }
}