package goodrich.c3;

/**
 * A basic circularly linked list implementation. 
 * 
 * @link https://en.wikipedia.org/wiki/Linked_list#Singly_linked_list
 */
public class CircularlyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> tail = null;
    private int size = 0; // number of nodes in the list

    public CircularlyLinkedList() {}

    public int size() { 
        return size; 
    }
    
    public boolean isEmpty() { 
        return size == 0; 
    }

    /** Returns (but does not remove) the first element. */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    /** Returns (but does not remove) the last element. */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /** Rotate the first element to back of the list. */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    /** Adds element to the front of the list. */
    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException("Cannot add null element to the list");
        }

        if (size == 0) {
            tail = new Node<>(element, tail.getNext());
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(element, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /** Adds element e to the end of the list.  */
    public void addLast(E element) {
        addFirst(element);
        tail = tail.getNext();
    }

    /** Removes and returns the first element. */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> head = tail.getNext();
        
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;

        return head.getElement();
    }
}