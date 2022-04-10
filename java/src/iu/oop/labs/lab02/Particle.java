package iu.oop.labs.lab02;

import java.util.Random;

public class Particle {
    private static int x;
    private static int y;
    private Direction direct;
    
    public enum Direction {
        N, NE, E, SE, S, SW, W, NW;

        static void setEnumValues(Direction d) {
            switch (d) {
                case N: y--; break;
                case E: x++; break;
                case S: y++; break;
                case W: x--; break;
                case NE: x++; y--; break;
                case SE: x++; y++; break;
                case SW: x--; y++; break;
                case NW: x--; y--; break;
            }
        } 
    }

    public Particle() {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direct;
    }

    public Direction randomDirection() {
        Direction[] values = Direction.values();
        int n = values.length;
        int idx = new Random().nextInt(n);
        return values[idx];
    }
}
