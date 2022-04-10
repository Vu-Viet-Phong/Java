package iu.dsa.tung.labs.lab03;

public class MyStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        stackArray[++top] = value;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public int peekIdx(int idx) {
        return stackArray[idx];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int size() { 
        return top + 1; 
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int idx = 0; idx < size(); idx++) {
            System.out.print(peekIdx(idx));
            System.out.print(' ');
        }
        System.out.println("");
    }
}
