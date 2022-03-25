package searches;

/**
 * Binary search, also known as half-interval search, logarithmic 
 * search, or binary chop, is a search algorithm that finds the 
 * position of a target value within a sorted array. Binary search 
 * compares the target value to the middle element of the array. 
 * If they are not equal, the half in which the target cannot lie 
 * is eliminated and the search continues on the remaining half, 
 * again taking the middle element to compare to the target value, 
 * and repeating this until the target value is found. If the search 
 * ends with the remaining half being empty, the target is not in 
 * the array.
 * 
 * @link https://en.wikipedia.org/wiki/Binary_search_algorithm
 */
public class BinarySearch {
    /**
     * Binary search algorithm implements
     * 
     * @param arr to be searched
     * @param key being searched for
     * @return the location of the key, else return -1
     */
    public static int binarySearch(int[] arr, int key) {
        int left = 0; 
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
  
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else { 
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 88;
        int[] arr = {11, 12, 22, 25, 34, 64, 70, 88, 90};
        
        int index = binarySearch(arr, n);
        System.out.println("\nNumber " + n + " is at index " + index);
    }
}
