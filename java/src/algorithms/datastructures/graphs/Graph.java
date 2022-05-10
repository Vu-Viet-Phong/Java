package algorithms.datastructures.graphs;

public class Graph {
    private class Vertex {
        public char label;
        public boolean wasVisited;
        
        public Vertex(char lab) {
            label = lab;
            wasVisited = false;
        }
    }

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList; // array of vertices
    private int[][] adjMat;      // adjacency matrix
    private int nVerts;          // current number of vertices

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
}
