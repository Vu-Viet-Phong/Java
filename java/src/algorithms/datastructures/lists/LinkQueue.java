package algorithms.datastructures.lists;

public class LinkQueue {
    private DoubleEndedLinkedList llist;

    public LinkQueue() {
        llist = new DoubleEndedLinkedList();
    }

    public boolean isEmpty() {
        return llist.isEmpty();
    }

    public void insert(int item) {
        llist.insertLast(item); 
    }

    public int remove() {
        return llist.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front --> rear): ");
        llist.displayList();
    }

    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);
        theQueue.displayQueue();

        theQueue.insert(60);
        theQueue.insert(80);
        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();
        theQueue.displayQueue(); 
    }
}
