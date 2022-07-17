package goodrich.c6;

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

    public static void main(String[] args) {
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
}
