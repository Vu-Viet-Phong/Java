package algorithms.datastructures.graphs;

import algorithms.datastructures.queues.Queue;
import algorithms.datastructures.stacks.Stack;

public class Graph {
    private class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            wasVisited = false;
        }
    }

    private final int MAX_VERTS = 20;
    private int nVerts;
    private int[][] adjMatrix;
    private Vertex[] vertexList;
    private Stack stack;
    private Queue queue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int row = 0; row < MAX_VERTS; row++) {
            for (int col = 0; col < MAX_VERTS; col++) {
                adjMatrix[row][col] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    /* Depth-first search */
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /* Breadth-first search */
    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue = new Queue();
        queue.insert(0);
        int v2;

        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /* Minimum spanning tree (depth first) */
    public void mst() {
        vertexList[0].wasVisited = true;
        stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);

            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                stack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /* Returns an unvisited vertex adj to row */
    public int getAdjUnvisitedVertex(int row) {
        for (int col = 0; col < nVerts; col++) {
            if (adjMatrix[row][col] == 1 
                && vertexList[col].wasVisited == false) {
                return col;
            }
        }
        return -1;
    }
    
    public static void dfsApp() {
        Graph graph = new Graph();

        graph.addVertex('A');     // 0 (start for dfs)
        graph.addVertex('B');     // 1
        graph.addVertex('C');     // 2
        graph.addVertex('D');     // 3
        graph.addVertex('E');     // 4

        graph.addEdge(0, 1); // AB
        graph.addEdge(1, 2); // BC
        graph.addEdge(0, 3); // AD
        graph.addEdge(3, 4); // DE
        
        System.out.print("Visits: ");
        graph.dfs(); // depth-first search
        System.out.println();
    }

    public static void bfsApp() {
        Graph graph = new Graph();

        graph.addVertex('A');    // 0  (start for bfs)
        graph.addVertex('B');    // 1
        graph.addVertex('C');    // 2
        graph.addVertex('D');    // 3
        graph.addVertex('E');    // 4

        graph.addEdge(0, 1); // AB
        graph.addEdge(1, 2); // BC
        graph.addEdge(0, 3); // AD
        graph.addEdge(3, 4); // DE

        System.out.print("Visits: ");
        graph.bfs(); // breadth-first search
        System.out.println();
    }

    public static void mstApp() {
        Graph graph = new Graph();

        graph.addVertex('A');     // 0  (start for mst)
        graph.addVertex('B');     // 1
        graph.addVertex('C');     // 2
        graph.addVertex('D');     // 3
        graph.addVertex('E');     // 4

        graph.addEdge(0, 1); // AB
        graph.addEdge(0, 2); // AC
        graph.addEdge(0, 3); // AD
        graph.addEdge(0, 4); // AE
        graph.addEdge(1, 2); // BC
        graph.addEdge(1, 3); // BD
        graph.addEdge(1, 4); // BE
        graph.addEdge(2, 3); // CD
        graph.addEdge(2, 4); // CE
        graph.addEdge(3, 4); // DE

        System.out.print("Minimum spanning tree: ");
        graph.mst(); // minimum spanning tree
        System.out.println();
    }

    public static void main(String[] args) {
        dfsApp();
        bfsApp();
        mstApp();
    }
}