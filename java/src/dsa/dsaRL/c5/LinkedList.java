package dsa.dsaRL.c5;

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
    public void insertFirst(int value) {
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

    public void displayList() {
        Link current = first; 
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
    }
}