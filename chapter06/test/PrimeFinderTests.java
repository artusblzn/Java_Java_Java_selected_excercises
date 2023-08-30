package chapter06.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import chapter06.PrimeFinder;

public class PrimeFinderTests {

    private PrimeFinder pFinder = new PrimeFinder();

    @Test
    public void testIsPrime() {
        assertEquals(pFinder.isPrime(2), true);
        assertEquals(pFinder.isPrime(3), true);
        assertEquals(pFinder.isPrime(4), false);
        assertEquals(pFinder.isPrime(5), true);
        assertEquals(pFinder.isPrime(6), false);
        assertEquals(pFinder.isPrime(7), true);
        assertEquals(pFinder.isPrime(8), false);
        assertEquals(pFinder.isPrime(9), false);
        assertEquals(pFinder.isPrime(15), false);
        assertEquals(pFinder.isPrime(21), false);
        assertEquals(pFinder.isPrime(23), true);
    }

    @Test
    public void testFindPrimes() {
        assertEquals(pFinder.findPrimes(2), Arrays.asList());
        assertEquals(pFinder.findPrimes(3), Arrays.asList(2));
        assertEquals(pFinder.findPrimes(4), Arrays.asList(2, 3));
        assertEquals(pFinder.findPrimes(6), Arrays.asList(2, 3, 5));
        assertEquals(pFinder.findPrimes(8), Arrays.asList(2, 3, 5, 7));
        assertEquals(pFinder.findPrimes(100), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
    }
}
