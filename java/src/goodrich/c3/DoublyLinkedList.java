package goodrich.c3;

/**
 * A basic doubly linked list implementation. 
 * 
 * @link https://en.wikipedia.org/wiki/Doubly_linked_list
 */
public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;          // reference to the element stored at this node
        private Node<E> previous;   // reference to the previous node in the list
        private Node<E> next;       // reference to the subsequent node in the list

        public Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    /** Instance variables of the DoublyLinkedList. */
    private Node<E> header;     // header sentinel
    private Node<E> trailer;    // trailer sentinel
    private int size = 0;       // number of elements in the list

    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); 
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    /** Returns the number of elements in the linked list. */
    public int size() {
        return size;
    }

    /** Tests whether the linked list is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns (but does not remove) the first element of the list. */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement(); // first element is beyond header
    }

    /** Returns (but does not remove) the last element of the list. */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrevious().getElement(); // last element is before trailer
    }

    /** Adds element e to the front of the list. */
    public void addFirst(E element) {
        addBetWeen(element, header, header.getNext()); // place just before the header
    }

    /** Adds element e to the end of the list. */
    public void addLast(E element) {
        addBetWeen(element, trailer.getPrevious(), trailer); // place just before the trailer
    }

    /** Removes and returns the first element of the list. */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext()); // first element is before trailer
    }

    /** Removes and returns the last element of the list. */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrevious()); // last element is before trailer
    } 

    /** Adds element e to the linked list in between the given nodes. */
    private void addBetWeen(E element, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(element, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrevious(newest);
        size++;
    }

    /** Removes the given node from the list and returns its element. */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrevious();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        size--;

        return node.getElement();
    }
}