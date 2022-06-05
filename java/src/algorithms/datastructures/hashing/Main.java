package algorithms.datastructures.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithms.datastructures.hashing.HashTable.Node;

public class Main {
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

    public static void hashTableApp() throws IOException {
        Node dataItem;
        int aKey, size, n, keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        HashTable hashTable = new HashTable(size);
  
        for (int idx = 0; idx < n; idx++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            dataItem = new Node(aKey);
            hashTable.insert(dataItem);
        }
  
        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            
            switch (choice) {
                case 's':
                    hashTable.displayTable();
                        break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    dataItem = new Node(aKey);
                    hashTable.insert(dataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    hashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    dataItem = hashTable.find(aKey);
                    
                    if (dataItem != null) {
                        System.out.println("Found " + aKey);
                    } else {
                        System.out.println("Could not find " + aKey);
                    }
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public void hashDoubleApp() {

    }

    public void hashChainApp() {

    }
      
    public static void main(String[] args) throws IOException {
        hashTableApp();
        // hashDoubleApp();
        // hashChainApp();;
    }
}