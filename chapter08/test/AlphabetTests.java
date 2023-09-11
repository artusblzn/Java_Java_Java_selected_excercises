package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter08.Alphabet;

public class AlphabetTests {

    private static Stream<Arguments> provideKeywordAndAlphabetString() {
        return Stream.of(Arguments.of("zebra", "zebracdfghijklmnopqstuvwxy"),
                Arguments.of("zeebbra", "zebracdfghijklmnopqstuvwxy"));
    }

    @ParameterizedTest
    @MethodSource("provideKeywordAndAlphabetString")
    public void testCreateAlphabet() {
        Alphabet alpha = new Alphabet("zebra");
        assertEquals(alpha.getAlphabet(), "zebracdfghijklmnopqstuvwxy");


        alpha = new Alphabet("zebbbra");
        assertEquals(alpha.getAlphabet(), "zebracdfghijklmnopqstuvwxy");


    }
}
