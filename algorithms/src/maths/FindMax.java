package maths;

import java.util.Arrays;

public class FindMax {
    /**
     * Find max of array
     * 
     * @param arr the array contains element
     * @return max value of given array
     */
    public static int findMax(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }
}
