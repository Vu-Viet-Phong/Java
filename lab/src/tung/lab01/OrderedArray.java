package tung.lab01;

// Demonstrates ordered array class

class OrdArray {
	private long[] arr; 
	private int nElems; 

	public OrdArray(int max) { 
		arr = new long[max];
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	
	/**
	 * Binary search algorithm implements
	 * @param searchKey being searched for
	 * @return the location of the key, else return -1
	 */
	public int find(long searchKey) { // binary search
		int left = 0;
		int right = nElems - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
		
			if (arr[mid] == searchKey) {
				return mid; 
            } else if (arr[mid] < searchKey) {
				left = mid + 1;  // it's in upper half
            } else {
				right = mid - 1; // it's in lower half
            }
		}

		return -1;
	}

	/** Move elements down */
    public void moveElemsDown(int position) {
        for (int i = position; i < nElems; i++) {
            arr[i] = arr[i + 1]; 
        }
        nElems--;
    }

	/** Move elements up */
	public void moveElemsUp(int position) {
        for (int i = nElems; i > position; i--) {
            arr[i] = arr[i - 1]; 
        }
        nElems++;
    }

	/** Put an element into array */
	public void insert(long value) {
		int i;

		for (i = 0; i < nElems; i++) { 
			if (arr[i] > value) { // Find the position to insert
				break;
            }
        }
		moveElemsUp(i); // Move elements up
		arr[i] = value; // insert it
	}

	public boolean delete(long value) {
		int position = find(value);

		if (position == -1) { // can't find it
			return false;
        } else { // found it
			moveElemsDown(position);
            return true;
		}
	}
	
	public long getValueAt(int index) { return arr[index]; }
    public void setValueAt(int index, long value) { arr[index] = value; }

	public static OrdArray merge(OrdArray a, OrdArray b) {
        int length = a.size() + b.size();
        int i = 0, j = 0, k = 0;
		
		// Create new array with sum of length of old 2 ones
		OrdArray c = new OrdArray(length);

		// While the value are not reach the end of any array yet!
		while (j < a.size() && k < b.size()) { 
			// Choose in which the value is suitablie in this incrementing array
            if (a.getValueAt(j) <= b.getValueAt(k)) { 
				// Set the value for new array with smaller value
                c.setValueAt(i, a.getValueAt(j)); 
                j++; // Increse j to consider the next value
            } else {
                c.setValueAt(i, b.getValueAt(k)); // If larger, set another one
                k++;
            }

            c.nElems++;
            i++;
        }

        while (j < a.size()) {
            c.setValueAt(i, a.getValueAt(j));
            c.nElems++;
            i++;
            j++;
        }

        while (k < b.size()) {
            c.setValueAt(i, b.getValueAt(k));
            c.nElems++;
            i++;
            k++;
        }

        return c;
    }

    /** Displays array contents */
    public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(arr[j] + " ");
        }
		System.out.println("");
	}
}

class OrderedApp {
	public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize); 

        /* Insert 10 items */
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
        arr.display(); // display arr

        /* Search for item */
        int searchKey = 55;

        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can not find " + searchKey);
        }

        arr.display(); // display items

        /* Delete items */
        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
        arr.display(); // display items


        long random = 0;

        OrdArray arr1 = new OrdArray(maxSize); // create the array 1
        OrdArray arr2 = new OrdArray(maxSize); // create the array 2
        for (int i = 0; i < 10; i++) {
            random = (long) (Math.random() * 200);
            arr1.insert(random); // Insert 45 random values
        }
        System.out.print("Array1: ");
        arr1.display(); // display items again in array 1

        for (int i = 0; i < 10; i++) {
            random = (long) (Math.random() * 200);
            arr2.insert(random); // Insert 15 random values
        }

        System.out.print("Array2: ");
        arr2.display(); // display items again in array 2

        OrdArray arr3 = OrdArray.merge(arr1, arr2);
        System.out.print("Array3: ");
        arr3.display(); // display items in array 3 after mergin
    }
}