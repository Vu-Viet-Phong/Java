package goodrich.c6;

import java.util.Arrays;

import iu.dsa.tung.labs.lab02.Array;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000; // default array capacity
    private E[] data; // generic array used for storage
    private int top = -1; // index of the top element in stack

    /**
     * Constructs stack with default capacity 
     */
    public ArrayStack() { 
        this(CAPACITY); 
    }

    /**
     * Constructs stack with given capacity
     */
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() { 
        return top + 1; 
    }

    public boolean isEmpty() { 
        return top == -1; 
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) 
            throw new IllegalStateException("Stack is full");
        data[++top] = e;
    }

    public E top() {
        if (isEmpty()) return null;
        return data[top];
    }

    public E pop() {
        if (isEmpty()) return null;
        E answer = data[top];
        data[top] = null;
        top--;
        return answer;
    }

    /** A generic method for reversing an array. */
    public static <E> void reserve(E[] arr) {
        int n = arr.length;
        Stack<E> buffer = new ArrayStack<>(n);

        for (int i = 0; i < n; i++) {
            buffer.push(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = buffer.pop();
        }
    }

    public static void testStack() {
        Stack<Integer> S = new ArrayStack<>(); 
        S.push(5);                          
        S.push(3);                          
        System.out.println(S.size());           
        System.out.println(S.pop());            
        System.out.println(S.isEmpty()); 
        System.out.println(S.pop()); 
        System.out.println(S.isEmpty()); 
        System.out.println(S.pop()); 
        S.push(7); 
        S.push(9); 
        System.out.println(S.top()); 
        S.push(4); 
        System.out.println(S.size()); 
        System.out.println(S.pop()); 
        S.push(6); 
        S.push(8);
        System.out.println(S.pop());
    }

    public static void testReversingArray() {
        Integer[] arr = {4, 8, 15, 16, 23, 42}; // autoboxing allows this
        String[] str = {"Jack", "Kate", "Hurley", "Jin", "Michael"};

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("str = " + Arrays.toString(str));
        System.out.println("Reversing...");
        reserve(arr);
        reserve(str);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("str = " + Arrays.toString(str));
    }

    public static void main(String[] args) {
        // testStack();
        testReversingArray();
    }
}