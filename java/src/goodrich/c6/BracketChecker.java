package goodrich.c6;

import goodrich.c3.SinglyLinkedList;

public class BracketChecker {

    /** Tests if delimiters in the given expression are properly matched. */
    public static boolean isMatched(String expression) {
        final String opening = "({["; // opening delimiters
        final String closing = "]})"; // respective closing delimiters
        Stack<Character> buffer = new LinkedStack();

        for (char c: expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }

                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }

        return buffer.isEmpty(); // were all opening delimiters matched?
    }

    public static boolean isHTMLMatched(String html) {
        final ArrayStack<String> buffer = new LinkedStack<>();
    }
}
