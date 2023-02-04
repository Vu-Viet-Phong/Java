package dsa.dsaRL.c5;

/** Implements a Double-Ended Linked List */
public class DoubleEndedLinkedList {
    private Link first;
    private Link last;

    public DoubleEndedLinkedList()  {
        first = null;
        last = null;
    }

    /** Returns true if list is empty */
    public boolean isEmpty() {
        return (first == null);
    }

    /** Insert at front of list */
    public void insertFirst(long value) {
        Link newLink = new Link(value);

        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    /** Insert at end of list */
    public void insertLast(long value) {
        Link newLink = new Link(value);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    /** Delete first link */
    public long deleteFirst() {
        long temp = first.data;
        
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        
        return temp;
    }

    public void displayList() {
        Link current = first;
        
        System.out.print("List (first-->last): ");
        while (current != null) {
            current.displayLink(); 
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DoubleEndedLinkedList dell = new DoubleEndedLinkedList();

        dell.insertFirst(22);
        dell.insertFirst(44);
        dell.insertFirst(66);
        dell.displayList();

        dell.insertLast(11);
        dell.insertLast(33);
        dell.insertLast(55);
        dell.displayList();
        
        dell.deleteFirst();
        dell.deleteFirst();
        dell.displayList();
    }
}