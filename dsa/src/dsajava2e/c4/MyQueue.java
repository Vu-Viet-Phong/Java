package dsajava2e.c4;

public class MyQueue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int nItems;
    
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    
    public void insert(long value) {
        if (rear == maxSize - 1) { 
            rear = -1;
        }
        queueArray[++rear] = value; 
        nItems++; 
    }
    
    public long remove() {
        long temp = queueArray[front++];
        
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        
        return temp;
    }
    
    public long peekFront() {
        return queueArray[front];
    }
    
    public boolean isEmpty() {
        return (nItems == 0);
    }
    
    public boolean isFull() {
        return (nItems == maxSize);
    }
    
    public int size() {
        return nItems;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);

        /* Insert 4 items */
        myQueue.insert(10);            
        myQueue.insert(20);
        myQueue.insert(30);
        myQueue.insert(40);

        /* Remove 3 items */
        myQueue.remove(); // 10 
        myQueue.remove(); // 20
        myQueue.remove(); // 30

        /* Insert 4 items */
        myQueue.insert(50);
        myQueue.insert(60);
        myQueue.insert(70);
        myQueue.insert(80);

        while (!myQueue.isEmpty()) {
            long n = myQueue.remove();  // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
}