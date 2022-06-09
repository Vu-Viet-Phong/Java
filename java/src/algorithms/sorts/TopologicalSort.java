package algorithms.sorts;

public class TopologicalSort {
    private class Vertex {
        public char label;

        public Vertex(char label) {
            this.label = label;
        }
    }

    private final int MAX_VERTS = 20;
    private Vertex[] vertexList[];
    private int[][] adjMatrix;
    private char[] arr;
}
