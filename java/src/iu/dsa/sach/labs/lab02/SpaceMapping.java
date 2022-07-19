package iu.dsa.sach.labs.lab02;

public class SpaceMapping {
    private int minDevX, maxDevX;
    private int minDevY, maxDevY;
    private double minLogX, maxLogX;
    private double minLogY, maxLogY;

    public SpaceMapping() {
        this.minDevX = 0;
        this.maxDevX = 800;
        this.minDevY = 0;
        this.maxDevY = 600;

        this.minLogX = 0;
        this.maxLogX = 1.0;
        this.minLogY = 0;
        this.maxLogY = 1.0;
    }
}
