package algorithms.datastructures.hashing;

/* Demonstrates hash table with double hashing */
public class HashDouble {
    public static class Node {
        private int key;

        public Node(int data) {
            key = data;
        }

        public int getKey() {
            return key;
        }
    }

    private Node[] hashArray;
    private int hashSize;
    private Node nonItem;

    public HashDouble(int size) {
        hashSize = size;
        hashArray = new Node[hashSize];
        nonItem = new Node(-1);
    }

    public int hashFunc1(int key) {
        return key % hashSize;
    }

    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(int key, Node item) {
        int hashValue = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashValue] != null &&
        hashArray[hashValue].getKey() != -1) {
            hashValue += stepSize;
            hashValue %=  hashSize;
        }
        hashArray[hashValue] = item;
    }

    public Node delete(int key) {
        int hashValue = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() != key) {
                Node temp = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return temp;
            }
            hashValue += stepSize;
            hashValue %= hashSize;
        }
        return null;
    }

    public Node find(int key) {
        int hashValue = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue += stepSize;
            hashValue %= hashSize;
        }
        return null;
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int idx = 0; idx < hashSize; idx++) {
            if (hashArray[idx] != null) {
                System.out.print(hashArray[idx].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }
}
