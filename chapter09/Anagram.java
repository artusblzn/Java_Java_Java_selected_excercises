/**
 * EXERCISE 9.24 An anagram is a word made by rearranging the letters of another word. For example,
 * act is an anagram of cat, and aegllry is an anagram of allergy. Write a Java program that accepts
 * two words as input and determines if they are anagrams.
 */

package chapter09;

import java.util.Arrays;


public class Anagram {
    public static boolean areAnagrams(String word1, String word2) {
        char[] word1Letters = word1.toCharArray();
        char[] word2Letters = word2.toCharArray();

        Arrays.sort(word1Letters);
        Arrays.sort(word2Letters);

        return Arrays.equals(word1Letters, word2Letters);
    }
}
