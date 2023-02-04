package dsa.dsaRL.c5;

/** Implements a Linked List */
public class LinkedList {
    private Link first;

    public LinkedList() {
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

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertFirst(22);
        ll.insertFirst(44);
        ll.insertFirst(66);
        ll.insertFirst(88);
        ll.displayList(); 

        while (!ll.isEmpty()) {
            Link link = ll.deleteFirst();
            System.out.print("Deleted ");
            link.displayLink();
            System.out.println("");
        }

        ll.insertFirst(11);
        ll.insertFirst(33);
        ll.insertFirst(55);
        ll.insertFirst(77);
        ll.insertFirst(99);
        ll.displayList(); 

        Link f = ll.find(55);
        if (f != null) {
            System.out.println("Found link with key " + f.data);
        } else {
            System.out.println("Can't find link");
        }

        Link d = ll.delete(55);
        if (d != null) {
            System.out.println("Deleted link with key " + d.data);
        } else {
            System.out.println("Can't delete link");
        }

        ll.displayList(); 
    }
}