package dsa.dsaRL.c5;

/** Implements a Stack using a Linked List */
class LinkStack {
    private LinkedList llist;

    public LinkStack() {
        llist = new LinkedList();
    }

    /** Adds an element to the top of the stack */
    public void push(long item) {
        llist.insertFirst(item);
    }

    /**
    * Removes the top element of the stack
    * @returns deleted element link
    */
    public Link pop() {
        return llist.deleteFirst();
    }

    /** Returns true if the stack is empty */
    public boolean isEmpty() {
        return llist.isEmpty();
    }

    public void displayStack() {
        llist.displayList();
    }

    public static void main(String[] args) {
        LinkStack lstack = new LinkStack();

        lstack.push(20);
        lstack.push(40);
        lstack.push(60);
        lstack.push(80);
        lstack.displayStack();

        while (!lstack.isEmpty()) {
            Link link = lstack.pop();
            System.out.print("Pop:");
            link.displayLink();
            lstack.displayStack();
        }
    }
}