package iu.oop.labs.lab03.question2;

public class MyPoint {
    private int x;
    private int y;
    
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(MyPoint point) {
        return Math.sqrt(Math.pow(point.getX() - this.getX(), 2) +
                         Math.pow(point.getY() - this.getY(), 2));
    }
}
