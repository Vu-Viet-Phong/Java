package dsa.practices.linkedlist;

public class SinglyLinkedList {
    private Link first;

    public SinglyLinkedList() {
        first = null;
    }

    /** Returns true if list is empty */
    public boolean isEmpty() {
        return (first == null);
    }

    /** Insert at start of list */
    public void insertFirst(long value) {
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
    }

    /** Delete first item */
    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    /** Insert a node after a given node */
    public void insertAfter(Link prev_link, long value) {
        if (prev_link == null) {
            System.out.println(
                "The given previous node cannot be null");
        }
        Link newLink = new Link(value);
        newLink.next = prev_link.next;
        prev_link.next = newLink;
    }

    /** Find link with given key */
    public Link find(long key) {
        Link current = first;

        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }

        return current;
    }

    /** Delete link with given key */
    public Link delete(long key) {
        Link current = first;
        Link previous = first;

        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        
        return current;
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
}