package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import chapter08.Alphabet;

public class AlphabetTests {
    @Test
    public void testCreateAlphabet() {
        Alphabet alpha = new Alphabet("zebra");
        assertEquals(alpha.getAlphabet(), "zebracdfghijklmnopqstuvwxy");


        alpha = new Alphabet("zebbbra");
        assertEquals(alpha.getAlphabet(), "zebracdfghijklmnopqstuvwxy");


    }
}
