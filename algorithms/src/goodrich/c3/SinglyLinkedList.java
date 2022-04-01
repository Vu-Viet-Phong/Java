package goodrich.c3;

public class SinglyLinkedList<E> {
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

    // Instance variables of the SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    /* Returns (but does not remove) the first element */
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    /* Returns (but does not remove) the last element */
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    /* Adds element e to the front of the list */
    public void addFirst(E e) {
        head = new Node<>(e, head);     // create and link a new node
        if (size == 0) tail = head;     // special case: new node become tail also
        size++;
    }

    /* Adds element e to the end of the list */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty()) head = newest;   // special case: previously empty list
        else tail.setNext(newest);      // new node after existing tail
        tail = newest;                  // new nodes becomes the tail
        size++;
    }

    /* Removes and returns the first element */
    public E removeFirst() {
        if (isEmpty()) return null;     // nothing to remove
        E answer = head.getElement();
        head = head.getNext();          // will become null if list had only one node
        size--;
        if (size == 0) tail = null;     // special case as list is now empty
        return answer;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SinglyLinkedList other = (SinglyLinkedList) obj; // use nonparameterized type
        if (size != other.size) return false;
        Node walkA = head;          // traverse the primary list
        Node walkB = other.head;    // traverse the secondary list
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false; // mismatch
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true; // if we reach this, everything matched successfully
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // Always use inherited Object.clone() to create the initial copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
        if (size > 0) { // we need independent chain of nodes
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();  // walk through remainder of original list
            Node<E> otherTail = other.head; // remember most recently created node
            while (walk != null) {          // remember most recently created node
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);  // link previous node to this one
                otherTail = newest;
            }
        }
        return other;
    }
}