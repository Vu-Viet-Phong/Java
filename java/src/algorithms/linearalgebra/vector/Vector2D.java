package algorithms.linearalgebra.vector;

public class Vector2D {
    public final double EPS = 1e-7;
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
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    /**
     * Returns a new vector that is the vector difference of the
     * current svector and the given vector.
     */
    public Vector2D sub(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

     /**
     * Returns a new vector that is the product by a scalar of the 
     * current vector and the given double.
     */
    public Vector2D mult(double b) {
        return new Vector2D(x * b, y * b);
    }

    /**
     * Returns a new vector that is divided by a scalar of the
     * current vector and the given double.
     */
    public Vector2D div(double b) {
        return new Vector2D(x / b, y / b);
    }

    /**
     * Returns a new vector with the same coordinates as the 
     * current vector.
     */
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
    public static double dot(Vector2D v) {
        return (this.x * v.x + this.y * v.y);
    }

    public static double dot(Vector2D v1, Vector2D v2) {
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

    public double angle(Vector2D v) {
        double lengthV = v.magnitude();

        if ((Math.abs(lengthV) < EPS) || (Math.abs(magnitude()) < EPS)) {
            return 0.0;
        }

        double AdotB = Vector2D.dot(v);
        double cosAB = AdotB / (magnitude() * lengthV);

        return Math.acos(cosAB) * (180.0 / Math.PI);
    }

    public double angle(Vector2D v1, Vector2D v2) {
        double lenA = v1.magnitude();
        double lenB = v2.magnitude();

        if ((Math.abs(lenA) < EPS) || (Math.abs(lenB) < EPS)) {
            return 0.0;
        }

        double AdotB = Vector2D.dot(v1, v2);
        double cosAB = AdotB / (lenA * lenB);

        return Math.acos(cosAB) * (180.0 / Math.PI);
    }

    /** 
     * Returns a string with the x-y coordinates in the format 
     * (x, y). 
     */
    @Override
    public String toString() {
        return "Vector2D(" + x + ", " + y + ")";
    }
}