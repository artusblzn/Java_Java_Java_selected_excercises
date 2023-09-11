package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter08.AlphabetCipher;
import chapter08.Alphabet;

public class AlphabetCipherTests {
    private AlphabetCipher alphabetCipher;

    private static Stream<Arguments> provideKeywordMsgAndCipheredMsg() {
        return Stream.of(Arguments.of("zebra", "word", "vmpr"),
                Arguments.of("zebra", "word.", "vmpr."), Arguments.of("zebra", "Word.", "vmpr."));
    }

    @ParameterizedTest
    @MethodSource("provideKeywordMsgAndCipheredMsg")
    public void testEncode(String keyword, String message, String ciphedMsg) {
        alphabetCipher = new AlphabetCipher(new Alphabet(keyword));
        assertEquals(alphabetCipher.encode(message), ciphedMsg);
    }

    @ParameterizedTest
    @MethodSource("provideKeywordMsgAndCipheredMsg")
    public void testDecode(String keyword, String message, String ciphedMsg) {
        alphabetCipher = new AlphabetCipher(new Alphabet(keyword));
        assertEquals(alphabetCipher.decode(ciphedMsg), message.toLowerCase());
    }

}
