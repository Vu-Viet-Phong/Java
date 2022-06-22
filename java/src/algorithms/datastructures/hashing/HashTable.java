package algorithms.datastructures.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTable {
    private DataItem[] hashArray;
    private DataItem nonItem;
    private int hashSize;

    public HashTable(int size) {
        hashSize = size;
        hashArray = new DataItem[hashSize];
        nonItem = new DataItem(-1); 
    }
    
    public int hashFunc(int key) {
        return key % hashSize;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashValue = hashFunc(key);

        while (hashArray[hashValue] != null &&
            hashArray[hashValue].getKey() != -1) {
            ++hashValue;            
            hashValue %= hashSize;
        }
        hashArray[hashValue] = item;
    }

    public DataItem delete(int key) {
        int hashValue = hashFunc(key);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem temp = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return temp;
            }
            ++hashValue;
            hashValue %= hashSize;
        }

        return null;
    }

    public DataItem find(int key) {
        int hashValue = hashFunc(key);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            ++hashValue;
            hashValue %= hashSize;
        }
        
        return null;
    } 

    public void displayTable() {
        System.out.print("Table: ");
        for (int i = 0; i < hashSize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }

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
        DataItem dataItem;
        int aKey, size, n, keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        keysPerCell = 10;
        HashTable hashTable = new HashTable(size);
  
        for (int idx = 0; idx < n; idx++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            dataItem = new DataItem(aKey);
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
                    dataItem = new DataItem(aKey);
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
}