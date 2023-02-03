package dsa.dsaRL.c4;

/** Implements a Priority Queue using an array */
public class PriorityQueue {
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    /* Initial Priority Queue with input size */
    public PriorityQueue(int size) {
        maxSize = size;
        queueArray = new int[size];
        nItems = 0;
    }

    /** Inserts an element in it's appropriate place */
    public void insert(int item) {
        if (isFull()) {
            System.out.print("Queue is full.");
        } else if (isEmpty()) {
            queueArray[nItems++] = item; 
        } else {
            int i = nItems - 1;

            while (i >= 0 && queueArray[i] < item) {
                queueArray[i + 1] = queueArray[i];
                i--;
            }
            queueArray[i + 1] = item;
            nItems++;
        }
    }

    /**
     * Remove the element from the front of the queue
     * @return The element removed
     */
    public int remove() {
        return queueArray[--nItems];
    }

    /** Returns element at the front of the queue */
    public int peek() {
        return queueArray[nItems - 1];
    }

    /** Returns true if the queue is empty */
    public boolean isEmpty() {
        return nItems == 0;
    }

    /** Returns true if the queue is full */
    public boolean isFull() {
        return (nItems == maxSize); 
    }

    /** Returns the number of elements in the queue */
    public int getSize() {
        return nItems;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(40);
        pq.insert(20);

        while(!pq.isEmpty()) {
            System.out.println(pq.remove() + " ");
        }
    }
}
