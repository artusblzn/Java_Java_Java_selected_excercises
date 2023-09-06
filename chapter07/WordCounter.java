/**
 * EXERCISE 7.10 Design and implement a Java Swing program that lets the user type a document into a
 * TextArea and then provides the following analysis of the document: the number of words in the
 * document, the number of characters in the document, and the percentage of words that have more
 * than six letters.
 * 
 * I'll not implement the Java Swing class.
 */

package chapter07;

import java.util.StringTokenizer;

public class WordCounter {
    public static int countWords(String document) {
        return new StringTokenizer(document).countTokens();
    }

    public static int countChars(String document) {
        StringTokenizer tokenizer = new StringTokenizer(document);
        int totalChars = 0;

        while (tokenizer.hasMoreTokens()) {
            totalChars += WordCounter.getWordLength(tokenizer.nextToken());
        }
        return totalChars;
    }

    public static int getWordLength(String word) {
        int wordLength = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isAlphabetic(word.charAt(i))) {
                wordLength++;
            }
        }
        return wordLength;
    }

    public static double getPercentWordLargerThan6Letters(String document) {
        StringTokenizer tokenizer = new StringTokenizer(document);
        int totalWords = tokenizer.countTokens();
        int totalWordsLargerThan6Chars = 0;

        while (tokenizer.hasMoreTokens()) {
            if (WordCounter.getWordLength(tokenizer.nextToken()) > 6) {
                totalWordsLargerThan6Chars++;
            }
        }

        return totalWordsLargerThan6Chars * 100.0 / totalWords;
    }
}
