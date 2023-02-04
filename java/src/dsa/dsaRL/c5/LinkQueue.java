package dsa.dsaRL.c5;

/** Implements a Stack using a Double-Ended Linked List  */
class LinkQueue {
    private DoubleEndedLinkedList dellist;

    public LinkQueue() {
        dellist = new DoubleEndedLinkedList();
    }

    /** Inserts an element at the rear of the queue */
    public void insert(long item) {
        dellist.insertLast(item);
    }

    /**
     * Remove an element from the front of the queue
     * @return the new front of the queue
     */
    public long remove() {
        return dellist.deleteFirst();
    }

    /** Returns true if the queue is empty */
    public boolean isEmpty() {
        return dellist.isEmpty();
    }

    public void displayQueue() {
        dellist.displayList();
    }

    public static void main(String[] args) {
        LinkQueue lQueue = new LinkQueue();

        lQueue.insert(20);
        lQueue.insert(40);
        lQueue.insert(60);
        lQueue.insert(80);
        lQueue.displayQueue();

        lQueue.remove();
        lQueue.displayQueue();
        lQueue.remove();
        lQueue.displayQueue();
    }
}