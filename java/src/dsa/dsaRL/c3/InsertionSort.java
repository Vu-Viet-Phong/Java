package dsa.dsaRL.c3;

class InsertionSort {
    private long[] arr;
    private int n; // number of data elements

    public InsertionSort(int maxSize) {
        arr = new long[maxSize];
        n = 0;
    }

    /** Inserts element into array */
    public void insert(long value) {
        arr[n] = value;
        n++;
    }

    /** Insertion sort algorithm implements */
    public void insertionSort() {
        for (int i = 1; i < n; i++) {
            long temp = arr[i];
            int j = i;
            
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                --j;
            }
            arr[j] = temp;
        }
    }

    /* Prints the array */
    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        InsertionSort arr = new InsertionSort(10);

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
        arr.insertionSort();
        arr.display();
    }
}
