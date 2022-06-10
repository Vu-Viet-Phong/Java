package algorithms.sorts;

public class TopologicalSort {
    private class Vertex {
        public char label;

        public Vertex(char label) {
            this.label = label;
        }
    }

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int nVerts;
    private char[] arr;

    public TopologicalSort() {
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int row = 0; row < MAX_VERTS; row++) {
            for (int col = 0; col < MAX_VERTS; col++) {
                adjMatrix[row][col] = 0;
            }
        }
        arr = new char[MAX_VERTS];
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void topo() {
        int origin_nVerts = nVerts;

        while (nVerts > 0) {
            int currentVertex = no
        }
    }

    public int noSuccessors() {
        boolean isEdge;
    }
}
