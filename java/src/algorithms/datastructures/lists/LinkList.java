package algorithms.datastructures.lists;

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public void insertFirst(int value) {
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;

        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public void insert(int value) {
        Link newLink = new Link(value);
        Link previous = null;
        Link current = first;

        while (current != null && value > current.data) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        Link current = first; 

        while (current != null) {
            current.displayLink(); 
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkList theList = new LinkList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);
        theList.displayList(); 

        Link f = theList.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.data);
        } else {
            System.out.println("Can't find link");
        }

        /* Link d = theList.delete(66);
        if (d != null) {
            System.out.println("Deleted link with key " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }

        /* while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.println("Deleted ");
            aLink.displayLink();
            System.err.println("");
        }
        
        theList.displayList(); */

        LinkList theList2 = new LinkList();
        theList2.insert(21);
        theList2.insert(66);
        theList2.insert(54);
        theList2.insert(11);
        theList2.insert(22);
        theList2.displayList(); 
    }
}