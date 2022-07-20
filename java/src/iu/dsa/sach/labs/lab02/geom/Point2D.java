package iu.dsa.sach.labs.lab02.geom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import iu.dsa.sach.labs.lab02.SpaceMapping;

public class Point2D {
    public static int POINT_HALF_SIZE = 2;  
    private double x;
    private double y;
    
    public Point2D() {
        this.x = 0;
        this.y = 0;
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
        return new Point2D(this.x, this.y);
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

    public static Point2D[] linear(int N, double a, double b, double xMin, double xMax) {
        Point2D[] list = new Point2D[N];
        double step = (xMax - xMin) / (N-1); //xMax inclusive
        double x = xMin;
        
        for(int idx=0; idx < N; idx++) {
            /*answer here*/
            x += step;
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

    @Override
    public String toString(){
        return String.format("P(%6.2f, %6.2f)", this.x, this.y);
    }

    @Override
    public void draw(Graphics g, SpaceMapping mapper) {
        Graphics2D g2 = (Graphics2D) g;
        Point2D point = mapper.logic2Device(this.getX(), this.getY() );
        
        int x = (int)point.getX() - POINT_HALF_SIZE;
        int y = (int)point.getY() - POINT_HALF_SIZE;
        
        g2.setColor(this.faceColor);
        g2.fillRect(/*anwser here*/);
    }    
}