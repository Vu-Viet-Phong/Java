package dsajava2e.c5;

class Link {
    public int iData;              // data item (key)
    public double dData;           // data item
    public Link next;              // next link in list

    public Link(int id, double dd) { 
        iData = id;
        dData = dd; 
    }

    public void displayLink() { // display this link
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class linkedList {
    private Link first; // ref to first item on list

    public linkedList() { 
        first = null; 
    }

    public boolean isEmpty() { return (first==null); }

    // Insert at start of list
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;       // it points to old first link
        first = newLink;            // now first points to this
    }

    /* find link with given key (assumes non-empty list) */
    public Link find(int key) {
        Link current = first;              // start at 'first'
        while(current.iData != key) {      // while no match,
            if (current.next == null)      // if end of list,
                return null;               // didn't find it
            else                           // not end of list,
                current = current.next;    // go to next link
        }
        return current;                    // found it
    }

    // delete first item (assumes list not empty)
    public Link delete(int key) { 
        Link current = first;              // search for link
        Link previous = first;
        while(current.iData != key) {
            if (current.next == null) {
                return null;               // didn't find it
            } else {
                previous = current;        // go to next link
                current = current.next;
            }
        }                                  // found it
        if (current == first) {            // if first link,
            first = first.next;            // change first
        } else {                           // otherwise,
            previous.next = current.next;  // bypass it
        }
       return current;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while(current != null) {    // until end of list,
            current.displayLink();  // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
}