package algorithms.searches;

/**
 * A linear search or sequential search is a method for finding 
 * an element within a list. It sequentially checks each element 
 * of the list until a match is found or the whole list has been 
 * searched.
 * 
 * @link https://en.wikipedia.org/wiki/Linear_search
 */
public class LinearSearch {
    /**
     * Linear search algorithm implements
     * 
     * @param arr to be searched
     * @param key being searched for
     * @return the location of the key, else return -1
     */
    public static int linearSearch(int[] arr, int key) {
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 22;
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        int index = linearSearch(arr, n);
        if (index == -1) {
            System.out.println("Element is not present in array");
        } else { 
            System.out.println("Element is present at index: " + index);
        }
    }
}
