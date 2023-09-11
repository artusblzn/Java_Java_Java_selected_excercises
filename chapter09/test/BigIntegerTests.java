package chapter09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import chapter09.BigInteger;

public class BigIntegerTests {

    private static Stream<Arguments> provideAdditionParameters() {
        return Stream.of(
                Arguments.of("1000000000000000000000001", "1000000000000000000000000",
                        "2000000000000000000000001"),
                Arguments.of("9", "2", "11"), Arguments.of("9", "1", "10"));
    }


    @ParameterizedTest
    @MethodSource("provideAdditionParameters")
    public void testAdd(String augend, String addend, String sum) {
        assertEquals(BigInteger.add(augend, addend), sum);
    }

    private static Stream<Arguments> provideSubtractionParameters() {
        return Stream.of(
                Arguments.of("1000000000000000000000001", "1000000000000000000000000", "1"),
                Arguments.of("175", "82", "93"), Arguments.of("82", "175", "-93"),
                Arguments.of("82", "82", "0"));
    }

    @ParameterizedTest
    @MethodSource("provideSubtractionParameters")
    public void testSubtract(String minuend, String subtraend, String difference) {
        assertEquals(BigInteger.subtract(minuend, subtraend), difference);
    }

    private static Stream<Arguments> provideMultiplicationParameters() {
        return Stream.of(Arguments.of("1", "1", "1"), Arguments.of("10", "1", "10"),
                Arguments.of("1", "10", "10"), Arguments.of("71", "7", "497"));
    }

    @ParameterizedTest
    @MethodSource("provideMultiplicationParameters")
    public void testMultiply(String multiplicand, String multiplier, String product) {
        assertEquals(BigInteger.multiply(multiplicand, multiplier), product);
    }

    @Test
    public void testCompare() {
        assertTrue(BigInteger.compare("10", "1") > 0);
    }

    private static Stream<Arguments> provideDivisionParameters() {
        return Stream.of(Arguments.of("6", "2", "3"), Arguments.of("3", "2", "1"),
                Arguments.of("2", "3", "0"), Arguments.of("10", "2", "5"),
                Arguments.of("10", "3", "3"), Arguments.of("10", "11", "0"));
    }

    @ParameterizedTest
    @MethodSource("provideDivisionParameters")
    public void testDivide(String dividend, String divisor, String quotient) {
        assertEquals(BigInteger.divide(dividend, divisor), quotient);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            BigInteger.divide("1", "0");
        });
    }
}
