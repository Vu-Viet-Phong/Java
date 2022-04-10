package iu.oop.labs.lab02;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Box {
    private static int width;
    private static int  height;
    private String[][] boxx;
    private static final Box INSTANCE = new Box(5, 10);

    // Private constructor to avoid client applications to use constructor
    private Box() {}

    // Get the box's values
    private Box(int w, int h) {
        width = w;
        height = h;
    }

    public static Box getInstance() {
        return INSTANCE;
    }

    public static int getWidth() { 
        return width; 
    }

    public static int getHeight() { 
        return height; 
    }
    
    // Create a box
    public void createBox() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0) {
                    boxx[i][j] = "|";
                } else if (j == height - 1) {
                    boxx[i][j] = "|\n";
                } else {
                    if (i == 0 || i == width - 1) {
                        boxx[i][j] = "=";
                    } else {
                        boxx[i][j] = " ";
                    }
                }
            }
        }
    }

    // Display a box
    public void displayBox(int counter) {
        System.out.println("Num of parts: " + counter);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(boxx[i][j]);
            }
        }
    }

    public ArrayList<Integer> createParticleX(int n) {
        ArrayList<Integer> listX = new ArrayList<>();

        for (int i = 1; i <= n; i++) { 
            listX.add(generatorRandom(1, width - 2));
        }

        return listX;
    }

    public ArrayList<Integer> createParticleY(int n){
        ArrayList<Integer> listY = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            listY.add(generatorRandom(1, height - 2));
        }
        
        return listY;
    }

    public int generatorRandom(int min, int max) {
        Random rd = new Random();

        if (min >= max) {
            throw new IllegalArgumentException("The maximum must be greater than the minimum");
        }

        return rd.nextInt((max - min) + 1) + min;
    }

    public void run() {
        boxx = new String[width][height];

        // Create the box
        createBox();

        // Create initial Particles in box, randomly 3 particles in box
        ArrayList<Integer> locationX = createParticleX(3);
        ArrayList<Integer> locationY = createParticleY(3);
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Enter \"next\" to initialize the box:  ");
            String input = sc.nextLine();

            if ("next".equalsIgnoreCase(input)) {
                while ("next".equals(input)) {
                    int counter = locationX.size();
                    int maximum = (width - 2) * (height - 2);

                    if (counter < maximum) { // Check if the box is full

                        // Move coordinate X and Y of each particle randomly
                        for (int i = 0; i < locationX.size(); i++) {
                            int moveX = generatorRandom(-1, 1);
                            int moveY = generatorRandom(-1, 1);
                            int locaX = locationX.get(i);
                            int locaY = locationY.get(i);

                            // If particle's X location is at the border
                            if (locaX == 1) {
                                moveX = generatorRandom(0, 1);
                            } else if (locaX == width - 2) {
                                moveX = generatorRandom(-1, 0);
                            }
                            locationX.set(i, locationX.get(i) + moveX);

                            // If particle's Y location is at the border
                            if (locaY == 1) {
                                moveY = generatorRandom(0, 1);
                            } else if (locaY == height - 2) {
                                moveY = generatorRandom(-1, 0);
                            }
                            locationY.set(i, locationY.get(i) + moveY);
                        }

                        // Check collision
                        for (int i = 0; i < locationX.size(); i++) {
                            for (int j = i + 1; j < locationX.size(); j++) {
                                if (locationX.get(i).equals(locationX.get(j)) && 
                                    locationY.get(i).equals(locationY.get(j))) {
                                    locationX.add(generatorRandom(1, width - 2));
                                    locationY.add(generatorRandom(1, height - 2));
                                }
                            }
                        }

                        // Replace box[i][j] with particles locations
                        for (int i = 0; i < locationX.size(); i++) {
                            int x = locationX.get(i);
                            int y = locationY.get(i);
                            boxx[x][y] = "O";
                        }

                        // Display a box
                        displayBox(counter);
                        
                        // Return back " " of the "o" locations
                        for (int i = 0; i < locationX.size(); i++) {
                            int x = locationX.get(i);
                            int y = locationY.get(i);
                            boxx[x][y] = " ";
                        }
                                
                        System.out.println("Type \"next\" to continue the code, \"quit\" to exit program:  ");
                        input = sc.nextLine();
                        if ("quit".equalsIgnoreCase(input)) {
                            System.out.println("Exit program");
                            exit = true;
                        }
                        
                    } else {
                        System.out.print("The box is full");
                        exit = true;
                        break;
                    }
                }
            }
        }    
    }
}
