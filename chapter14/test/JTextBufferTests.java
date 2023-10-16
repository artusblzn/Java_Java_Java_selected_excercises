package chapter14.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import chapter14.JTextBuffer;

public class JTextBufferTests {
    private JTextBuffer buffer;

    @BeforeEach
    public void setUp() {
        this.buffer = new JTextBuffer();
    }

    public static Stream<Arguments> provideNumbers() {
        return Stream.of(Arguments.of("15"), Arguments.of("20"));
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    public void testWrite(String number) {
        this.buffer.write(number);
        assertEquals(this.buffer.getText(), number);
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    public void testWriteNonRiddenBuffer(String number) {
        this.buffer.write("1");
        this.buffer.write(number);
        assertEquals(this.buffer.getText(), "1");
    }

    public static Stream<Arguments> provideInvalidArgumentsToWrite() {
        return Stream.of(Arguments.of(""), Arguments.of("abc"));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidArgumentsToWrite")
    public void testWriteInvalidArguments(String arg) {
        assertThrows(NumberFormatException.class, () -> this.buffer.write(arg));
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    public void testRead(String number) {
        this.buffer.write(number);
        assertEquals(this.buffer.read(), number);
        assertTrue(this.buffer.getText().isEmpty());
    }

}
