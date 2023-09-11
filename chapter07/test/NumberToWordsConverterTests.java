package chapter07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import chapter07.NumbersToWordsConverter;

public class NumberToWordsConverterTests {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void testIsSingleDigitNumber(String word) {
        assertTrue(NumbersToWordsConverter.isSingleDigitNumber(word));
    }

    @ParameterizedTest
    @ValueSource(strings = {"00", "11", "b", "bb"})
    public void testIsNotSingleDigitNumber(String word) {
        assertFalse(NumbersToWordsConverter.isSingleDigitNumber(word));
    }

    private static Stream<Arguments> provideNumbersToWordParameters() {
        return Stream.of(Arguments.of("0", "zero"), Arguments.of("1", "one"),
                Arguments.of("2", "two"), Arguments.of("3", "three"), Arguments.of("4", "four"),
                Arguments.of("5", "five"), Arguments.of("6", "six"), Arguments.of("7", "seven"),
                Arguments.of("8", "eight"), Arguments.of("9", "nine"));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersToWordParameters")
    public void testNumberToWord(String number, String word) {
        assertEquals(NumbersToWordsConverter.numberToWord(number), word);
    }

    @Test
    public void testConvertNumbersToWords() {
        assertEquals(NumbersToWordsConverter.convertNumbersToWords("4 score and 7 years ago"),
                "four score and seven years ago");
    }
}
