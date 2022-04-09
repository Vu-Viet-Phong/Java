package algorithms.datastructures.queues;

public class MyQueue {
    private static final int DEFAULT_CAPACITY = 10; 
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    /* Initial Stack with default capacity */
    private MyQueue() {
        this(DEFAULT_CAPACITY);
    }

    /* Initial Stack with input size */
    private MyQueue(int size) {
        maxSize = size;
        queueArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("Can't insert, queue is full.");
        }

        if (rear == maxSize) {
            rear = -1;
        }
        queueArray[++rear] = value;
        nItems++;
    }

    public int remove() {
        int temp = queueArray[front++];

        if (front == maxSize) {
            front = 0;
        }
        nItems--;

        return temp;
    }

    /**
     * Returns true if the queue is empty
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * Returns true if the queue is full
     *
     * @return true if the queue is full
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }
}
