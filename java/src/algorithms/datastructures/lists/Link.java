package algorithms.datastructures.lists;

public class Link {
    public int iData; 
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        iData = id; // initialize data
        dData = dd; // ('next' is automatically set to null
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
