package dsa.dsaRL.c5;

public class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    /** Returns true if list is empty */
    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int value) {
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
    }


}
