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
        System.out.print(vertexList[v].label);
    }

    public void topo() {
        int origin_nVerts = nVerts;

        while (nVerts > 0) {
            int currentVertex = noSuccessors();

            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            arr[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }

        System.out.print("Topologically sorted order: ");
        for (int i = 0; i < origin_nVerts; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    /* Returns vert with no successors (or -1 if no such verts) */
    public int noSuccessors() {
        boolean isEdge;

        for (int row = 0; row < nVerts; row++) {
            isEdge = false;

            for (int col = 0; col < nVerts; col++) {
                if (adjMatrix[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }

            if (!isEdge) {
                return row;
            }
        }

        return -1;
    }

    public void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int i = delVert; i < nVerts - 1; i++) {
                vertexList[i] = vertexList[i + 1];
            }

            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMatrix[row][col] = adjMatrix[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMatrix[row][col] = adjMatrix[row][col + 1];
        }
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort();
        graph.addVertex('A');    // 0
        graph.addVertex('B');    // 1
        graph.addVertex('C');    // 2
        graph.addVertex('D');    // 3
        graph.addVertex('E');    // 4
        graph.addVertex('F');    // 5
        graph.addVertex('G');    // 6
        graph.addVertex('H');    // 7

        graph.addEdge(0, 3);     // AD
        graph.addEdge(0, 4);     // AE
        graph.addEdge(1, 4);     // BE
        graph.addEdge(2, 5);     // CF
        graph.addEdge(3, 6);     // DG
        graph.addEdge(4, 6);     // EG
        graph.addEdge(5, 7);     // FH
        graph.addEdge(6, 7);     // GH

        graph.topo(); 
    }
}
