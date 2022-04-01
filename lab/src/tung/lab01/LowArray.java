package tung.lab01;

/** Demonstrates array class with low-level interface */
class LowArray {
	private long[] arr;

	public LowArray(int size) {
		arr = new long[size];
	}

	public void setElem(int index, long value) {
		arr[index] = value;
	}

	public long getElem(int index) {
		return arr[index];
	}
}
class LowArrayApp {
	public static void main(String[] args) {
		LowArray arr = new LowArray(100);
		int nElems = 0;
		int j;

		/* Insert 10 items */
		arr.setElem(0, 77); 
		arr.setElem(1, 99);
		arr.setElem(2, 44);
		arr.setElem(3, 55);
		arr.setElem(4, 22);
		arr.setElem(5, 88);
		arr.setElem(6, 11);
		arr.setElem(7, 00);
		arr.setElem(8, 66);
		arr.setElem(9, 33);
		nElems = 10; // now 10 items in array

		/* Display items */
		for (j = 0; j < nElems; j++) {
			System.out.print(arr.getElem(j) + " ");
        }
		System.out.println("");

		/* Search for data item */
		int searchKey = 26; 
		for (j = 0; j < nElems; j++) { // for each element,
			if (arr.getElem(j) == searchKey) { // found item?
				break;
            }
        }

        if (j == nElems) {
			System.out.println("Can't find " + searchKey);
        } else {
			System.out.println("Found " + searchKey);
        }

		/* Delete value 55 */
		searchKey = 55; 
		for (j = 0; j < nElems; j++) {
			if (arr.getElem(j) == searchKey) {
				break;
            }
        }

		/* Higher ones down */
        for (int k = j; k < nElems; k++) { 
			arr.setElem(k, arr.getElem(k + 1));
        }
		nElems--;

		/* Display items */
		for (j = 0; j < nElems; j++) {
			System.out.print(arr.getElem(j) + " ");
        }
        System.out.println("");
	}
}

