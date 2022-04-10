package algorithms.datastructures.queues;

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

    /**
     * Inserts an element in it's appropriate place
     *
     * @param value Value to be inserted
     */
    public void insert(int item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else if (isEmpty()) {
            queueArray[nItems++] = item; 
        } else {
            int idx = nItems - 1;
            
            while (idx >= 0 && queueArray[idx] > item) {
                queueArray[idx + 1] = queueArray[idx];
                idx--;
            }
            queueArray[idx + 1] = item;
            nItems++;
        }
    }

    /**
     * Remove the element from the front of the queue
     *
     * @return The element removed
     */
    public int remove() {
        return queueArray[--nItems];
    }

    /**
     * Checks what's at the front of the queue
     *
     * @return element at the front of the queue
     */
    public int peek() {
        return queueArray[nItems - 1];
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
        PriorityQueue thePQ = new PriorityQueue(5);
        
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while(!thePQ.isEmpty()) {
            System.out.print(thePQ.remove() + " ");  // 10, 20, 30, 40, 50
        }
        System.out.println("");
    }
}
