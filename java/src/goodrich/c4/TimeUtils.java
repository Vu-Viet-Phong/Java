package goodrich.c4;

public class TimeUtils {
    /** Uses repeated concatenation to compose a String with n copies of character c. */
    public static String repeat1(char c, int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            answer += c;
        }

        return answer;
    }

    /** Uses StringBuilder to compose a String with n copies of character c. */
    public static String repeat2(char c, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();    // record the starting time
        repeat1('*', 50000);
        long endTime = System.currentTimeMillis();      // reord the ending time
        long elapsed = endTime - startTime;             // compute the elapsed time
        System.out.println(elapsed);
    }
}
