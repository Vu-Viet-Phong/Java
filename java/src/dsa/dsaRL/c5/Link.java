package dsa.dsaRL.c5;

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
