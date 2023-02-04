package dsa.practices.linkedlist;

class Node {
    public long data;
    public Node next;

    public Node(long value) {
        data = value;
    }

    public void displayNode() {
        System.out.print("{" + data + "} ");
    }
}
