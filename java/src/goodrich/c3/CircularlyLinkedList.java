package goodrich.c3;

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
    private int size = 0;

    public CircularlyLinkedList() {}

    public int size() { 
        return size; 
    }
    
    public boolean isEmpty() { 
        return size == 0; 
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * Rotate the first element to back of the list.
     */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    
    public void addFirst(E element) {
        if (size == 0) {
            tail = new Node<>(element, tail.getNext());
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(element, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
}
