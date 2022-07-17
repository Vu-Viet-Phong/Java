package goodrich.c3;

/**
 * A basic singly linked list implementation. 
 * 
 * @link https://en.wikipedia.org/wiki/Linked_list#Singly_linked_list
 */
public class SinglyLinkedList<E> {
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

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {}

    /** Returns the number of elements in the linked list. */
    public int size() {
        return size;
    }

    /** Tests whether the linked list is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns (but does not remove) the first element. */
    public E first() {
        if (isEmpty()) { 
            return null;
        }
        return head.getElement();
    }

    /** Returns (but does not remove) the last element. */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /** Adds element to the front of the list. */
    public void addFirst(E element) {
        head = new Node<>(element, head);

        if (size == 0) {
            tail = head;
        }
        size++;
    }

    /** Adds element e to the end of the list. */
    public void addLast(E element) {
        Node<E> newest = new Node<>(element, null);

        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    /** Removes and returns the first element. */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;
         
        if (size == 0) {
            tail = null;
        }

        return answer;
    }
}