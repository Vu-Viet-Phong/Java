package maths;

public class Average {
    /**
     * Calculate average of a list of numbers
     *
     * @param numbers array to store numbers
     * @return mean of given numbers
     */
    public static double average(double[] numbers) {
        double sum = 0;

        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.length;
    }

    /**
     * Find average value of int array
     *
     * @param array the array contains element and the sum does not excess long value limit
     * @return average value
     */
    public static int average(int[] array) {
        long sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return (int) (sum / array.length);
    }
}
