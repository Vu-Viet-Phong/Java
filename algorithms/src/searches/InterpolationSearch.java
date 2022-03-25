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
public class InterpolationSearch {
	/**
     * Interpolation search algorithm implements
     * 
     * @param arr to be searched
     * @param key being searched for
     * @return the location of the key, else return -1
     */
    public static int interpolationSearch(int[] arr, int key) {
		// Find indexes of two corners
		int start = 0, end = (arr.length - 1);
	
		// Since array is sorted, an element present
		// in array must be in range defined by corner
		while (start <= end && key >= arr[start] && key <= arr[end]) {
			// Probing the position with keeping uniform distribution in mind.
			int pos = start + ((end - start) * (key - arr[start])) / (arr[end] - arr[start]);
	
			if (arr[pos] == key) {
				return pos;
			} else if (arr[pos] < key) { 
				start = pos + 1;
			} else { 
				end = pos - 1;
			}
		}

		// If key not found
		return -1;
	}

	public static void main(String[] args) {
        int n = 88;
        int[] arr = {11, 12, 22, 25, 34, 64, 70, 88, 90};
        
        int index = interpolationSearch(arr, n);
        System.out.println("\nNumber " + n + " is at index " + index);
    }
}
