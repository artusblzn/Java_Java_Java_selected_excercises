/**
 * EXERCISE 12.7 Write a recursive method that will concatenate the elements of an array of String
 * into a single String delimited by blanks.
 */

package chapter12;

public class RecursiveStringConcatenator {
    private String concatenateStrings(String[] strings, int head) {
        if (head == strings.length) {
            return "";
        }
        String space = (head == strings.length - 1) ? "" : " ";
        return strings[head] + space + this.concatenateStrings(strings, head + 1);
    }

    public static String concatenateStrings(String[] strings) {
        return new RecursiveStringConcatenator().concatenateStrings(strings, 0);
    }
}
