/**
 * EXERCISE 8.10 Design and implement a Cipher subclass to implement the following substitution
 * cipher: Each letter in the alphabet is replaced with a letter from the opposite end of the
 * alphabet: a is replaced with z, b with y, and so forth.
 */

package chapter08;

public class OppositeCipher extends Cipher {
    private boolean isLetter(char letter) {
        return (int) letter >= 97 && (int) letter <= 122;
    }

    private char invertLetter(char letter) {
        return (char) (97 + (122 - (int) letter));
    }

    public String encode(String word) {
        StringBuffer strBuffer = new StringBuffer();
        // There's no point to mantain capital letters in this encryption
        // It would make easier to outsiders understand the pattern
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (this.isLetter(word.charAt(i))) {
                strBuffer.append(this.invertLetter(word.charAt(i)));
            } else {
                strBuffer.append(word.charAt(i));
            }
        }
        return strBuffer.toString();
    }

    public String decode(String word) {
        StringBuffer strBuffer = new StringBuffer();

        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (this.isLetter(word.charAt(i))) {
                strBuffer.append(this.invertLetter(word.charAt(i)));
            } else {
                strBuffer.append(word.charAt(i));
            }
        }
        return strBuffer.toString();
    }
}
