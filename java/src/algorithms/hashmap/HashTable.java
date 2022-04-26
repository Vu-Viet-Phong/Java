package algorithms.hashmap;

public class HashTable {
    private int arraySize;
    private DataItem[] hashArray;   // array holds hash table
    private DataItem nonItem;       // for deleted items

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // deleted item key is -1
    }

    public int hashFunc(int key) {
        return key % arraySize; // hash function
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public void displayTable() {
        System.out.print("Table");
        for (int idx = 0; idx < arraySize; idx++) {
            if (hashArray[idx] != null) {
                System.out.println(hashArray[idx].getKey() + " ");
            } else {
                System.out.print("** ");
            }   
        }
        System.out.println("");
    }
}
