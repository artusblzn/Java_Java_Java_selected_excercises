package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import chapter07.PalindromeChecker;

public class PalindromeCheckerTests {

    @ParameterizedTest
    @ValueSource(strings = {"mom", "radar", "able was i ere i saw elba"})
    public void testIsPalindrome(String word) {
        assertTrue(PalindromeChecker.isPalindrome(word));
    }

    @ParameterizedTest
    @ValueSource(strings = {"mon", "adar", "name"})
    public void testIsNotPalindrome(String word) {
        assertFalse(PalindromeChecker.isPalindrome(word));
    }
}
