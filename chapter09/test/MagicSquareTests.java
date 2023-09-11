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

    private static int[][][] provideNotMagicSquares() {
        return new int[][][] {{{6, 7, 2}, {1, 5, 9}, {8, 3, 6}},
                {{6, 7, 2}, {1, 5, 10}, {8, 3, 4}}};
    }

    // Don't know why this test doesn't run.
    // Maybe JUnit does not work well with matrices
    @ParameterizedTest
    @MethodSource("provideNotMagicSquares")
    public void testIsNotMagicSquare(int[][] notAMagicSquare) {
        System.out.println(MagicSquare.isMagicSquare(notAMagicSquare));
        assertFalse(MagicSquare.isMagicSquare(notAMagicSquare));

    }


}
