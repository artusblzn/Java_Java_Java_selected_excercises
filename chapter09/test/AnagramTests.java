package chapter09.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import chapter09.Anagram;

public class AnagramTests {

    @Test
    public void testAreAnagrams() {
        assertTrue(Anagram.areAnagrams("cat", "act"));
        assertFalse(Anagram.areAnagrams("cat", "acct"));
    }
}
