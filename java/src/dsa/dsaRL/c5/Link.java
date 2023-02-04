package dsa.dsaRL.c5;

class Link {
    public long data;
    public Link next;

    public Link(long value) {
        data = value;
    }

    public void displayLink() {
        System.out.print("{" + data + "} ");
    }
}
