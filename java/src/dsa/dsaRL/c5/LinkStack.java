package dsa.dsaRL.c5;

class LinkStack {
    private LinkedList llist;

    public LinkStack() {
        llist = new LinkedList();
    }

    public void push(long item) {
        llist.insertFirst(item);
    }
}
