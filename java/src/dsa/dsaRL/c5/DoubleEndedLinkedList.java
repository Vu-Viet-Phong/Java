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
    public void insertFirst(int value) {
        Link newLink = new Link(value);

        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int value) {
        Link newLink = new Link(value);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
}