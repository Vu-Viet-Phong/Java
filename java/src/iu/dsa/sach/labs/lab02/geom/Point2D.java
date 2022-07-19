package iu.dsa.sach.labs.lab02.geom;

import java.util.Random;

public class Point2D {
    private double x;
    private double y;
    
    public Point2D() {
        x = 0;
        y = 0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D oldPoint) {
        this.x = oldPoint.x;
        this.y = oldPoint.y;
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

    public Point2D clone() {
        return new Point2D(x, y);
    }

    public static Point2D[] generate(int N, double min, double max){
        Random generator = new Random();
        Point2D[] list = new Point2D[N];
        for (int idx = 0; idx < N; idx++){
            double x = min + generator.nextDouble() * (max - min);
            double y = min + generator.nextDouble() * (max - min);
            list[idx] = new Point2D(x,y);
        }
        return list;
    }
    
    public double distanceAB(Point2D pointA, Point2D pointB) {
        double dx = pointA.getX() - pointB.getX();
        double dy = pointA.getY() - pointB.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distanceTo(Point2D point) {
        double dx = getX() - point.getX();
        double dy = getY() - point.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString(){
        return String.format("P(%6.2f, %6.2f)", x, y);
    }
}