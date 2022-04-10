package iu.dsa.sach.labs.lab01;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D() {
        x = 2;
        y = 3;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D oldVector) {
        this.x = oldVector.x;
        this.y = oldVector.y;  
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

}
