package chapter08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter08.IntegerField;

public class IntegerFieldTests {

    private static Stream<Arguments> provideTextAndIntValue() {
        return Stream.of(Arguments.of("10", 10), Arguments.of("abc", 0));
    }

    @ParameterizedTest
    @MethodSource("provideTextAndIntValue")
    public void testConstructorWithStr(String text, int value) {
        IntegerField intField = new IntegerField(text);
        assertEquals(intField.getText(), Integer.toString(value));
    }

    @Test
    public void testSetText() {
        IntegerField intField = new IntegerField();
        intField.setText("10");
        assertEquals(intField.getText(), "10");
    }

    @Test
    public void testSetTextWithNonNumericString() {
        IntegerField intField = new IntegerField();
        assertThrows(IllegalArgumentException.class, () -> {
            intField.setText("abc");
        });

    }

    @ParameterizedTest
    @MethodSource("provideTextAndIntValue")
    public void testGetInteger(String text, int value) {
        IntegerField intField = new IntegerField(text);
        assertEquals(intField.getInteger(), value);
    }
}
