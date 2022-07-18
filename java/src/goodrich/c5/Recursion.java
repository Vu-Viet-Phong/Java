public class Recursion {
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0)  {
            throw new IllegalArgumentException();
        } else if {
            return 1;
        } else {
            return n * factorial(n - 1); // recursive case
        }
    }
}
