package algorithms.datastructures.graphs;

public class DFSGraph {
    private class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            wasVisited = false;
        }
    }

    private class Stack {
        private final int SIZE = 20;
        private int[] st;
        private int top;

        public Stack() {
            st = new int[SIZE];
            top = -1;
        }

        public void push(int item) {
            st[++top] = item;
        }

        public int pop() {
            return st[top--];
        }

        public int peek() {
            return st[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    private final int MAX_VERTS = 20;
    private int nVerts;
    private int[][] adjMatrix;
    private Vertex[] vertexList;
    private Stack stack;

    public DFSGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int row = 0; row < MAX_VERTS; row++) {
            for (int col = 0; col < MAX_VERTS; col++) {
                adjMatrix[col][row] = 0;
            }
        }
        stack = new Stack();
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

    /** Depth-first search */
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
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

    public int getAdjUnvisitedVertex(int row) {
        for (int col = 0; col < nVerts; col++) {
            if (adjMatrix[row][col] == 1 
                && vertexList[col].wasVisited == false) {
                return col;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}