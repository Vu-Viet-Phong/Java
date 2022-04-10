package algorithms.datastructures.stacks.linkstack;

class Link {
    public int data; 
    public Link next;

    public Link(int value) {
        data = value; 
    }

    public void displayLink() {
        System.out.print("{" + data + "} ");
    }
}

class LinkedList {
    private Link first;

    public LinkedList() {
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

class LinkStack {
    private LinkedList list;

    public LinkStack() {
        list = new LinkedList();
    }

    public void push(int item) {
        list.insertFirst(item);
    }

    public long pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top --> botom): ");
        list.displayList();
    }
}
