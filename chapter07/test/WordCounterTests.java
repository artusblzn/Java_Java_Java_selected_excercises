package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import chapter07.WordCounter;

public class WordCounterTests {
    @Test
    public void testCountWords() {
        assertEquals(WordCounter.countWords("This is how we would ordinarily write a sentence."),
                9);
    }

    @Test
    public void testCountChars() {
        assertEquals(WordCounter.countChars("This is how we would ordinarily write a sentence."),
                40);
    }

    @Test
    public void testGetPercentWordLargerThan6Letters() {
        assertEquals(WordCounter.getPercentWordLargerThan6Letters(
                "This is how we would ordinarily write a sentence."), 200.0 / 9);
    }

    @Test
    public void testGetWordLength() {
        assertEquals(WordCounter.getWordLength("ordinarily"), 10);
    }
}
