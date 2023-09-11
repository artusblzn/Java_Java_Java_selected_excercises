package chapter06.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import chapter06.PrimeFinder;

public class PrimeFinderTests {

    private PrimeFinder pFinder = new PrimeFinder();

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 23})
    public void testIsPrime(int number) {
        assertTrue(pFinder.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 15, 21})
    public void testIsNotPrime(int number) {
        assertFalse(pFinder.isPrime(number));
    }

    private static Stream<Arguments> provideFindPrimesParameters() {
        return Stream.of(Arguments.of(2, Arrays.asList()), Arguments.of(3, Arrays.asList(2)),
                Arguments.of(4, Arrays.asList(2, 3)), Arguments.of(6, Arrays.asList(2, 3, 5)),
                Arguments.of(8, Arrays.asList(2, 3, 5, 7)),
                Arguments.of(100, Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                        47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)));
    }

    @ParameterizedTest
    @MethodSource("provideFindPrimesParameters")
    public void testFindPrimes(int number, List<Integer> primes) {
        assertEquals(pFinder.findPrimes(number), primes);
    }
}
