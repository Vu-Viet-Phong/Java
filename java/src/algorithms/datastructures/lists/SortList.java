package algorithms.datastructures.lists;

public class SortList {
    private Link first;

    public SortList() {
        first = null;
    }

    public SortList(Link[] linkArr) {
        first = null;
        for (int idx = 0; idx < linkArr.length; idx++) {
            insert(linkArr[idx]);
        }
    }

    public void insert(Link l) {
        Link previous = null;
        Link current = first;

        while (current != null && l.data > current.data) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = l;
        } else {
            previous.next = l;
        }
        l.next = current;
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }
}