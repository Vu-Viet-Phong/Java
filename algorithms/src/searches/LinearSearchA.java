package searches;

/**
 * A linear search or sequential search is a method for finding 
 * an element within a list. It sequentially checks each element 
 * of the list until a match is found or the whole list has been 
 * searched.
 * 
 * @link https://en.wikipedia.org/wiki/Linear_search
 */
public class LinearSearchA {
    /**
     * Linear search algorithm implements
     * 
     * @param arr to be searched
     * @param key being searched for
     * @return the location of the key, else return -1
     */
    public static void linearSearch(int[] arr, int key) {
        int left, right;
        int position = 0;

        for (left = 0, right = arr.length - 1; left <= right; left++, right--) {
            // If search_element is found with left variable
            if (arr[left] == key) {
                position = left;
                System.out.println("Element found in Array at " 
                            + (position + 1) + " Position with " 
                            + (left + 1) + " Attempt");
                break;
            }

            // If search_element is found with right variable
            if (arr[right] == key) {
                position = right;
                System.out.println("Element found in Array at " 
                            + (position + 1) + " Position with " 
                            + (arr.length - right) + " Attempt");
                break;
            }
        }

        // If key not found
        if (position == -1) {
            System.out.println("Not found in Array with " + left + " Attempt");
        }
    }
    
    public static void main(String[] args) {
        int n = 22;
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        linearSearch(arr, n);
    }
}
