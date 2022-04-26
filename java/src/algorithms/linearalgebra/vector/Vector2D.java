package algorithms.linearalgebra.vector;

public class Vector2D {
    private double x;
    private double y; 

    /** Constructs a zero vector (with coordinates(0, 0)). */
    public Vector2D() {
        x = 0;
        y = 0;
    }

    /** Constructs a vector from given double x-y coordinates. */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Constructs a vector from old vector. */
    public Vector2D(Vector2D oldVector) {
        this.x = oldVector.x;
        this.y = oldVector.y;
    }

    /**
     * Returns a new vector that is the vector sum of the current
     * vector and the given vector.
     */
    public Vector2D add(Vector2D v) {
        double vx = v.x + this.x;
        double vy = v.y + this.y;
        return new Vector2D(vx, vy);
    }

    public Vector2D clone() {
        return new Vector2D(x, y);
    }

    /**
     * Returns the distance between the current vector and the 
     * given vector.
     */
    public double distanceTo(Vector2D v) {
        double vx = v.x - this.x;
        double vy = v.y - this.y;
        return Math.sqrt(vx * vx + vy * vy);
    }

    /** 
     * Returns the scalar product (dot product) of the current 
     * vector with the given vector.
     */
    public double dot(Vector2D v) {
        return (this.x * v.x + this.y * v.y);
    }

    public double dot(Vector2D v1, Vector2D v2) {
        return (v1.x * v2.x + v1.y + v2.y);
    }
    
    /* Modidies the vector to unit magnitude. */
    public void normalize() {
        x /= magnitude();
        y /= magnitude();
    }

    /** 
     * Returns a new vector with magnitude 1 in the direction of 
     * the given vector.
     */
    public Vector2D getNormalized() {
        return new Vector2D(x / magnitude(), y / magnitude2());
    }

    /** Returns the magnitude (length) of the vector. */
    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    /** 
     * Returns the square of the magnitude, without squareroot 
     * calculation.
     */
    public double magnitude2() {
        return (x * x + y * y);
    }

    /**
     * 
     */
    public Vector2D getPerp() {
        return new Vector2D(-y, x);
    }

    @Override
    public String toString() {
        return "Vector2D[" + x + ", " + y + "]";
    }
}
