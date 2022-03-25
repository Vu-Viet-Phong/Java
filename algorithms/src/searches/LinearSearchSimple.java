package searches;

/**
 * A linear search or sequential search is a method for finding 
 * an element within a list. It sequentially checks each element 
 * of the list until a match is found or the whole list has been 
 * searched.
 * 
 * @link https://en.wikipedia.org/wiki/Linear_search
 */
public class LinearSearchSimple {
    /**
     * Linear search algorithm implements
     * 
     * @param arr to be searched
     * @param key being searched for
     * @return the location of the key, else return -1
     */
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        
        // If key not found
        return -1;
    }

    public static void main(String[] args) {
        int n = 22;
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        int result = linearSearch(arr, n);
        if (result == -1) {
            System.out.println("Element is not present in array");
        } else { 
            System.out.println("Element is present at index: " + result);
        }
    }
}
