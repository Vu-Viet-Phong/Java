package searches;

/**
 * @link https://en.wikipedia.org/wiki/Jump_search
 */
public class JumpSearch {
    /**
     * Jump search algorithm implements
     * 
     * @param arr to be searched
     * @param key being searched for
     * @return the location of the key, else return -1
     */
    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length;
        // Finding block size to be jumped 
        int step = (int) Math.sqrt(n);
        
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            
            if (prev >= n) {
                return -1;
            }
        }

        while (arr[prev] < key) {
            prev++;

            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (arr[prev] == key) {
            return prev;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 88;
        int[] arr = {11, 12, 22, 25, 34, 64, 70, 88, 90};
        
        int index = jumpSearch(arr, n);
        System.out.println("\nNumber " + n + " is at index " + index);
    }
}
