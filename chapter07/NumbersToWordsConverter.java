/**
 * EXERCISE 7.11 Design and write a Java Swing program that searches for single-digit numbers in a
 * text and changes them to their corresponding words. For example, the string “4 score and 7 years
 * ago” would be converted into “four score and seven years ago”.
 * 
 * I'll not implement the Java Swing class.
 */

package chapter07;

import java.util.Arrays;
import java.util.StringTokenizer;

public class NumbersToWordsConverter {

    public static boolean isSingleDigitNumber(String word) {
        Character[] singleDigitNumbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        return word.length() == 1 && Arrays.asList(singleDigitNumbers).contains((word.charAt(0)));
    }

    public static String convertNumbersToWords(String sentence) {
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        StringBuffer buffer = new StringBuffer();

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (NumbersToWordsConverter.isSingleDigitNumber(word)) {
                word = numberToWord(word);
            }
            buffer.append(word + " ");
        }

        // To remove the last space
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

    public static String numberToWord(String number) {
        String[] wordlyNumbers =
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        return wordlyNumbers[(int) number.charAt(0) - 48];
    }
}
