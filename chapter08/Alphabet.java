/**
 * EXERCISE 8.11 One way to design a substitution alphabet for a cipher is to use a keyword to
 * construct the alphabet. For example, suppose the keyword is “zebra.” You place the keyword at the
 * beginning of the alphabet, and then fill out the other 21 slots with remaining letters, giving
 * the following alphabet:
 * 
 * Cipher alphabet: zebracdfghijklmnopqstuvwxy
 * 
 * Plain alphabet: abcdefghijklmnopqrstuvwxyz
 * 
 * Design and implement an Alphabet class for constructing these kinds of substitution alphabets. It
 * should have a single public method that takes a keyword String as an argument and returns an
 * alphabet string. Note that an alphabet cannot contain duplicate letters, so repeated letters in a
 * keyword like “xylophone” would have to be removed.
 */

package chapter08;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    private List<Character> alphabet;

    // If no keyword is passed, creates a regular alphabet
    public Alphabet() {
        this.alphabet = new ArrayList<Character>();

        for (int i = 0; i < 26; i++) {
            this.alphabet.add((char) (97 + i));
        }
    }

    public Alphabet(String keyword) {
        this.alphabet = new ArrayList<Character>();
        // Add once each unique letter in the keyword
        for (int i = 0; i < keyword.length(); i++) {
            if (!this.alphabet.contains(keyword.charAt(i))) {
                this.alphabet.add(keyword.charAt(i));
            }
        }
        // Add the rest of the letters
        for (int i = 0; i < 26; i++) {
            if (!this.alphabet.contains((char) (97 + i))) {
                this.alphabet.add((char) (97 + i));
            }
        }
    }

    public String getAlphabet() {
        StringBuilder alphabet = new StringBuilder();
        for (Character letter : this.alphabet) {
            alphabet.append(letter);
        }
        return alphabet.toString();
    }

    public int getLetterIndex(char letter) {
        return this.alphabet.indexOf(letter);
    }

    public char getLetter(int index) {
        return this.alphabet.get(index);
    }
}
