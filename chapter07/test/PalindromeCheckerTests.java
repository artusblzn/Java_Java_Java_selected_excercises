package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import chapter07.PalindromeChecker;

public class PalindromeCheckerTests {

    @Test
    public void isPalindrome() {
        assertEquals(PalindromeChecker.isPalindrome("mom"), true);
        assertEquals(PalindromeChecker.isPalindrome("radar"), true);
        assertEquals(PalindromeChecker.isPalindrome("name"), false);
        assertEquals(PalindromeChecker.isPalindrome("able was i ere i saw elba"), true);
    }
}
