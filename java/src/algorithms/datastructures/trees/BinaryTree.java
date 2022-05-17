package algorithms.datastructures.trees;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;
        
        public void displayNode() {
            System.out.print('{' + data + "}");
        }
    }

    private Node root; 

    public BinaryTree() {
        root = null;
    }

    /**
     * Find a Node with given key
     * @param key given key
     * @return 
     */
    public Node find(int key) {
        Node current = root;

        while (current.data != key) {
            if (current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * Insert node with given value
     * @param value given value
     */
    public void insert(int value) {
        Node newNode = new Node();

        newNode.data = value;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (value < current.data) {
                    current = current.left; 
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Delete node with given key
     * @param key given key
     * @return
     */
    public boolean delete(int key) {
        Node curent = root;
        Node parent = root;
        boolean isLeftChild = true;

        /* Search for node */
        while (curent.data != key) {
            parent = curent;
            if (curent.data > key) {
                isLeftChild = true;
                curent = curent.left;
            } else {
                isLeftChild = false;
                curent = curent.right;
            }

            if (curent == null) {
                return false;
            }
        }

        /* If no children, simply delete it */
        if (curent.left == null &&  curent.right == null) {
            if (curent == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            } 
        } else if (curent.right == null) { // no right child
            if (curent == root) {
                root = curent.left;
            } else if (isLeftChild) {
                parent.left = curent.left;
            } else {
                parent.right = curent.left;
            }
        } else if (curent.left == null) {  // no left child
            if (curent == root) {
                root = curent.right;
            } else if (isLeftChild) {
                parent.right = curent.right;
            } else {
                parent.left = curent.right;
            }
        } else { // two children, so replace with inorder successor
            Node successor = getSuccessor(curent);

            if (curent == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = curent.left;
        }
        return true;
    }

    /**
     * Returns node with next-highest value after delNode
     * goes to right child, then right child's left descendents
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1: 
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: 
                System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3: 
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        
        System.out.println(
        ".................................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int idx = 0; idx < nBlanks; idx++) {
                System.out.print(' ');
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();

                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if(temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    } 
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                
                for (int idx = 0; idx < nBlanks * 2 - 2; idx++) {
                    System.out.print(' ');
                }
            } // end while
            System.out.println();                    
            nBlanks /= 2;
        
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            } 
        } // end while
        System.out.println(
        ".................................................................");
    } // end displayTree()

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        int value;
        BinaryTree bt = new BinaryTree();

        bt.insert(40);
        bt.insert(15);
        bt.insert(29);
        bt.insert(32);
        bt.insert(62);
        bt.insert(15);
        bt.insert(30);
        bt.insert(100);
        bt.insert(64);

        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();
            
            switch (choice) {
                case 's':
                    bt.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    bt.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = bt.find(value);

                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.print("Could not find ");
                        System.out.print(value + '\n');
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = bt.delete(value);

                    if (didDelete) {
                        System.out.print("Deleted " + value + '\n');
                    } else {
                        System.out.print("Could not delete ");
                        System.out.print(value + '\n');
                    }
                    break;
                case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getInt();
                    bt.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main
} // end class