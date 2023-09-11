package chapter09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import chapter09.MagicSquare;

public class MagicSquareTests {
    @Test
    public void testIsMagicSquare() {
        int[][] square1 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        int[][] square2 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 6}};
        int[][] square3 = {{6, 7, 2}, {1, 5, 10}, {8, 3, 4}};

        assertEquals(MagicSquare.isMagicSquare(square1), true);
        assertEquals(MagicSquare.isMagicSquare(square2), false);
        assertEquals(MagicSquare.isMagicSquare(square3), false);
    }
}
