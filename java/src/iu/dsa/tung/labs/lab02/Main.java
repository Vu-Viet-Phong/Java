package iu.dsa.tung.labs.lab02;

public class Main {
    public static long[] test(Array arr) {
        Array arr1 = arr.clone();
        Array arr2 = arr.clone();
        Array arr3 = arr.clone();

        long startTime, endTime;
        long[] duration = new long[3];

        /* --- Bubble sort --- */
        startTime = TimeUtils.now();
		arr1.bubbleSort();
		endTime = TimeUtils.now();
        duration[0] = endTime - startTime;

        /* --- Selection sort --- */
		startTime = TimeUtils.now();
		arr2.selectionSort();
		endTime = TimeUtils.now();
        duration[1] = endTime - startTime;
		
		/* --- Insertion sort --- */
		startTime = TimeUtils.now();
		arr3.insertionSort();
		endTime = TimeUtils.now();
        duration[2] = endTime - startTime;

        return duration;
    }

    public static void measure() {
        int[] maxSize = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        Array arr;

        String s = String.format("| %8s | %11s | %14s | %14s |", 
                        "Max Size", "Bubble Sort", "Selection Sort", "Insertion Sort");
        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
        System.out.println(s);

        for (int idx = 0; idx < maxSize.length; idx++) {
            arr = new Array(maxSize[idx]);
            arr.randomInit(maxSize[idx]);
            // arr.bubbleSort();
            // arr.inverse();
            long[] duration = test(arr);

            s = String.format("| %8s | %8s ms | %11s ms | %11s ms |", 
                        maxSize[idx], duration[0], duration[1], duration[2]);
            System.out.println(new String(new char[s.length()]).replace('\0', '-'));
            System.out.println(s);
        }

        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
    }

    public static void main(String[] args) {
        measure();  
    }
}
