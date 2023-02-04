package dsa.practices.linkedlist;

class LinkedList {
    private Node first;

    public LinkedList() {
        first = null;
    }

    /** Returns true if list is empty */
    public boolean isEmpty() {
        return (first == null);
    }

    /** Insert at start of list */
    public void insertFirst(long value) {
        Node newNode = new Node(value);
        newNode.next = first;
        first = newNode;
    }

    /** Insert a node after a given node */
    public void insertAfter(Node prevNode, long value) {
        if (prevNode == null) {
            System.out.println(
                "The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(value);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void insertLast(long value) {
        Node newNode = new Node(value);

        if (first == null) {
            first = new Node(value);
            return;
        }
        newNode.next = null;

        Node last = first;

        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;

        return;
    }
    
    /** Delete first item */
    public Node deleteFirst() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    /** Find link with given key */
    public Node find(long key) {
        Node current = first;

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
    public Node delete(long key) {
        Node current = first;
        Node previous = first;

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
        Node current = first;
        
        System.out.print("List (first-->last): ");
        while (current != null) {
            current.displayNode(); 
            current = current.next;
        }
        System.out.println("");
    }
}