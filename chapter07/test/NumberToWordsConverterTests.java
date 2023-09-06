package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import chapter07.NumbersToWordsConverter;

public class NumberToWordsConverterTests {
    @Test
    public void testIsSingleDigitNumber() {
        assertEquals(NumbersToWordsConverter.isSingleDigitNumber("0"), true);
        assertEquals(NumbersToWordsConverter.isSingleDigitNumber("b"), false);
        assertEquals(NumbersToWordsConverter.isSingleDigitNumber("00"), false);
    }

    @Test
    public void testNumberToWord() {
        assertEquals(NumbersToWordsConverter.numberToWord("0"), "zero");
        assertEquals(NumbersToWordsConverter.numberToWord("1"), "one");
        assertEquals(NumbersToWordsConverter.numberToWord("2"), "two");
        assertEquals(NumbersToWordsConverter.numberToWord("3"), "three");
        assertEquals(NumbersToWordsConverter.numberToWord("4"), "four");
        assertEquals(NumbersToWordsConverter.numberToWord("5"), "five");
        assertEquals(NumbersToWordsConverter.numberToWord("6"), "six");
        assertEquals(NumbersToWordsConverter.numberToWord("7"), "seven");
        assertEquals(NumbersToWordsConverter.numberToWord("8"), "eight");
        assertEquals(NumbersToWordsConverter.numberToWord("9"), "nine");
    }

    @Test
    public void testConvertNumbersToWords() {
        assertEquals(NumbersToWordsConverter.convertNumbersToWords("4 score and 7 years ago"),
                "four score and seven years ago");
    }
}
