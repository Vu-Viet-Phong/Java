package dsajava2e.c5;

class Link {
    public long dData; // data item
    public Link next;  // next link in list

    public Link(long dd) { 
       dData = dd; 
    }

    public void displayLink() { // display this link
        System.out.print(dData + " "); 
    }
}

public class LinkedList {

}
