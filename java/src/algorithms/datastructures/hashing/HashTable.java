package algorithms.datastructures.hashing;

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

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashValue = hashFunc(key);
        while (hashArray[hashValue] != null &&
        hashArray[hashValue].getKey() != -1) {
            ++hashValue;            // go to next cell
            hashValue %= hashSize;  // wraparound if necessary 
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
}