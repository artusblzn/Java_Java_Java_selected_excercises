package chapter09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import chapter09.BigInteger;

public class BigIntegetTests {

    @Test
    public void testAdd() {
        String value1 = "1000000000000000000000000"; // 25 digit integer
        String value2 = "1000000000000000000000001"; // 25 digit integer

        assertEquals(BigInteger.add(value1, value2), "2000000000000000000000001");
        assertEquals(BigInteger.add("9", "2"), "11");
        assertEquals(BigInteger.add("9", "1"), "10");

    }

    @Test
    public void testSubtract() {
        String value1 = "1000000000000000000000001"; // 25 digit integer
        String value2 = "1000000000000000000000000"; // 25 digit integer

        assertEquals(BigInteger.subtract(value1, value2), "1");
        assertEquals(BigInteger.subtract("175", "82"), "93");
        assertEquals(BigInteger.subtract("82", "175"), "-93");
        assertEquals(BigInteger.subtract("82", "82"), "0");
    }

    @Test
    public void testMultiply() {
        assertEquals(BigInteger.multiply("1", "1"), "1");
        assertEquals(BigInteger.multiply("10", "1"), "10");
        assertEquals(BigInteger.multiply("1", "10"), "10");
        assertEquals(BigInteger.multiply("71", "7"), "497");
    }

    @Test
    public void testCompare() {
        assertTrue(BigInteger.compare("10", "1") > 0);
    }

    @Test
    public void testDivide() {
        assertEquals(BigInteger.divide("6", "2"), "3");
        assertEquals(BigInteger.divide("3", "2"), "1");
        assertEquals(BigInteger.divide("2", "3"), "0");
        assertEquals(BigInteger.divide("10", "2"), "5");
        assertEquals(BigInteger.divide("10", "3"), "3");
        assertEquals(BigInteger.divide("10", "11"), "0");
    }
}
