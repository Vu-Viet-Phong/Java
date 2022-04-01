package goodrich.c3;

public class CircularlyLinkedList<E> {
    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) {next = n; }
    } //----------- end of nested Node class -----------

    // Instance variables of the CircularlyLinkedList
    private Node<E> tail = null; 
    private int size = 0;

    public CircularlyLinkedList() {}

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    /* Returns (but does not remove) the first element */
    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement(); // the head is *after* the tail
    }

    /* Returns (but does not remove) the last element */
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    /* Rotate the first element to the back of the list */
    public void rotate() {
        // If empty, do nothing. Otherwise, the old head becomes the new tail
        if (tail != null) tail = tail.getNext();
    }

    /* Adds element e to the front of the list */ 
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /* Adds element e to the end of the list */
    public void addLast(E e) {
        addFirst(e); // insert new element at front of list
        tail = tail.getNext(); // now new element becomes the tail
    }
    
    /* Removes and returns the first element */
    public E removeFirst() {
        if (isEmpty()) return null; // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) tail = null; // must be the only node left
        else tail.setNext(head.getNext()); // removes "head" from the list
        size--;
        return head.getElement();
    }
}