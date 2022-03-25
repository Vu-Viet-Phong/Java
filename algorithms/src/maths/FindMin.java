package maths;

import java.util.Arrays;

public class FindMin {
    /**
     * Find max of array
     * 
     * @param arr the array contains element
     * @return max value of given array
     */
    public static int findMin(int[] arr) {
        Arrays.sort(arr);

        return arr[0];
    }
}
