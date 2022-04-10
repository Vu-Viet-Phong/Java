package iu.oop.labs.lab03.question4;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f; 

    public Point2D() { 
        this.x = 0;
        this.y = 0;
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] temp = {this.x, this.y};
        return temp;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return  "(" + x + ", " + y +")";
    }
}
