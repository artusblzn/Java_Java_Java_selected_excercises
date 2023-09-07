package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import chapter08.AlphabetCipher;
import chapter08.Alphabet;

public class AlphabetCipherTests {
    private AlphabetCipher alphabetCipher;

    @Test
    public void testEncode() {
        alphabetCipher = new AlphabetCipher(new Alphabet("zebra"));
        assertEquals(alphabetCipher.encode("word"), "vmpr");
        assertEquals(alphabetCipher.encode("word."), "vmpr.");
        assertEquals(alphabetCipher.encode("Word."), "vmpr.");
    }

    @Test
    public void testDecode() {
        alphabetCipher = new AlphabetCipher(new Alphabet("zebra"));
        assertEquals(alphabetCipher.decode("vmpr"), "word");
        assertEquals(alphabetCipher.decode("vmpr."), "word.");
        assertEquals(alphabetCipher.decode("Vmpr."), "word.");
    }

}
