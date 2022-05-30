package algorithms.datastructures.queues;

/**
 * Implements a Queue using an array
 */
public class Queue {
    private static final int DEFAULT_CAPACITY = 10; 
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    /* Initial Stack with default capacity */
    private Queue() {
        this(DEFAULT_CAPACITY);
    }

    /* Initial Stack with input size */
    private Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Inserts an element at the rear of the queue
     *
     * @param item element to be added
     * @return true if the element was added successfully
     */
    public void insert(int item) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = item;
        nItems++;
    }

    /**
     * Remove an element from the front of the queue
     *
     * @return the new front of the queue
     */
    public int remove() {
        int temp = queueArray[front++];

        if (front == maxSize) {
            front = 0;
        }
        nItems--;

        return temp;
    }

    /**
     * Checks what's at the front of the queue
     *
     * @return element at the front of the queue
     */
    public int peekfront() {
        return queueArray[front];
    }

    /**
     * Checks what's at the rear of the queue
     *
     * @return element at the rear of the queue
     */
    public int peekRear() {
        return queueArray[rear];
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

    /**
     * Returns the number of elements in the queue
     *
     * @return number of elements in the queue
     */
    public int getSize() {
        return nItems;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(5);

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
            System.out.print(myQueue.remove() + " ");// (40, 50, 60, 70, 80)
        }
        System.out.println("");
    }
}