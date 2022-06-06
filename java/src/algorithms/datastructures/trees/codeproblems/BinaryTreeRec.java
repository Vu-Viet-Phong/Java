package algorithms.datastructures.trees.codeproblems;

public class BinaryTreeRec {
    /* A binary tree node */
    private static class Node {
        private int data;
        private Node left, right;
        
        Node (int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static Node root;

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    /* Find minimum value node in Binary Search Tree */
    public int minValue(Node node) {
        Node current = node;
        while (current.left  != null) {
            current = current.left;
        }
        return current.data;
    }

    public static void main(String[] args) {
        BinaryTreeRec tree = new BinaryTreeRec();
        Node root = null;

        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);

        System.out.println("Minimum value of BST is " + tree.minValue(root));
    }
}
