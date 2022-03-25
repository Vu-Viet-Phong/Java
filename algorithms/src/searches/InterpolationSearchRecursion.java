package searches;

/**
 * Interpolation search resembles the method by which people search 
 * a telephone directory for a name (the key value by which the book's 
 * entries are ordered): in each step the algorithm calculates where 
 * in the remaining search space the sought item might be, based on 
 * the key values at the bounds of the search space and the value of 
 * the sought key, usually via a linear interpolation.
 * 
 * @link https://en.wikipedia.org/wiki/Interpolation_search
 */
public class InterpolationSearchRecursion {
    /**
     * Interpolation search algorithm implements
     * 
     * @param arr to be searched
     * @param key being searched for
     * @return the location of the key, else return -1
     */
    public static int interpolationSearchRecursion(int[] arr, int lo, int hi, int x) {
        int pos;

        if (lo < hi && x >= arr[lo] && x <= arr[hi]) {
            // Probing the position with keeping uniform distribution in mind
            pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));

            if (arr[pos] == x) { 
                return pos;
            } else if (arr[pos] < x) { 
                return interpolationSearchRecursion(arr, pos + 1, hi, x);
            } else {
                return interpolationSearchRecursion(arr, lo, pos - 1, x);
            }
        }

        // If key not found
        return -1;
    }

    public static void main(String[] args) {
        int n = 88;
        int[] arr = {11, 12, 22, 25, 34, 64, 70, 88, 90};
        
        int index = interpolationSearchRecursion(arr, 0, arr.length, n);
        System.out.println("\nNumber " + n + " is at index " + index);
    }
}
