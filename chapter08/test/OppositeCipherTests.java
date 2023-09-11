package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter08.OppositeCipher;

public class OppositeCipherTests {
    private OppositeCipher opCipher = new OppositeCipher();

    private static Stream<Arguments> provideMessageAndCipheredMessage() {
        return Stream.of(Arguments.of("a", "z"), Arguments.of("word", "dliw"),
                Arguments.of("word.", "dliw."), Arguments.of("Word.", "dliw."));
    }

    @ParameterizedTest
    @MethodSource("provideMessageAndCipheredMessage")
    public void testEncode(String message, String cipheredMessage) {
        assertEquals(opCipher.encode(message), cipheredMessage);
    }

    @ParameterizedTest
    @MethodSource("provideMessageAndCipheredMessage")
    public void testDecode(String message, String cipheredMessage) {
        assertEquals(opCipher.decode(message), cipheredMessage.toLowerCase());
    }
}
