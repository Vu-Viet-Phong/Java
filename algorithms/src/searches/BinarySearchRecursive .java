package searches;
/**
 * Binary search, also known as half-interval search, logarithmic search, 
 * or binary chop, is a search algorithm that finds the position of a 
 * target value within a sorted array. Binary search compares the target 
 * value to the middle element of the array. If they are not equal, the 
 * half in which the target cannot lie is eliminated and the search 
 * continues on the remaining half, again taking the middle element to 
 * compare to the target value, and repeating this until the target value 
 * is found. If the search ends with the remaining half being empty, the 
 * target is not in the array.
 * 
 * @link https://en.wikipedia.org/wiki/Binary_search_algorithm
 */
class BinarySearchRecursive  {
    /**
     * Binary search algorithm implements
     * 
     * @param arr The array to make the binary search
     * @param key The number you are looking for
     * @param left The lower bound
     * @param right The upper bound
     * @return the location of the key, else return -1
     */
    public static int binarySearchRecursive(int[] arr, int left, int right, int key) {
        if (right >= 1) { 
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) { 
                return binarySearchRecursive(arr, left, mid - 1, key);
            } else {
                return binarySearchRecursive(arr, mid + 1, right, key);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 88;
        int[] arr = {11, 12, 22, 25, 34, 64, 70, 88, 90};
        
        int index = binarySearchRecursive(arr, 0, arr.length, n);
        System.out.println("\nNumber " + n + " is at index " + index);
    }
}
