/**
 * EXERCISE 1.13 A Caesar cipher is a secret code in which each letter of the alphabet is shifted by
 * N letters to the right, with the letters at the end of the alphabet wrapping around to the
 * beginning. For example, if N is 1, when we shift each letter to the right, the word daze would be
 * written as ebaf. Note that the z has wrapped around to the beginning of the alphabet. Describe an
 * algorithm that can be used to create a Caesar encoded message with a shift of 5.
 * 
 * EXERCISE 1.14 Suppose you received the message, “sxccohv duh ixq,” which you know to be a Caesar
 * cipher. Figure out what it says and then describe an algorithm that will always find what the
 * message said regardless of the size of the shift that was used.
 */


package chapter01;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

// Instead of just describing an algorithm, here we're going to implement the algorithm.
public class CaesarCipher {
    private int shift;

    public CaesarCipher() {
        this.shift = 5;
    }

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    // Solution to 1.13
    public String applyCipher(String message) {
        CharacterIterator it = new StringCharacterIterator(message);
        String ciphedMessage = "";

        while (it.current() != it.DONE) {
            int asciiValue = (int) it.current();
            asciiValue += this.shift;
            // Verify if the shift made it goes from letters to symbols
            if (asciiValue > (int) 'z') {
                asciiValue -= 26; // That makes possible go from z to a
            }
            ciphedMessage += (char) asciiValue;
            it.next();
        }
        return ciphedMessage;
    }

    // Solution to 1.14
    public String decipher(String ciphedMessage) {
        CharacterIterator it = new StringCharacterIterator(ciphedMessage);
        String originalMessage = "";

        while (it.current() != it.DONE) {
            int asciiValue = (int) it.current();
            asciiValue -= this.shift;
            // Verify if the shift made it goes to capital letters
            if (asciiValue < (int) 'a') {
                asciiValue += 26; // That makes possible go from a to z
            }
            originalMessage += (char) asciiValue;
            it.next();
        }
        return originalMessage;

    }

}
