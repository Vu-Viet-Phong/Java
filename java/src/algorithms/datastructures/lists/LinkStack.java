package algorithms.datastructures.lists;

class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
    }

    public int deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp.data;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

/**
 * Implements a Stack using an Linked List
 */
public class LinkStack {
    private LinkList list;

    public LinkStack() {
        list = new LinkList();
    }

    public void push(int item) {
        list.insertFirst(item);
    }

    public int pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top --> botom): ");
        list.displayList();
    }

    public static void main(String[] args) {
        LinkStack lstack = new LinkStack();

        lstack.push(20);
        lstack.push(40);
        lstack.displayStack();

        lstack.push(60);
        lstack.push(80);
        lstack.displayStack();

        lstack.pop();
        lstack.pop();
        lstack.displayStack();
    }
}
