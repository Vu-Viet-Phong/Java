package iu.dsa.tung.labs.lab07;

import java.util.HashMap;

public class Graph {
    private HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

    public void addEdge(String from, String to, int weight) {
        if (graph.containsKey(from)) {
            if (!graph.get(from).containsKey(to)) {
                graph.get(from).put(to, weight);
            }
        } else {
            HashMap<String, Integer> temp = new HashMap<>();
            graph.put(from, temp);
            graph.get(from).put(to, weight);
        }
    }

    public void figure1() {
        addEdge("A", "B", 11);
        addEdge("A", "G", 3);
        addEdge("B", "A", 11);
        addEdge("B", "C", 11);
        addEdge("B", "F", 5);
        addEdge("C", "B", 11);
        addEdge("C", "D", 3);
        addEdge("D", "C", 3);
        addEdge("D", "E", 6);
        addEdge("D", "N", 6);
        addEdge("E", "F", 9);
        addEdge("E", "D", 6);
        addEdge("E", "J", 3);
        addEdge("F", "B", 5);
        addEdge("F", "G", 6);
        addEdge("F", "E", 9);
        addEdge("G", "A", 3);
        addEdge("G", "F", 6);
        addEdge("G", "H", 3);
        addEdge("G", "T", 9);
        addEdge("H", "G", 3);
        addEdge("H", "I", 5);
        addEdge("H", "R", 8);
        addEdge("H", "S", 7);
        addEdge("I", "H", 5);
        addEdge("I", "L", 3);
        addEdge("J", "E", 3);
        addEdge("J", "K", 5);
        addEdge("J", "M", 3);
        addEdge("K", "J", 5);
        addEdge("K", "N", 4);
        addEdge("L", "I", 3);
        addEdge("L", "R", 3);
        addEdge("L", "Q", 5);
        addEdge("M", "J", 3);
        addEdge("M", "Q", 3);
        addEdge("M", "N", 7);
        addEdge("N", "D", 6);
        addEdge("N", "K", 4);
        addEdge("N", "M", 7);
        addEdge("N", "O", 3);
        addEdge("O", "N", 3);
        addEdge("O", "P", 3);
        addEdge("O", "W", 1);
        addEdge("P", "Q", 3);
        addEdge("P", "O", 3);
        addEdge("P", "Z", 3);
        addEdge("Q", "M", 3);
        addEdge("Q", "P", 3);
        addEdge("Q", "Y", 3);
        addEdge("Q", "L", 5);
        addEdge("R", "L", 3);
        addEdge("R", "H", 8);
        addEdge("R", "S", 3);
        addEdge("R", "X", 3);
        addEdge("S", "H", 7);
        addEdge("S", "R", 3);
        addEdge("S", "T", 3);
        addEdge("S", "V", 1);
        addEdge("T", "G", 9);
        addEdge("T", "S", 3);
        addEdge("T", "U", 1);
        addEdge("U", "T", 1);
        addEdge("U", "V", 3);
        addEdge("V", "U", 3);
        addEdge("V", "S", 1);
        addEdge("V", "X", 1);
        addEdge("W", "Z", 3);
        addEdge("W", "O", 1);
        addEdge("X", "R", 3);
        addEdge("X", "V", 1);
        addEdge("X", "Y", 3);
        addEdge("Y", "Q", 3);
        addEdge("Y", "Z", 3);
        addEdge("Y", "X", 3);
        addEdge("Z", "Y", 3);
        addEdge("Z", "W", 3);
        addEdge("Z", "P", 3);
    }

    public void display() {
        for (String from : graph.keySet()) {
            for (String to : graph.get(from).keySet()) {
                System.out.println(from + " to " + to + ": " + graph.get(from).get(to));
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        String s = String.format(" %50s ", " ");
        System.out.println("Task 3");
        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
        Graph graph = new Graph();
        graph.figure1();
        graph.display();
    }
}