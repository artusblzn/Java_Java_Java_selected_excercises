package chapter12.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import chapter12.RecursiveStringConcatenator;

public class RecursiveStringConcatenatorTests {
    @Test
    public void testConcatenateStrings() {
        String[] strings = {"It's", "me", "Mario!"};
        assertEquals(RecursiveStringConcatenator.concatenateStrings(strings), "It's me Mario!");
    }
}
