package iu.oop.labs.lab01.question3;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Compute the distance from the current point and the given target point
     * 
     * @param targetPoint the given target point
     * @return distance from the current point and the given target point
     */
    public double distance(Point targetPoint) {
        return Math.sqrt(Math.pow(targetPoint.x - this.x, 2) + 
                         Math.pow(targetPoint.y - this.y, 2));
    }
}
