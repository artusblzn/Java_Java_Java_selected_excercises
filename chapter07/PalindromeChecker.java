/**
 * EXERCISE 7.12 A palindrome is a string that is spelled the same way backward and forward. For
 * example, mom, dad, radar, 727 and able was i ere i saw elba are all examples of palindromes.
 * Write a Java Swing program that lets the user type in a word or phrase and then determines
 * whether the string is a palindrome.
 */

package chapter07;

public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        int wordLength = word.length();

        for (int i = 0; i < wordLength / 2; i++) {
            if (word.charAt(i) != word.charAt(wordLength - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
