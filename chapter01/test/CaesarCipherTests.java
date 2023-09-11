package chapter01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter01.CaesarCipher;



class CaesarCipherTests {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(Arguments.of(1, "daze", "ebaf"), Arguments.of(5, "daze", "ifej"));
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void testApplyCipher(int shift, String message, String ciphedMessage) {
        CaesarCipher caesarCipher = new CaesarCipher(shift);
        assertEquals(caesarCipher.applyCipher(message), ciphedMessage);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void testDecipher(int shift, String message, String ciphedMessage) {
        CaesarCipher caesarCipher = new CaesarCipher(shift);
        assertEquals(caesarCipher.decipher(ciphedMessage), message);
    }
}
