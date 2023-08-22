package chapter01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import chapter01.CaesarCipher;



class CaesarCipherTests {

    @Test
    void testApplyCipherShiftOne() {
        CaesarCipher caesarCipher = new CaesarCipher(1);
        assertEquals(caesarCipher.applyCipher("daze"), "ebaf");
    }

    @Test
    void testApplyCipherShiftFive() {
        CaesarCipher caesarCipher = new CaesarCipher(5);
        assertEquals(caesarCipher.applyCipher("daze"), "ifej");
    }

    @Test
    void testDecipherShiftOne() {
        CaesarCipher caesarCipher = new CaesarCipher(1);
        assertEquals(caesarCipher.decipher("ebaf"), "daze");
    }

    @Test
    void testDecipherShiftFive() {
        CaesarCipher caesarCipher = new CaesarCipher(5);
        assertEquals(caesarCipher.decipher("ifej"), "daze");
    }

}
