package chapter09.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import chapter09.MagicSquare;

public class MagicSquareTests {
    @Test
    public void testIsMagicSquare() {
        int[][] square1 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};

        assertTrue(MagicSquare.isMagicSquare(square1));

    }

    @Test
    public void testIsNotMagicSquare() {
        int[][] square1 = {{6, 7, 2}, {1, 5, 9}, {10, 3, 4}};
        int[][] square2 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 6}};
        assertFalse(MagicSquare.isMagicSquare(square1));
        assertFalse(MagicSquare.isMagicSquare(square2));
    }


}
