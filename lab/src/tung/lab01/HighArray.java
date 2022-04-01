package tung.lab01;

/** Demonstrates array class with high-level interface */
public class HighArray {
	private long[] arr;
	private int nElems;
	
	public HighArray(int max) {
		arr = new long[max];
		nElems = 0;
	}

    /** Find specified value */
	public boolean find(long searchKey) {
        for (int i = 0; i < nElems; i++) { 
			if (arr[i] == searchKey) {
                return true;
            }
        }
        return false;
	}
	
    /** Put an element into array */
	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}

    /** Remove value from array */
    public boolean delete(long value) {
        int i;

        for (i = 0; i < nElems; i++) {
            if (value == arr[i]) {
                break;
            }
        }

        if (i == nElems) { // can’t find it
            return false;
        } else {
            moveElems(i);
            return true;
        }
    }
	
    /**
     * Find the value of the highest key in the array
     * @return the highest value in array
     */
	public long getMax() {
        if (nElems <= 0) {
            return -1;
        } else if (nElems == 1) {
            return arr[0];
        } else {
            long max = arr[0];
            for (int i = 1; i < nElems; i++) {
                if (max < arr[i]) {
                    max = arr[i];   
                }
            }
            return max;
        }
    }

    /** Delete the value of the highest key in the array */
    public void removeMax() {
        delete(getMax());
    }

    /** Remove all duplicates from the array */
    public void noDups() {
        for(int i = 0; i < nElems; i++) {
            long temp = arr[i];
            for (int j = i + 1; j < nElems; j++) {
                if (temp == arr[j]) { // Find duplicated items
                    moveElems(j);
                    System.out.println("Deleted " + temp);
                    j--; // check old position again because array change
                }
            }
        }
    }

    /** Move higher elements down */
    public void moveElems(int position) {
        for (int i = position; i < nElems; i++) {
            arr[i] = arr[i + 1]; 
        }
        nElems--;
    }

    /** Displays array contents */
    public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(arr[j] + " ");
        }
		System.out.println("");
	}
}

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr = new HighArray(maxSize);  

        /* Insert 10 items */
        System.out.println("\nInsert 10 items");
        arr.insert(77);
        arr.insert(99);
        arr.insert(44); 
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();
    
        /* Search for item */
        int searchKey = 35;
        System.out.println("\nSearch for item");
        if (arr.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can not find " + searchKey);
        }

        /* Delete items */
        System.out.println("\nDelete items");
        arr.delete(00);
        arr.delete(55);
        arr.delete(90);
        arr.display();

        /* Show the highest value in the array */
        System.out.println("\nMax value: " + arr.getMax());

        /* Remove the highest value in the array */
        System.out.println("\nRemove the highest value in the array");
        arr.removeMax(); 
        arr.display();

        System.out.println("\nInsert 2 items");
        arr.insert(77);
        arr.insert(77);
        arr.display();
        
        System.out.println("\nRemove all duplicates from the array");
        arr.noDups();
        arr.display();
    }
}