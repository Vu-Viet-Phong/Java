package algorithms.datastructures.hashing;

import algorithms.datastructures.lists.Link;

/* Demonstrates hash table with separate chaining */
public class HashChain {
    public static class Node {
        private int key;
        public Node next;

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void displayNode() {
            System.out.print(key + " ");
        }
    }

    public static class LinkedList {
        private Node first;

        public void LinkedList() {
            first = null;
        }

        public void insert(Node node) {
            int key = node.getKey();
            Node previous = null;
            Node current = first;

            while (current != null && key > current.getKey()) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                first = node;
            } else {
                previous.next = node;
            }
            node.next = current;
        }

        public void delete(int key) {
            Node previous = null;
            Node current = first;

            while (current != null && key != current.getKey()) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
        }

        public Node find(int key) {
            Node current = first;

            while (current != null && current.getKey() <= key) {
                if (current.getKey() == key) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public void displayLinkedList() {
            System.out.print("List (first --> last): ");
            Node current = first;

            while (current != null) {
                current.displayNode();
                current = current.next;
            }
            System.out.println("");
        }
    }

    private LinkedList[] hashArray;
    private int hashSize;

    public HashChain(int size) {
        hashSize = size;
        hashArray = new LinkedList[hashSize];
        for (int idx = 0; idx < hashSize; idx++) {
            hashArray[idx] = new LinkedList();
        }
    }

    public int hashFunc(int key) {
        return key % hashSize;
    }

    public void insert(Node node) {
        int key = node.getKey();
        int hashValue = hashFunc(key);
        hashArray[hashValue].insert(node);
    }

    public void delete(int key) {
        int hashValue = hashFunc(key);
        hashArray[hashValue].delete(key);
    }

    public Node find(int key) {
        int hashValue = hashFunc(key);
        return hashArray[hashValue].find(key);
    }

    public void displayTable() {
        for (int idx = 0; idx < hashSize; idx++) {
            System.out.print(idx + ". ");
            hashArray[idx].displayLinkedList();
        }
    }
}