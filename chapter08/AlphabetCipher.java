/**
 * EXERCISE 8.12 Design and write a Cipher subclass for a substitution cipher that uses an alphabet
 * from the Alphabet class created in the previous exercise.
 */

package chapter08;

public class AlphabetCipher extends Cipher {
    private Alphabet alphabet;

    public AlphabetCipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    private boolean isLetter(char letter) {
        return (int) letter >= 97 && (int) letter <= 122;
    }

    public String encode(String word) {
        Alphabet plainAlphabet = new Alphabet();

        word = word.toLowerCase();
        StringBuilder encodedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (this.isLetter(letter)) {
                int letterIndexInPlainAlphabet = plainAlphabet.getLetterIndex(letter);
                letter = this.alphabet.getLetter(letterIndexInPlainAlphabet);
            }
            encodedWord.append(letter);
        }
        return encodedWord.toString();
    }

    public String decode(String word) {
        Alphabet plainAlphabet = new Alphabet();

        word = word.toLowerCase();
        StringBuilder decodedWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (this.isLetter(letter)) {
                int letterIndexInAlphabet = this.alphabet.getLetterIndex(letter);
                letter = plainAlphabet.getLetter(letterIndexInAlphabet);
            }
            decodedWord.append(letter);
        }
        return decodedWord.toString();
    }

}
