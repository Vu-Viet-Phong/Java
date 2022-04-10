package algorithms.datastructures.lists;

public class DoubleEndedLinkedList {
    private Link first; // ref to first link
    private Link last;  // ref to last link

    public DoubleEndedLinkedList() {
        first = null;
        last = null;
    }

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

    public int deleteFirst() {
        int temp = first.data;

        if (first.next == null) {
            last = null;
        }
        first = first.next;
        
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DoubleEndedLinkedList theList = new DoubleEndedLinkedList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        
        theList.displayList(); // display the list
        theList.deleteFirst(); // delete first two items
        theList.deleteFirst();
        theList.displayList(); // display again
    }
}
