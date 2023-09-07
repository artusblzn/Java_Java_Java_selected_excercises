package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import chapter08.OppositeCipher;

public class OppositeCipherTests {
    private OppositeCipher opCipher = new OppositeCipher();

    @Test
    public void testEncode() {
        assertEquals(opCipher.encode("a"), "z");
        assertEquals(opCipher.encode("word"), "dliw");
        assertEquals(opCipher.encode("word."), "dliw.");
        assertEquals(opCipher.encode("Word."), "dliw.");
    }

    @Test
    public void testDecode() {
        assertEquals(opCipher.decode("a"), "z");
        assertEquals(opCipher.decode("word"), "dliw");
        assertEquals(opCipher.decode("word."), "dliw.");
        assertEquals(opCipher.decode("Word."), "dliw.");
    }
}
