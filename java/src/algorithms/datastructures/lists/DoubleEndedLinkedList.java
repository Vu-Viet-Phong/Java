package algorithms.datastructures.lists;

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public void displayNode() {
        System.out.print(value + " ");
    }
}

public class DoubleEndedLinkedList {
    private Node first; // ref to first link
    private Node last;  // ref to last link

    public DoubleEndedLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    public int deleteFirst() {
        int temp = first.value;

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
        System.out.println("List (first --> last): ");
        Node current = first;

        while (current != null) {
            current.displayNode();
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
